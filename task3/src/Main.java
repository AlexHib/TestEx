import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args){
        if(args.length == 2){
            String testsFile = args[0];
            String valuesFile = args[1];
            action(testsFile,valuesFile);
        }
    }

    public static void action(String testsFile, String valuesFile){
        File fileTest = new File(testsFile);
        File fileValue = new File(valuesFile);

        ObjectMapper objectMapper = new ObjectMapper();
        Tests tests = null;
        Values values = null;
        try {
            tests = objectMapper.readValue(fileTest, Tests.class);
            values = objectMapper.readValue(fileValue, Values.class);
        }catch(JsonParseException e){
            e.printStackTrace();
        }catch(JsonMappingException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        fillForm(tests.tests, values);
        File result = new File("report.json");
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);       //игнор нулевых ссылок

        try {
            result.createNewFile();
            objectMapper.writeValue(result, tests);
        }catch(JsonMappingException e){
            e.printStackTrace();
        }catch(JsonGenerationException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }



    }

    public static void fillForm(List<Test> tests, Values values){
        if(tests == null) return;
        for(Test test: tests){
            test.value = values.searchForId(test.id);
            fillForm(test.values, values);
        }
    }
}

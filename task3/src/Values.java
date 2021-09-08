import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Values {
    @JsonProperty("values")
    public List<Value> values;

    public String searchForId(int id){
        String result = null;

        for(Value value: values){
            if(id == value.id) result = value.value;
        }

        return result;
    }
}

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Test {
    public int id;
    public String title;
    public String value;

    @JsonProperty("values")
    public List<Test> values;

    @Override
    public String toString(){
        return id + " " + title + " " + value + " " + values + "\n";
    }
}

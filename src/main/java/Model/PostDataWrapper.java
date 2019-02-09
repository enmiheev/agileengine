package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDataWrapper {
    private List<Post> data;

    public List<Post> getData(){
        return data;
    }
}

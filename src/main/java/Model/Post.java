package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private String message;
    private String id;

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }
}

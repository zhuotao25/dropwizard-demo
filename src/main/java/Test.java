import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    private long id;
    private String content;

    public Test() {
        // Jackson deserialization
    }

    public Test(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
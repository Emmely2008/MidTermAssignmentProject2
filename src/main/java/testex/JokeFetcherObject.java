package testex;

public class JokeFetcherObject {

    private String type;
    private String path;
    private String reference;
    private JokeExtractor jokeExtractor;

    public JokeFetcherObject(String type, String path, String reference, JokeExtractor jokeExtractor) {
        this.type = type;
        this.path = path;
        this.reference = reference;
        this.jokeExtractor = jokeExtractor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public JokeExtractor getJokeExtractor() {
        return jokeExtractor;
    }

    public void setJokeExtractor(JokeExtractor jokeExtractor) {
        this.jokeExtractor = jokeExtractor;
    }
}

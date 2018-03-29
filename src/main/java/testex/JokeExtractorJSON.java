package testex;

import static com.jayway.restassured.RestAssured.given;

public class JokeExtractorJSON implements JokeExtractor {

    private String keyPath = "";

    public JokeExtractorJSON(String keyPath){
        this.keyPath = keyPath;
    }

    @Override
    public Joke extractJoke(String path, String ref) {
        try {
            //API does not set response type to JSON, so we have to force the response to read as so
            String joke = getJokeString(path);
            return new Joke(joke, ref);
        } catch (Exception e) {
            return null;
        }
    }

    public String getJokeString(String path) {
        String joke = given().get(path).andReturn().jsonPath().getString(keyPath);
        return joke;
    }
}

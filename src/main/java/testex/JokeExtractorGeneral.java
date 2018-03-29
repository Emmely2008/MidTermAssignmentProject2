package testex;

import static com.jayway.restassured.RestAssured.given;

public class JokeExtractorGeneral implements JokeExtractor  {
    private String keyPath = "";


    public JokeExtractorGeneral(String keyPath){
        this.keyPath = keyPath;
    }


    @Override
    public Joke extractJoke(String path, String ref) {
        try {
            String joke = getJokeString(path) ;
            return new Joke(joke, ref);
        } catch (Exception e) {
            return null;
        }
    }

    public String getJokeString(String path) {
        System.out.println(path);
        return given().get(path).path(keyPath);

    }
}

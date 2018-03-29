package testex;

import com.jayway.restassured.response.ExtractableResponse;

import static com.jayway.restassured.RestAssured.given;

public class JokeExtractorSimple implements JokeExtractor {

    private String keyPath = "";
    public JokeExtractorSimple(String keyPath){
        this.keyPath = keyPath;
    }

    @Override
    public Joke extractJoke(String path, String ref) {
        try {
            ExtractableResponse res = given().get(path).then().extract();
            String joke = res.path(keyPath );
            String reference = res.path(ref);
            return new Joke(joke, reference);
        } catch (Exception e) {
            System.out.println("problem");
            return null;
        }

    }
}

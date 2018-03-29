package testex;

import com.jayway.restassured.response.ExtractableResponse;

public interface JokeExtractor {

    public Joke extractJoke(String path, String ref);

}

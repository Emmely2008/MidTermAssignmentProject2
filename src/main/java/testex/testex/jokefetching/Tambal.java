package testex.testex.jokefetching;

import testex.Joke;

import static com.jayway.restassured.RestAssured.given;

public class Tambal implements IJokeFetcher {
    @Override
    public Joke getJoke() {
        try{
            String joke  = given().get("http://tambal.azurewebsites.net/joke/random").path("joke");
            return new Joke(joke,"http://tambal.azurewebsites.net/joke/random");
        }catch(Exception e){
            return null;
        }
    }
}

package testex;

import com.jayway.restassured.response.ExtractableResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JokeFetcher2 {


    private final List<String> availableTypes = Arrays.asList("eduprog", "chucknorris", "moma", "tambal");

    public Joke getJoke(JokeFetcherObject jfo) {
        JokeExtractor je = jfo.getJokeExtractor();
        return je.extractJoke(jfo.getPath(), jfo.getReference());
    }

    public boolean isStringValid(String jokeTokens) {
        String[] tokens = jokeTokens.split(",");
        for (String token : tokens) {
            if (!availableTypes.contains(token)) {
                return false;
            }
        }
        return true;
    }

    public Jokes getJokes(ArrayList<JokeFetcherObject> jfos, String timeZoneString) {
        Jokes jokes = new Jokes();
        for (int i = 0; i < jfos.size(); i++) {
            jokes.addJoke(getJoke(jfos.get(i)));
        }
        jokes.setTimeZoneString(timeZoneString);
        return jokes;
    }

    public ArrayList<JokeFetcherObject> getJokeFetcherObjects(String jokesToFetch) throws JokeException {
        if (!isStringValid(jokesToFetch)) {
            throw new JokeException("Inputs (jokesToFetch) contain types not recognized");
        }
        String[] tokens = jokesToFetch.split(",");
        ArrayList<JokeFetcherObject> jfos = new ArrayList<JokeFetcherObject>();
        for (String token : tokens) {
            jfos.add(getJokeFetcherObject(token));
        }
        return jfos;
    }

    public JokeFetcherObject getJokeFetcherObject(String token) throws JokeException {
        if (!isStringValid(token)) {
            throw new JokeException("Inputs (jokesToFetch) contain types not recognized");
        }
        switch (token) {
            case "eduprog":
                //EducationalProgrammingJoke
                return new JokeFetcherObject("eduprog", "http://jokes-plaul.rhcloud.com/api/joke", "reference", new JokeExtractorSimple("joke"));

            case "chucknorris":
                //ChuckNorrisJoke
                return new JokeFetcherObject("chucknorris", "http://api.icndb.com/jokes/random", "http://api.icndb.com/", new JokeExtractorGeneral("value.joke"));

            case "moma":
                //YoMommaJoke
                return new JokeFetcherObject("moma", "http://api.yomomma.info/", "http://api.yomomma.info/", new JokeExtractorJSON("joke"));

            case "tambal":
                //TambalJoke
                return new JokeFetcherObject("tambal", "http://tambal.azurewebsites.net/joke/random", "http://tambal.azurewebsites.net/joke/random", new JokeExtractorGeneral("joke"));

        }

        return null;
    }

    public static void main(String[] args) throws JokeException {
        JokeFetcher2 jf = new JokeFetcher2();
        ArrayList<JokeFetcherObject> list = jf.getJokeFetcherObjects("eduprog,chucknorris,chucknorris,moma,tambal");


        String timeZone = "Europe/Copenhagen";
        String timeZoneString = DateFormatter.getFormattedDate(timeZone);
        Jokes jokes = jf.getJokes(jf.getJokeFetcherObjects("eduprog,chucknorris,chucknorris,moma,tambal"), timeZoneString);

        // ToDO implement toString getJokes
        jokes.getJokes().forEach((joke) -> {
            System.out.println(joke);
        });
        System.out.println("Is String Valid: " + jf.isStringValid("edu_prog,xxx"));
    }
}

package testex;

import org.junit.Test;

import static org.junit.Assert.*;

public class JokeExtractorTest {

    @Test
    public void extractJoke() {


        JokeExtractorSimple edu = new JokeExtractorSimple("joke");
        String eduString = edu.extractJoke("http://jokes-plaul.rhcloud.com/api/joke", "").getJoke();
        assertNotNull( eduString);
        assertTrue( eduString.length() > 10);

        // chuck noris
        JokeExtractorGeneral je = new JokeExtractorGeneral("value.joke");
        String s = je.getJokeString("http://api.icndb.com/jokes/random");
        assertNotNull( s);
        assertTrue( s.length() > 10);

        JokeExtractorJSON jej = new JokeExtractorJSON("joke");
        String yomomma = jej.getJokeString("http://api.yomomma.info/");
        assertNotNull( yomomma);
        assertTrue( yomomma.length() > 10);


        JokeExtractorGeneral tambal = new JokeExtractorGeneral("joke");
        String tabaljoke = jej.getJokeString("http://tambal.azurewebsites.net/joke/random");
        assertNotNull( tabaljoke);
        assertTrue( tabaljoke.length() > 10);



    }
}
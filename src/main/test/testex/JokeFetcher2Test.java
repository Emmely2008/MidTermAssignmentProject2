package testex;

import org.junit.Test;

import static org.junit.Assert.*;

public class JokeFetcher2Test {

    @Test
    public void getJoke() {
    }

    @Test
    public void isStringValid() {
        JokeFetcher2 jf2 = new JokeFetcher2();
        assertTrue(jf2.isStringValid("eduprog"));
        assertTrue(jf2.isStringValid("chucknorris"));
        assertTrue(jf2.isStringValid("moma"));
        assertTrue(jf2.isStringValid("tambal"));
        assertFalse(jf2.isStringValid("tambal "));
    }

    @Test
    public void getJokes() {

    }

    @Test
    public void getJokeFetcherObjects() {

    }

    @Test
    public void getJokeFetcherObject() throws JokeException {
         JokeFetcher2 jf2 = new JokeFetcher2();
        //EducationalProgrammingJoke

         JokeFetcherObject eduprog = jf2.getJokeFetcherObject("eduprog");
         JokeFetcherObject eduprogExpected = new JokeFetcherObject("eduprog", "http://jokes-plaul.rhcloud.com/api/joke", "reference", new JokeExtractorSimple("joke"));
        assertNotNull(eduprog);
        // assertEquals(eduprogExpected, eduprog);

        //ChuckNorrisJoke
        JokeFetcherObject chucknorris = jf2.getJokeFetcherObject("chucknorris");
        JokeFetcherObject chucknorrisExpected = new JokeFetcherObject("chucknorris", "http://api.icndb.com/jokes/random", "http://api.icndb.com/", new JokeExtractorGeneral("value.joke"));
        assertNotNull(chucknorris);

        assertEquals(chucknorrisExpected, chucknorris);

        //YoMommaJoke
        JokeFetcherObject moma = jf2.getJokeFetcherObject("moma");
        JokeFetcherObject momaExpected = new JokeFetcherObject("moma", "http://api.yomomma.info/", "http://api.yomomma.info/", new JokeExtractorJSON("joke"));
        assertNotNull(moma);

        assertEquals(momaExpected, moma );

        //TambalJoke
        JokeFetcherObject tambal = jf2.getJokeFetcherObject("tambal");
        JokeFetcherObject tambalExpected = new JokeFetcherObject("tambal", "http://tambal.azurewebsites.net/joke/random", "http://tambal.azurewebsites.net/joke/random", new JokeExtractorGeneral("joke"));
        assertNotNull(tambal);

        assertEquals(tambalExpected , tambal);
        }
}
package testex;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import testex.testex.jokefetching.FetcherFactory;
import testex.testex.jokefetching.IFetcherFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
 import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JokeFetcherTest {

    IDateFormatter iDateFormatter;
    String eduprog;
    String chucknorris;
    String moma;
    String tambal;
    @Before
    public void setUp() {

        this.iDateFormatter = new DateFormatter();
        eduprog = " EduJoke";
        chucknorris = "ChuckNorris";
        moma = "Moma";
        tambal = "Tambal";
    }

    @Test
    public void getAvailableTypes() {
        IFetcherFactory iff = new FetcherFactory();
        JokeFetcher jf = new JokeFetcher(iDateFormatter, iff);
        //private final List<String> availableTypes = Arrays.asList("EduJoke","ChuckNorris","Moma","Tambal");

        //assertThat(jf.getAvailableTypes(), hasItems(eduprog,chucknorris,moma,tambal));
        assertThat( jf.getAvailableTypes(), hasSize(equalTo(4)));

    }

    @Test
    public void isStringValid() {
        IFetcherFactory iff = new FetcherFactory();
        JokeFetcher jf2 = new JokeFetcher(iDateFormatter, iff);
        assertTrue(iff.isStringValid(eduprog));
        assertTrue(iff.isStringValid(chucknorris));
        assertTrue(iff.isStringValid(moma));
        assertTrue(iff.isStringValid(tambal));
        assertFalse(iff.isStringValid("tambal "));
    }

    @Test
    public void getJokes() {
        IDateFormatter dateFormatterMock = mock(IDateFormatter.class);

        String getTimeZoneStringExpected = "30 Mar 2018 05:30 PM";
        try {
            //when(dateFormatterMock.getFormattedDate("Europe/Copenhagen", anyObject())).thenReturn("30 Mar 2018 05:30 PM");
            when(dateFormatterMock.getFormattedDate(eq("Europe/Copenhagen"), anyObject())).thenReturn("30 Mar 2018 05:30 PM");
            IFetcherFactory iff = new FetcherFactory();
            JokeFetcher jf = new JokeFetcher(dateFormatterMock, iff);
            String getTimeZoneStringActual =  jf.getJokes("EduJoke,ChuckNorris,Moma,Tambal","Europe/Copenhagen").getTimeZoneString();
            verify(dateFormatterMock,times(1)).getFormattedDate(anyString(),anyObject());// Verify with wanted number of invocations
            assertThat(getTimeZoneStringExpected, equalTo(getTimeZoneStringActual));
        } catch (JokeException e) {
            e.printStackTrace();
        }


    }
}
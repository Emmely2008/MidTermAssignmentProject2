package testex.testex.jokefetching;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import testex.IDateFormatter;
import testex.Joke;
import testex.JokeException;
import testex.JokeFetcher;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class IFetcherFactoryTest {


    private JokeFetcher jokeFetcher;

    private Joke eduJoke;
    private Joke chuckNorris;
    private Joke momaJoke;
    private Joke tambalJoke;


    @Mock IDateFormatter ifMock;

    @Mock IFetcherFactory factory;

    @Mock Moma moma;

    @Mock ChuckNorris chuck;

    @Mock EduJoke edu;

    @Mock Tambal tambal;

    @Before
    public void setup() {

        factory = mock(IFetcherFactory.class);
        eduJoke = new Joke("edujoke","eduref"); //stubs
        chuckNorris = new Joke("chuckjoke","chuckref"); //stubs
        momaJoke = new Joke("momajoke","momaref"); //stubs
        tambalJoke = new Joke("tambaljoke","tambalref"); //stubs

        edu = mock(EduJoke.class);
        when(edu.getJoke()).thenReturn(eduJoke);
        chuck = mock(ChuckNorris.class);
        when(chuck.getJoke()).thenReturn(chuckNorris);
        moma = mock(Moma.class);
        when(moma.getJoke()).thenReturn(momaJoke);
        tambal = mock(Tambal.class);
        when(tambal.getJoke()).thenReturn( tambalJoke);

        ifMock = mock(IDateFormatter.class);

        List<IJokeFetcher> fetchers = Arrays.asList(edu, chuck, moma, tambal);
        when(factory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal")).thenReturn(fetchers);

        List<String> types = Arrays.asList("EduJoke","ChuckNorris","Moma","Tambal");
        when(factory.getAvailableTypes()).thenReturn(types);
        jokeFetcher = new JokeFetcher(ifMock, factory);


    }

    @Test
    public void getAvailableTypes() {


        assertThat(factory.getAvailableTypes(), hasItems("EduJoke","ChuckNorris","Moma","Tambal"));
        assertThat( factory.getAvailableTypes(), hasSize(equalTo(4)));

    }

    @Test
    public void getJokeFetchers() throws JokeException {
       // when(ifMock.getFormattedDate(anyString(), anyObject())).thenReturn("30 Mar 2018 05:30 PM");
        //verify(ifMock,times(1)).getFormattedDate(anyString(),anyObject());// Verify with wanted number of invocations

        List<IJokeFetcher> result = factory.getJokeFetchers("EduJoke,ChuckNorris,Moma,Tambal");

        assertTrue(result.size()==4);
        assertTrue(result.contains(edu));


        for (int i = 0; i <result.size() ; i++) {
            IJokeFetcher jf = result.get(i);
            if(jf.getClass() == EduJoke.class){
                assertThat(eduJoke.getReference(), equalTo( jf.getJoke().getReference()));
                assertThat(eduJoke.getJoke(), equalTo( jf.getJoke().getJoke()));
            }
            if(jf.getClass() == ChuckNorris.class){
                assertThat(chuckNorris.getReference(), equalTo( jf.getJoke().getReference()));
                assertThat(chuckNorris.getJoke(), equalTo( jf.getJoke().getJoke()));
            }
            if(jf.getClass() == Moma.class){
                assertThat(momaJoke.getReference(), equalTo( jf.getJoke().getReference()));
                assertThat(momaJoke.getJoke(), equalTo( jf.getJoke().getJoke()));
            }
            if(jf.getClass() == Tambal.class){
                assertThat(tambalJoke.getReference(), equalTo( jf.getJoke().getReference()));
                assertThat(tambalJoke.getJoke(), equalTo( jf.getJoke().getJoke()));
            }


        }
    }
}
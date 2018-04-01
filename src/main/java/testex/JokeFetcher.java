
package testex;
import static com.jayway.restassured.RestAssured.given;

import testex.testex.jokefetching.FetcherFactory;
import testex.testex.jokefetching.IFetcherFactory;
import testex.testex.jokefetching.IJokeFetcher;

import java.util.Date;
import java.util.List;

/**
 * Class used to fetch jokes from a number of external joke API's
 */
public class JokeFetcher {
    IDateFormatter dateformatter;

    IFetcherFactory iFetcherFactory;

    public JokeFetcher(IDateFormatter dateformatter, IFetcherFactory iFetcherFactory){
        this.dateformatter = dateformatter;
        this. iFetcherFactory =  iFetcherFactory;
    }
  

  /**
   * The valid string values to use in a call to getJokes(..)
   * @return All the valid strings that can be used
   */
  public List<String> getAvailableTypes(){
    return iFetcherFactory.getAvailableTypes();
  }
  
  /**
   * Verifies whether a provided value is a valid string (contained in availableTypes)
   * @param jokeTokens. Example (with valid values only): "eduprog,chucknorris,chucknorris,moma,tambal"
   * @return true if the param was a valid value, otherwise false
   */

  private void checkIfValidToken(String jokesToFetch) throws JokeException{
      if(!iFetcherFactory.isStringValid(jokesToFetch)){
          throw new JokeException("Inputs (jokesToFetch) contain types not recognized");
      }
  }
  /**
   * Fetch jokes from external API's as given in the input string - jokesToFetch
   * @param jokesToFetch A comma separated string with values (contained in availableTypes) indicating the jokes
   * to fetch. Example: "eduprog,chucknorris,chucknorris,moma,tambal" will return five jokes (two chucknorris)
   * @param timeZone. Must be a valid timeZone string as returned by: TimeZone.getAvailableIDs()  
   * @return A Jokes instance with the requested jokes + time zone adjusted string representing fetch time
   * (the jokes list can contain null values, if a server did not respond correctly)
   * @throws JokeException. Thrown if either of the two input arguments contains illegal values
   */
  public Jokes getJokes(String jokesToFetch,String timeZone) throws JokeException{
      checkIfValidToken(jokesToFetch);
      Jokes jokes =  new Jokes();

      for (IJokeFetcher fetcher : iFetcherFactory.getJokeFetchers(jokesToFetch)){
          jokes.addJoke(fetcher.getJoke());
      }


      Date time = new Date();
      String timeZoneString = dateformatter.getFormattedDate(timeZone, time);
      jokes.setTimeZoneString(timeZoneString);
      return jokes;
  }


  /**
   * DO NOT TEST this function. It's included only to get a quick way of executing the code
   * @param args 
   */
  public static void main(String[] args) throws JokeException {
    DateFormatter df =  new DateFormatter();
    IFetcherFactory iff = new FetcherFactory();
    JokeFetcher jf = new JokeFetcher(df, iff);
    Jokes jokes = jf.getJokes("EduJoke,ChuckNorris,Moma,Tambal","Europe/Copenhagen");
    jokes.getJokes().forEach((joke) -> {
      System.out.println(joke);
    });
    System.out.println("Is String Valid: "+iff.isStringValid("edu_prog,xxx"));
  }
}

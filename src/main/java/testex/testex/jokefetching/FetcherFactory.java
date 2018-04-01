package testex.testex.jokefetching;

import testex.JokeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FetcherFactory implements IFetcherFactory {


    private final List<String> availableTypes = Arrays.asList("EduJoke","ChuckNorris","Moma","Tambal");


    @Override
    public List<String> getAvailableTypes() {
        return availableTypes;
    }

    @Override
    public List<IJokeFetcher> getJokeFetchers(String jokesToFetch) {
        List<IJokeFetcher> list = new ArrayList<IJokeFetcher>();
        String[] tokens = jokesToFetch.split(",");
        for(String token : tokens){
            switch(token){
                case "EduJoke" : list.add(new EduJoke());break;
                case "ChuckNorris" :  list.add(new ChuckNorris());break;
                case "Moma" :  list.add(new Moma());break;
                case "Tambal" :  list.add(new Tambal());break;
            }
        }
        return list;
    }
    @Override
    public boolean isStringValid(String jokeTokens){


        System.out.println(jokeTokens);
        String[] tokens = jokeTokens.split(",");
        for(String token: tokens){
            System.out.println(this.getAvailableTypes().contains(token));
            System.out.println(token);
            if(!this.availableTypes.contains(token)){
                return false;
            }
        }

        return true;
    }
}

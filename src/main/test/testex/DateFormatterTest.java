package testex;

import org.junit.Before;
import org.junit.Test;

import javax.swing.text.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class DateFormatterTest {
    public Date time;


    @Before
    public void setTime(){
        Calendar cal = Calendar.getInstance();
        cal.set(2018,02,30);
        cal.set(Calendar.HOUR_OF_DAY,17);
        cal.set(Calendar.MINUTE,30);
        cal.set(Calendar.SECOND,0);
        cal.set(Calendar.MILLISECOND,0);

        this.time = cal.getTime();

    }

    @Test
    public void getFormattedDate() {

        testex.DateFormatter df = new testex.DateFormatter();
        //Date time = new Date();

        List a = Arrays.asList(TimeZone.getAvailableIDs()) ;
        String s;
        for (int i = 0; i <a.size() ; i++) {
            System.out.println(a.get(i));
            String timezone = a.get(i).toString();

            try {
                s = df.getFormattedDate(timezone, time );
                assertNotNull(s);
                System.out.println(s);

            } catch (JokeException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void getFormattedDateDifferentTimezones() {


        testex.DateFormatter df = new testex.DateFormatter();

        try {
            String s1 = df.getFormattedDate("Europe/Stockholm", time);
            System.out.println(s1);
            String s2 = df.getFormattedDate("America/Los_Angeles", time);
            System.out.println(s2);

           // Europe/Copenhagen
            String dateExpected1 = "30 Mar 2018 05:30 PM";
            String dateExpected2 = "30 Mar 2018 08:30 AM";

            assertFalse(s1.equals(s2));


            assertEquals(dateExpected1,s1);
            assertEquals(dateExpected2,s2);


        } catch (JokeException e) {
            e.printStackTrace();
        }


    }


    @Test(expected = JokeException.class)
    public void testJokeException() throws JokeException {


        testex.DateFormatter df = new testex.DateFormatter();
        String s = df.getFormattedDate("Notvalid", time);

    }
}
package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {
	
	@Test
	public void testGetTotalSecondsGood(){
	int seconds = Time.getTotalSeconds("05:05:05");
	assertTrue("The seconds were not calculated properly", seconds==18305);
	}



	@Test
	public void testGetTotalSecondsBad(){
	assertThrows( 
			StringIndexOutOfBoundsException.class,
	()-> {Time.getTotalSeconds("10:00");});
	}


	  @Test
	    public void testGetMilliSecondsGood() {
	        long milliseconds = Time.getMilliSeconds("12:05:05:05");
	        assertTrue("The milliseconds were not calculated properly", milliseconds == 5);
	    }

	    @Test
	    public void testGetMilliSecondsBad() {
	        assertThrows(StringIndexOutOfBoundsException.class,
	                () -> {
	                    Time.getMilliSeconds("10:00:00");
	                });
	    }
	    
	    @Test
	    public void testGetMilliSecondsBoundry() {
		        long milliseconds = Time.getMilliSeconds("12:05:05:00");
		        assertTrue("The milliseconds were not calculated properly", milliseconds == 0);
		    }
	
	@ParameterizedTest
	@ValueSource(strings = { "05:00:00:00", "05:15:15:00", "05:59:59:00" })
	void testGetTotalHours(String candidate) {
	int hours = Time.getTotalHours(candidate);
	assertTrue("The hours were not calculated properly",
	hours ==5);
	}
	
	
	@ParameterizedTest
	@ValueSource(strings = { "05:05:00:00" })
	void testGetTotalMinutesGood(String candidate) {
	int minutes = Time.getTotalMinutes(candidate);
	assertTrue("The Minutes were not calculated properly", minutes == 5);
	}
	
	@Test
	void testGetTotalHours() {
        long hours = Time.getTotalHours("12:05:05:00");
        assertTrue("The hours were not calculated properly", hours == 12);
	}
	
	
	
}

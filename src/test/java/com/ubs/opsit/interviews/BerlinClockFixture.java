package com.ubs.opsit.interviews;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing stories.  You should not need to
 * edit this class to complete the exercise, this is your definition of done.
 */
public class BerlinClockFixture {

    private TimeConverter berlinClock;
    private String theTime;

    @Before
    public void init(){
    	berlinClock = new TimeConverterImpl();
    }
    
    @Test
    public void berlinClockAcceptanceTests() throws Exception {
        aBehaviouralTestRunner()
                .usingStepsFrom(this)
                .withStory("berlin-clock.story")
                .run();
    }

    @When("the time is $time")
    public void whenTheTimeIs(String time) {
        theTime = time;
    }

    @Then("the clock should look like $")
    public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
        assertThat(berlinClock.convertTime(theTime)).isEqualTo(theExpectedBerlinClockOutput);
    }
    
    @Test
    public void testGetSymbolsForSeconds_odd(){
    	String expected = "O\r\n";
    	Assert.assertEquals(expected, berlinClock.getSymbolsForSeconds(5));
    }
    
    @Test
    public void testGetSymbolsForSeconds_even(){
    	String expected = "Y\r\n";
    	Assert.assertEquals(expected, berlinClock.getSymbolsForSeconds(4));
    }
    
    @Test
    public void testGetSymbolsForHours(){
    	String expected = "RROO\r\nRRRO\r\n";
    	Assert.assertEquals(expected, berlinClock.getSymbolsForHours(13));
    }

    @Test
    public void testGetSymbolsForMinutes(){
    	String expected = "YYOOOOOOOOO\r\nYYYO";
    	Assert.assertEquals(expected, berlinClock.getSymbolsForMinutes(13));
    }
    

    @Test
    public void testGetSymbolsForMinutes1(){
    	String expected = "YYRYYROOOOO\r\nYYOO";
    	Assert.assertEquals(expected, berlinClock.getSymbolsForMinutes(32));
    }
}

package us.plee19.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.SpecialEventFeeStrategy;
import us.plee19.Ticket;

import static org.junit.Assert.*;

public class SpecialEventFeeStrategyTest {
    Ticket test;
    SpecialEventFeeStrategy testStrat;

    @Before
    public void setUp() throws Exception {
        test = new Ticket(100, 7, 5, 20);
        testStrat = new SpecialEventFeeStrategy();
        test.setFeeStrategy(testStrat);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetTicketFee() {
        assertEquals(20, test.getFeeStrategy().getTicketFee(test.getCheckInTime(), test.getCheckOutTime()));
    }

    @Test
    public void testToString() {
        assertEquals("Special Event", testStrat.toString());
    }
}
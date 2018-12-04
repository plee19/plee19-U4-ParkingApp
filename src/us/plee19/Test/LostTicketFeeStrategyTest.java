package us.plee19.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.LostTicketFeeStrategy;

import static org.junit.Assert.*;

public class LostTicketFeeStrategyTest {
    LostTicketFeeStrategy test;

    @Before
    public void setUp() throws Exception {
        test = new LostTicketFeeStrategy();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetTicketFee() {
        assertEquals(25, test.getTicketFee(7, 15));
    }

    @Test
    public void testToString() {
        assertEquals("Lost Ticket", test.toString());
    }
}
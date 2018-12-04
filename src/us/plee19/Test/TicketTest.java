package us.plee19.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.Clock;
import us.plee19.LostTicketFeeStrategy;
import us.plee19.NormalFeeStrategy;
import us.plee19.Ticket;

import static org.junit.Assert.*;

public class TicketTest {
    Ticket testTicket;

    @Before
    public void setUp() throws Exception {
        testTicket = new Ticket(100, 9, 21, 25);
        testTicket.setFeeStrategy(new LostTicketFeeStrategy());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetTicketNumber() {
        assertEquals(100, testTicket.getTicketNumber());
    }

    @Test
    public void testGetCheckInTime() {
        assertEquals(9, testTicket.getCheckInTime());
    }

    @Test
    public void testGetCheckOutTime() {
        assertEquals(21, testTicket.getCheckOutTime());
    }

    @Test
    public void testGetBill() {
        assertEquals(15, testTicket.getBill());
    }

    @Test
    public void testGetFeeStrategy() {
        assertEquals("Lost Ticket", testTicket.getFeeStrategy().toString());
    }

    @Test
    public void testGetCount() {
        assertEquals(100, testTicket.getCount());
    }
}
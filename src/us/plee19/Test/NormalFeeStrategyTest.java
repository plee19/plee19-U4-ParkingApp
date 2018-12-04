package us.plee19.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.NormalFeeStrategy;
import us.plee19.Ticket;

import static org.junit.Assert.*;

public class NormalFeeStrategyTest {
    NormalFeeStrategy lowerLimit;
    NormalFeeStrategy normal;
    NormalFeeStrategy upperLimit;
    Ticket lowerTicket;
    Ticket normalTicket;
    Ticket upperTicket;

    @Before
    public void setUp() throws Exception {
        lowerLimit = new NormalFeeStrategy();
        normal = new NormalFeeStrategy();
        upperLimit = new NormalFeeStrategy();
        lowerTicket = new Ticket(100, 11, 13, 5);
        normalTicket = new Ticket(101, 11, 17, 8);
        upperTicket = new Ticket(102, 7, 21, 15);
        lowerTicket.setFeeStrategy(lowerLimit);
        normalTicket.setFeeStrategy(normal);
        upperTicket.setFeeStrategy(upperLimit);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTicketFee() {
        assertEquals(5, lowerTicket.getFeeStrategy().getTicketFee(lowerTicket.getCheckInTime(), lowerTicket.getCheckOutTime()));
        assertEquals(8, normalTicket.getFeeStrategy().getTicketFee(normalTicket.getCheckInTime(), normalTicket.getCheckOutTime()));
        assertEquals(15, upperTicket.getFeeStrategy().getTicketFee(upperTicket.getCheckInTime(), upperTicket.getCheckOutTime()));

    }
}
package us.plee19.Test;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.ATM;
import us.plee19.CheckInATM;
import us.plee19.FileInput;
import us.plee19.Ticket;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CheckInATMTest extends TestCase {
    CheckInATM testATM = new CheckInATM();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetInTime() {
        assertTrue(testATM.getInTime() >= 7 && testATM.getInTime() <= 12);
    }
}
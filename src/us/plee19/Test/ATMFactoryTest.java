package us.plee19.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.ATM;
import us.plee19.ATMFactory;
import us.plee19.ATMType;
import us.plee19.CheckInATM;

import static org.junit.Assert.*;

public class ATMFactoryTest {
    ATMFactory testFactory;
    CheckInATM testCheckInATM;

    @Before
    public void setUp() throws Exception {
        testFactory = new ATMFactory();
        testCheckInATM = new CheckInATM();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createATM() {
        ATM testATM = testFactory.createATM(ATMType.CHECKIN);
        assertEquals(testCheckInATM.getClass(), testATM.getClass());
    }
}
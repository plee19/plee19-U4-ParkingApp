package us.plee19.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import us.plee19.Clock;

import static org.junit.Assert.*;

public class ClockTest {
    Clock clock;

    @Before
    public void setUp() throws Exception {
        clock = Clock.getInstance();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getInstance() {
        assertEquals(Clock.class, Clock.getInstance().getClass());
    }

    @Test
    public void getInTime() {
        int inTime = clock.getInTime();
        assertTrue((inTime >= 7 && inTime <= 12));
    }

    @Test
    public void getOutTime() {
        int outTime = clock.getOutTime();
        assertTrue((outTime >= 13 && outTime <= 23));
    }
}
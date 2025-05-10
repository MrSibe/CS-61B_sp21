package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void isSameNumber() {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            assertTrue("is the same number", Flik.isSameNumber(i, j));
        }
    }
}
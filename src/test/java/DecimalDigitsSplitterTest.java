import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DecimalDigitsSplitterTest {

    DecimalDigitsSplitter splitter;

    @Before
    public void doBefore() {
        splitter = new DecimalDigitsSplitter();
    }

    @Test
    public void shouldSplit_Tens() throws Exception {
        assertEquals(Arrays.asList(0, 0, 80, 2), splitter.split(82));
        assertEquals(Arrays.asList(0, 0, 50, 4), splitter.split(54));
        assertEquals(Arrays.asList(0, 0, 90, 9), splitter.split(99));
    }

    @Test
    public void shouldSplit_Hundreds() throws Exception {
        assertEquals(Arrays.asList(0, 100, 50, 6), splitter.split(156));
        assertEquals(Arrays.asList(0, 300, 20, 8), splitter.split(328));
    }

    @Test
    public void shouldSplit_Thousands() throws Exception {
        assertEquals(Arrays.asList(1000, 900, 70, 9), splitter.split(1979));
        assertEquals(Arrays.asList(2000, 0, 40, 4), splitter.split(2044));
    }
}
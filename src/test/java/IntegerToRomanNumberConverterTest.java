import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanNumberConverterTest {

    private IntegerToRomanNumberConverter converter;

    @Before
    public void doBefore() {
        Map<Integer, String> mainNumberMapping = new LinkedHashMap<Integer, String>() {{
            put(10, "X");
            put(5, "V");
            put(1, "I");
        }};

        converter = new IntegerToRomanNumberConverter(mainNumberMapping);
    }

    @Test
    public void shouldConvertOneTwoThree() throws Exception {
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
        assertEquals("III",  converter.convert(3));
    }

    @Test
    public void shouldConvertMainNumber() throws Exception {
        assertEquals("V", converter.convert(5));
        assertEquals("X", converter.convert(10));
    }

    @Test
    public void shouldConvertSixSevenEight() throws Exception {
        assertEquals("VI", converter.convert(6));
        assertEquals("VII", converter.convert(7));
        assertEquals("VIII", converter.convert(8));
    }

    @Test
    public void shouldConvertElevenTwelveThirteen() throws Exception {
        assertEquals("XI", converter.convert(11));
        assertEquals("XII", converter.convert(12));
        assertEquals("XIII", converter.convert(13));
    }

    @Test
    public void shouldConvertSixySeventy() throws Exception {
        assertEquals("LX", converter.convert(60));
        assertEquals("LXX", converter.convert(70));
        assertEquals("LXXX", converter.convert(80));
    }
}

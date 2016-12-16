import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanNumberConverterTest {

    private IntegerToRomanNumberConverter converter;

    @Before
    public void doBefore() {
        Map<Integer, String> mainNumberMapping = new LinkedHashMap<Integer, String>() {{
            put(1000, "M");
            put(500, "D");
            put(100, "C");
            put(50, "L");
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
        assertEquals("L", converter.convert(50));
        assertEquals("C", converter.convert(100));
        assertEquals("D", converter.convert(500));
        assertEquals("M", converter.convert(1000));
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
    public void shouldConvertSixySeventyEighty() throws Exception {
        assertEquals("LX", converter.convert(60));
        assertEquals("LXX", converter.convert(70));
        assertEquals("LXXX", converter.convert(80));
    }

    @Test
    public void shouldConvertHundredTenHundredTwentyHundredThirty() throws Exception {
        assertEquals("CX", converter.convert(110));
        assertEquals("CXX", converter.convert(120));
        assertEquals("CXXX", converter.convert(130));
    }

    @Test
    public void shouldConvertSixHundredSevenHundredEightHundred() throws Exception {
        assertEquals("DC", converter.convert(600));
        assertEquals("DCC", converter.convert(700));
        assertEquals("DCCC", converter.convert(800));
    }

    @Test
    public void shouldConvertElevenHundredTwelveHundredThirteenHundred() throws Exception {
        assertEquals("MC", converter.convert(1100));
        assertEquals("MCC", converter.convert(1200));
        assertEquals("MCCC", converter.convert(1300));
    }

    
}

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanNumberConverterTest {

    private IntegerToRomanNumberConverter converter;

    @Before
    public void doBefore() {
        converter = new IntegerToRomanNumberConverter();
    }
    @Test
    public void shouldConvertOneTwoThree() throws Exception {
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
        assertEquals("III",  converter.convert(3));
    }

    @Test
    public void shouldConvertFive() throws Exception {
        assertEquals("V", converter.convert(5));

    }

    @Test
    public void shouldConvertTen() throws Exception {
        assertEquals("X", converter.convert(10));

    }

    @Test
    public void shouldConvertFifty() throws Exception {
        assertEquals("L", converter.convert(50));

    }
}

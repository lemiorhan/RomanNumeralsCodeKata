import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanNumeralsConverterTest {

    private IntegerToRomanNumeralsConverter converter;

    @Before
    public void doBefore() {
        converter = new IntegerToRomanNumeralsConverter();
    }

    @Test
    public void shouldConvert_1_2_3() throws Exception {
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
        assertEquals("III", converter.convert(3));
    }

    @Test
    public void shouldConvert_5_10() throws Exception {
        assertEquals("V", converter.convert(5));
        assertEquals("X", converter.convert(10));
    }

    @Test
    public void shouldConvert_4() throws Exception {
        assertEquals("IV", converter.convert(4));
    }

    @Test
    public void shouldConvert_9() throws Exception {
        assertEquals("IX", converter.convert(9));
    }

    @Test
    public void shouldCovert_6_7_8() throws Exception {
        assertEquals("VI", converter.convert(6));
        assertEquals("VII", converter.convert(7));
        assertEquals("VIII", converter.convert(8));
    }

}


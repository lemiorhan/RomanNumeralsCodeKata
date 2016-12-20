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

}


import org.junit.Before;
import org.junit.Ignore;
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

    @Test
    public void shouldConvert_50() throws Exception {
        assertEquals("L", converter.convert(50));
    }

    @Test
    public void shouldConvert_40() throws Exception {
        assertEquals("XL", converter.convert(40));
    }

    @Test
    public void shouldConvert_60_70_80() throws Exception {
        assertEquals("LX", converter.convert(60));
        assertEquals("LXX", converter.convert(70));
        assertEquals("LXXX", converter.convert(80));
    }

    @Test
    public void shouldConvert_100() throws Exception {
        assertEquals("C", converter.convert(100));
    }

    @Test
    public void shouldConvert_90() throws Exception {
        assertEquals("XC", converter.convert(90));
    }

    @Test
    public void shouldConvert_500() throws Exception {
        assertEquals("D", converter.convert(500));
    }

    @Test
    public void shouldConvert_400() throws Exception {
        assertEquals("CD", converter.convert(400));
    }

    @Test
    public void shouldConvert_600_700_800() throws Exception {
        assertEquals("DC", converter.convert(600));
        assertEquals("DCC", converter.convert(700));
        assertEquals("DCCC", converter.convert(800));
    }

    @Test
    public void shouldConvert_1000() throws Exception {
        assertEquals("M", converter.convert(1000));
    }

    @Test
    public void shouldConvert_900() throws Exception {
        assertEquals("CM", converter.convert(900));
    }

    @Test
    public void shouldConvert_20_30() throws Exception {
        assertEquals("XX", converter.convert(20));
        assertEquals("XXX", converter.convert(30));
    }

    @Test
    public void shouldConvert_300() throws Exception {
        assertEquals("CC", converter.convert(200));
        assertEquals("CCC", converter.convert(300));
    }
}


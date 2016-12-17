package org.scturkey.kata;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerToRomanNumberConverterTest {

    private IntegerToRomanNumberConverter converter;

    @Before
    public void doBefore() {
        DecimalDigitsSplitter splitter = new DecimalDigitsSplitter();
        converter = new IntegerToRomanNumberConverter(splitter);
    }

    @Test
    public void shouldConvert_1_2_3() throws Exception {
        assertEquals("I", converter.convert(1));
        assertEquals("II", converter.convert(2));
        assertEquals("III",  converter.convert(3));
    }

    @Test
    public void shouldConvertMainNumbers() throws Exception {
        assertEquals("V", converter.convert(5));
        assertEquals("X", converter.convert(10));
        assertEquals("L", converter.convert(50));
        assertEquals("C", converter.convert(100));
        assertEquals("D", converter.convert(500));
        assertEquals("M", converter.convert(1000));
    }

    @Test
    public void shouldConvert_6_7_8() throws Exception {
        assertEquals("VI", converter.convert(6));
        assertEquals("VII", converter.convert(7));
        assertEquals("VIII", converter.convert(8));
    }

    @Test
    public void shouldConvert_11_12_13() throws Exception {
        assertEquals("XI", converter.convert(11));
        assertEquals("XII", converter.convert(12));
        assertEquals("XIII", converter.convert(13));
    }

    @Test
    public void shouldConvert_20_30() throws Exception {
        assertEquals("XX", converter.convert(20));
        assertEquals("XXX", converter.convert(30));
    }

    @Test
    public void shouldConvert_60_70_80() throws Exception {
        assertEquals("LX", converter.convert(60));
        assertEquals("LXX", converter.convert(70));
        assertEquals("LXXX", converter.convert(80));
    }

    @Test
    public void shouldConvert_110_120_130() throws Exception {
        assertEquals("CX", converter.convert(110));
        assertEquals("CXX", converter.convert(120));
        assertEquals("CXXX", converter.convert(130));
    }

    @Test
    public void shouldConvert_200_300() throws Exception {
        assertEquals("CC", converter.convert(200));
        assertEquals("CCC", converter.convert(300));
    }

    @Test
    public void shouldConvert_600_700_800() throws Exception {
        assertEquals("DC", converter.convert(600));
        assertEquals("DCC", converter.convert(700));
        assertEquals("DCCC", converter.convert(800));
    }

    @Test
    public void shouldConvert_1100_1200_1300() throws Exception {
        assertEquals("MC", converter.convert(1100));
        assertEquals("MCC", converter.convert(1200));
        assertEquals("MCCC", converter.convert(1300));
    }

    @Test
    public void shouldConvert_4_9_40_90_400_900() throws Exception {
        assertEquals("IV", converter.convert(4));
        assertEquals("IX", converter.convert(9));
        assertEquals("XL", converter.convert(40));
        assertEquals("XC", converter.convert(90));
        assertEquals("CD", converter.convert(400));
        assertEquals("CM", converter.convert(900));
    }

    @Test
    public void shouldConvert_54_82() throws Exception {
        assertEquals("LIV", converter.convert(54));
        assertEquals("LXXXII", converter.convert(82));
    }

    @Test
    public void shouldConvert_99_199_2999() throws Exception {
        assertEquals("XCIX", converter.convert(99));
        assertEquals("CXCIX", converter.convert(199));
        assertEquals("MMCMXCIX", converter.convert(2999));
    }




}

package org.scturkey.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecimalDigitsSplitter {

    private static final List<Integer> digitDivisor = Arrays.asList(1000, 100, 10, 1);

    public static List<Integer> split(int input) {
        List<Integer> list = new ArrayList<>();
        for (int divisor : digitDivisor) {
            list.add(input - (input % divisor));
            input = input % divisor;
        }
        return list;
    }

    public static boolean isValidDigit(int input) {
        return input != 0;
    }
}

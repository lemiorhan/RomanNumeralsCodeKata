package org.scturkey.kata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecimalDigitsSplitter {

    public static List<Integer> split(int input) {
        List<Integer> digitDivisor = Arrays.asList(1000, 100, 10, 1);
        List<Integer> list = new ArrayList<>();

        for (int divisor : digitDivisor) {
            list.add(input - (input % divisor));
            input = input % divisor;
        }
        return list;
    }
}

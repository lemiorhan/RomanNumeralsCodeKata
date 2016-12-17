package org.scturkey.kata;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumberMapping {

    private static Map<Integer, String> mainNumberMapping = new LinkedHashMap<Integer, String>() {{
        put(1000, "M");
        put(500, "D");
        put(100, "C");
        put(50, "L");
        put(10, "X");
        put(5, "V");
        put(1, "I");
    }};

    private static Map<Integer, Integer> divisorMap = new LinkedHashMap<Integer, Integer>() {{
        put(1000, 100);
        put(500, 100);
        put(100, 10);
        put(50, 10);
        put(10, 1);
        put(5, 1);
        put(1, 1);
    }};

    public static String romanRepresentationOf(int input) {
        return mainNumberMapping.get(input);
    }

    public static int divisorOf(int input) {
        return divisorMap.get(input);
    }

    public static boolean isMainNumber(int input) {
        return mainNumberMapping.containsKey(input);
    }

    public static Collection<Integer> mainIntegers() {
        return mainNumberMapping.keySet();
    }
}

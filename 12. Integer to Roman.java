import java.util.*;

class Solution {
    public String intToRoman(int num) {
        List<Map.Entry<Integer, String>> val2Sym = new ArrayList<>() {{
            add(new AbstractMap.SimpleEntry<>(1000, "M"));
            add(new AbstractMap.SimpleEntry<>(900, "CM"));
            add(new AbstractMap.SimpleEntry<>(500, "D"));
            add(new AbstractMap.SimpleEntry<>(400, "CD"));
            add(new AbstractMap.SimpleEntry<>(100, "C"));
            add(new AbstractMap.SimpleEntry<>(90, "XC"));
            add(new AbstractMap.SimpleEntry<>(50, "L"));
            add(new AbstractMap.SimpleEntry<>(40, "XL"));
            add(new AbstractMap.SimpleEntry<>(10, "X"));
            add(new AbstractMap.SimpleEntry<>(9, "IX"));
            add(new AbstractMap.SimpleEntry<>(5, "V"));
            add(new AbstractMap.SimpleEntry<>(4, "IV"));
            add(new AbstractMap.SimpleEntry<>(1, "I"));
        }};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for (Map.Entry<Integer, String> entry : val2Sym) {
                if (entry.getKey().intValue() <= num) {
                    num -= entry.getKey().intValue();
                    sb.append(entry.getValue());
                    break;
                }
            }
        }
        return sb.toString();
    }
}
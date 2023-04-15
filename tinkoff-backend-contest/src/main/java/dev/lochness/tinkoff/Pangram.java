package dev.lochness.tinkoff;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Pangram {

    private static final Pattern isAlphabet = Pattern.compile("[а-я]");

    public static void main(String args[]) {
        var scanner = new Scanner(System.in);
        var input = "Съешь же ещё этих мягких французских булок, да выпей чаю.";

        Map<String, Integer> chars = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            String s = input.substring(i, i + 1).toLowerCase();
            if (isAlphabet.matcher(s).matches()) {
                if (!chars.containsKey(s)) {
                    chars.put(s.toLowerCase(), 1);
                }
            }
            if (chars.keySet().size() >= 32) {
                System.out.println("True");
                return;
            }
        }

        System.out.println("False");
    }
}

package dev.lochness.tinkoff;

import java.util.HashSet;
import java.util.Scanner;

public class Letters {

    public static void main(String args[]) {
        var scanner = new Scanner(System.in);
        var input = "abc";

        String[] letters = input.split("");

        String[] pairs = new String[(int) Math.pow(2, letters.length)];

        int index = 0;

        for (int i = 0; i < letters.length; i++) {
            pairs[index++] = letters[i];
            for(int j = 0; j < letters.length; j++) {
                pairs[index++] = letters[j];
            }
        }
        System.out.println(String.join(", ", letters));

    }
}

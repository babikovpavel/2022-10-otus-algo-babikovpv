package dev.lochness.string.search;

import java.util.Objects;

public class StateMachine {

    public int find(String text, String pattern) {
        int[][] delta = createDelta(pattern);
        int q = 0;
        for (int i = 0; i < text.length(); i++) {
            q = delta[q][text.charAt(i)];
            if (q == pattern.length()) {
                return i - pattern.length() + 1;
            }
        }
        return -1;
    }

    private static int[][] createDelta(String text) {
        int[][] delta = new int[text.length()][128];
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < 128; j++) {
                String line = text.substring(0, i) + ((char) j);
                int k = i + 1;
                while (!Objects.equals(text.substring(0, k), line.substring(line.length() - k))) {
                    k--;
                }
                delta[i][j] = k;
            }
        }
        return delta;
    }
}

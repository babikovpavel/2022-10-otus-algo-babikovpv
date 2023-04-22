package dev.lochness.string.search;

import java.util.Arrays;

public class BruteStringSearch {

    //поиск подстроки перебором
    public int simpleSearch(String source, String sub) {
        for (int i = 0; i <= source.length() - sub.length(); i++) {
            for (int j = 0; j < sub.length(); j++) {
                if (source.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
                if (j == sub.length() - 1)
                    return i;
            }
        }
        return -1;
    }

    //поиск подстроки перебором с реверсом, с оптимизацией
    public int searchWithShifts(String source, String sub) {
        int[] shifts = new int[128];
        Arrays.fill(shifts, sub.length());
        for (int i = 0; i < sub.length() - 1; i++) {
            shifts[sub.charAt(i)] = sub.length() - i - 1;
        }
        for (int i = 0; i <= source.length() - sub.length(); i += shifts[(byte) source.charAt(i + sub.length() - 1)]) {
            for (int j = sub.length() - 1; j >= 0; j--) {
                if (source.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
                if (j == 0)
                    return i;
            }
        }
        return -1;
    }
}

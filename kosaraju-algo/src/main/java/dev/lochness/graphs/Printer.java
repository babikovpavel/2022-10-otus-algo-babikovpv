package dev.lochness.graphs;

import java.util.Arrays;

public final class Printer {

    private Printer(){
    }

    static void printArray(String comment, Integer[] source) {
        System.out.println(comment);
        System.out.println(Arrays.toString(source));
        System.out.println("------");
    }

    static void printMatrix(String comment, Integer[][] source) {
        System.out.println(comment);
        for (int i = 0; i < source.length; i++) {
            System.out.printf("%d: %s%n", i, Arrays.toString(source[i]));
        }
        System.out.println("------");
    }
}

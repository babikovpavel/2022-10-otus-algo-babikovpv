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
            for(int j=0; j< source[i].length; j++) {
                Integer value = source[i][j];
                System.out.printf("%s ", value == null ? "-" : value);
            }
            System.out.println();
        }
        System.out.println("------");
    }
}

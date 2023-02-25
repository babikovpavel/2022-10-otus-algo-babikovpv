package dev.lochness.graphs;

import java.util.Objects;

public final class ArrayUtils {

    private ArrayUtils() {
    }

    static boolean contains(Integer[] arr, int value) {
        for (Integer i : arr) {
            if (Objects.equals(i, value)) {
                return true;
            }
        }
        return false;
    }

    static void add(Integer[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = value;
                break;
            }
        }
    }

    static Integer[] invert(Integer[] source) {
        Integer[] inverted = new Integer[source.length];
        int j = 0;
        for (int i = source.length - 1; i >= 0; i--) {
            inverted[j++] = source[i];
        }
        return inverted;
    }
}

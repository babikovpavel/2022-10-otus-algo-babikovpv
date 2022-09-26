package dev.lochness.sorts;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ArrayUtils {

    public static void fillRandom(int[] source, int min, int max) {
        for (int i = 0; i < source.length; i++) {
            source[i] = (int) (Math.random() * (max - min) + min);
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

    public void swap(int[] source, int i, int j) {
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }

    public int max(int[] source) {
        int max = source[0];
        for (int i = 1; i < source.length; i++) {
            if (source[i] > max) {
                max = source[i];
            }
        }
        return max;
    }
}

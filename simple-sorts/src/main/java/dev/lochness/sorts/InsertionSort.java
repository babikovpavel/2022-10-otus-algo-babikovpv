package dev.lochness.sorts;

public class InsertionSort implements Sort {

    @Override
    public void sort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int elem = source[i];
            int j = i - 1;
            while (j >= 0 && source[j] > elem) {
                source[j + 1] = source[j];
                j--;
            }
            source[j + 1] = elem;
        }
    }
}

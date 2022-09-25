package dev.lochness.sorts;

public class ShellSort implements Sort {

    @Override
    public void sort(int[] source) {
        //do shell sort
        int size = source.length;
        for (int i = size / 2; i > 0; i = i / 2) {
            for (int j = i; j < size; j++) {
                int elem = source[j];
                int k;
                for (k = j; k >= i && source[k - i] > elem; k = k - i) {
                    source[k] = source[k - i];
                }
                source[k] = elem;
            }
        }
        //do insertion sort
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(source);
    }
}

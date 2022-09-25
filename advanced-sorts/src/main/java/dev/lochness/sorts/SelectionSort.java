package dev.lochness.sorts;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] source) {
        int size = source.length;
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (source[j] < source[min]) {
                    min = j;
                }
            }
            swap(source, min, i);
        }
    }

    private void swap(int[] source, int min, int dst) {
        int tmp = source[min];
        source[min] = source[dst];
        source[dst] = tmp;
    }
}

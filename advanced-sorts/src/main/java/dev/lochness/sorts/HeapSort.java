package dev.lochness.sorts;

public class HeapSort implements Sort {

    @Override
    public void sort(int[] source) {
        int size = source.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(source, size, i);
        }
        for (int i = size - 1; i > 0; i--) {
            swap(source, 0, i);
            heapify(source, i, 0);
        }
    }

    private void swap(int[] source, int i, int j) {
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }

    private void heapify(int[] source, int size, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < size && source[left] > source[max]) {
            max = left;
        }
        if (right < size && source[right] > source[max]) {
            max = right;
        }
        if (max != i) {
            swap(source, i, max);
            heapify(source, size, max);
        }
    }
}

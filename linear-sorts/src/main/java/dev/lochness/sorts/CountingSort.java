package dev.lochness.sorts;

public class CountingSort implements Sort {

    @Override
    public void sort(int[] source) {
        int max = ArrayUtils.max(source);
        int size = source.length;
        int[] counters = new int[max + 1];
        int[] sorted = new int[size];
        for (int j : source) {
            counters[j]++;
        }

        int k = 0;
        for (int i = 0; i < counters.length; i++) {
            if (counters[i] != 0) {
                int tmp = counters[i];
                counters[i] += k;
                k += tmp;
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            counters[source[i]]--;
            int dstIndex = counters[source[i]];
            sorted[dstIndex] = source[i];
        }

        System.arraycopy(sorted, 0, source, 0, size);
    }
}

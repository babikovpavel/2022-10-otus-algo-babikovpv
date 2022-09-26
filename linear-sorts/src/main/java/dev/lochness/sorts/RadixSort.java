package dev.lochness.sorts;

public class RadixSort implements Sort {

    @Override
    public void sort(int[] source) {
        int size = source.length;
        int max = ArrayUtils.max(source);
        int[] sorted = new int[size];

        int l = 1;

        while (l <= max) {
            int[] counters = new int[10];

            for (int j = 0; j < size; j++) {
                int r = (source[j] % (l * 10)) / l;
                counters[r]++;
            }

            int k = 0;
            for (int j = 0; j < counters.length; j++) {
                if (counters[j] != 0) {
                    int tmp = counters[j];
                    counters[j] += k;
                    k += tmp;
                }
            }

            for (int j = size - 1; j >= 0; j--) {
                int r = (source[j] % (l * 10)) / l;
                counters[r]--;
                int dstIndex = counters[r];
                sorted[dstIndex] = source[j];
            }

            l *= 10;

            System.arraycopy(sorted, 0, source, 0, size);
        }

    }
}

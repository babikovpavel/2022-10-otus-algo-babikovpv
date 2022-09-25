package dev.lochness.sorts;

public class BubbleSort implements Sort {

    @Override
    public void sort(int[] source) {
        boolean swap;
        for (int i = 0; i < source.length - 1; i++) {
            swap = false;
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    int max = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = max;
                    swap = true;
                }
            }
            if(!swap) break;
        }
    }

}

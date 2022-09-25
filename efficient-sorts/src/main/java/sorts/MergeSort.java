package sorts;

public class MergeSort implements Sort {

    @Override
    public void sort(int[] source) {
        sort(source, 0, source.length - 1);
    }

    private void sort(int[] source, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            sort(source, start, middle);
            sort(source, middle + 1, end);
            merge(source, start, middle, end);
        }
    }

    private void merge(int[] source, int start, int middle, int end) {
        int size1 = middle - start + 1;
        int size2 = end - middle;
        int[] first = new int[size1];
        int[] second = new int[size2];
        for (int i = 0; i < size1; ++i) {
            first[i] = source[start + i];
        }
        for (int i = 0; i < size2; ++i) {
            second[i] = source[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = start;
        while (i < size1 && j < size2) {
            if (first[i] <= second[j]) {
                source[k] = first[i];
                i++;
            } else {
                source[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            source[k] = first[i];
            i++;
            k++;
        }

        while (j < size2) {
            source[k] = second[j];
            j++;
            k++;
        }
    }
}

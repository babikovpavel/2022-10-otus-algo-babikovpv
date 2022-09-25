package sorts;

public class QuickSort implements Sort {

    @Override
    public void sort(int[] source) {
        sortItems(source, 0, source.length - 1);
    }

    private void sortItems(int[] source, int low, int high) {
        if (low >= high) {
            return;
        }
        int k = split(source, low, high);
        sortItems(source, low, k - 1);
        sortItems(source, k + 1, high);
    }

    private int split(int[] source, int low, int high) {
        int pivot = source[high];
        int m = low - 1;
        for (int i = low; i <= high; i++) {
            if (source[i] <= pivot) {
                m++;
                swap(source, m, i);
            }
        }
        return m;
    }

    private void swap(int[] source, int i, int j) {
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }
}

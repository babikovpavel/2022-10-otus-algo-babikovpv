package dev.lochness.arrays;

public class MatrixArray<T> implements IArray<T> {

    public static final int DEFAULT_SIZE = 10;

    private final IArray<T[]> arrays;

    private int size;

    public MatrixArray() {
        arrays = new SingleArray<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(T item) {
        putItem(item);
        size++;
    }

    @Override
    public T get(int index) {
        int row = index / DEFAULT_SIZE;
        int column = index % DEFAULT_SIZE;
        T[] dstArray = arrays.get(row);
        return dstArray[column];
    }

    @Override
    public void add(T item, int index) {
        addItem(item, index);
        size++;
    }

    @Override
    public T remove(int index) {
        T removedElement = removeItem(index);
        size--;
        return removedElement;
    }

    private void putItem(T item) {
        if (size == arrays.size() * DEFAULT_SIZE) {
            grow();
        }
        T[] dstArray = arrays.get(size / DEFAULT_SIZE);
        dstArray[size % DEFAULT_SIZE] = item;
    }

    private void addItem(T item, int index) {
        if (index == size) {
            putItem(item);
            return;
        }
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T[] dstArray;
        if (size == arrays.size() * DEFAULT_SIZE) {
            arrays.put((T[]) new Object[DEFAULT_SIZE]);
        }
        int row = index / DEFAULT_SIZE;
        int column = index % DEFAULT_SIZE;
        dstArray = arrays.get(row);
        T lastElement = dstArray[dstArray.length - 1];
        if (lastElement != null)
            addItem(lastElement, DEFAULT_SIZE * (row + 1));
        for (int i = dstArray.length - 1; i > column; i--) {
            dstArray[i] = dstArray[i - 1];
        }
        dstArray[column] = item;
    }

    private T removeItem(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T removedElement = arrays.get(index / DEFAULT_SIZE)[index % DEFAULT_SIZE];
        for (int i = index; i < size - 1; i++) {
            int row = i / DEFAULT_SIZE;
            int column = i % DEFAULT_SIZE;
            if (column + 1 < DEFAULT_SIZE) {
                arrays.get(row)[column] = arrays.get(row)[column + 1];
            } else {
                arrays.get(row)[column] = arrays.get(row + 1)[0];
            }
        }
        arrays.get(size / DEFAULT_SIZE)[size % DEFAULT_SIZE - 1] = null;
        return removedElement;
    }

    private void grow() {
        arrays.put((T[]) new Object[DEFAULT_SIZE]);
    }
}

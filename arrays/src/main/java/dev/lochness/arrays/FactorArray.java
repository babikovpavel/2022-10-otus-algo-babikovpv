package dev.lochness.arrays;

public class FactorArray<T> implements IArray<T> {

    public static final int DEFAULT_SIZE = 10;

    private T[] array;
    int size;

    public FactorArray() {
        array = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(T item) {
        if (size() == array.length) {
            grow();
        }
        array[size()] = item;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void add(T item, int index) {
        if (index == size) {
            put(item);
            return;
        }
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T[] dstArray;
        if(size == array.length) {
            dstArray = (T[]) new Object[size * 2];
        } else {
            dstArray = array;
        }
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                dstArray[j++] = item;
            }
            dstArray[j++] = array[i];
        }
        size++;
        array = dstArray;
    }

    @Override
    public T remove(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T removedElement = null;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                removedElement = array[i];
            } else {
                array[j++] = array[i];
            }
        }
        size--;
        return removedElement;
    }

    private void grow() {
        T[] newArray = (T[]) new Object[size() * 2 + 1];
        if(!isEmpty())
            System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}

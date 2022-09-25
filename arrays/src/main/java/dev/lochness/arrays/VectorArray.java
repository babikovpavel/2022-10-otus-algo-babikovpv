package dev.lochness.arrays;

public class VectorArray<T> implements IArray<T> {

    public static final int DEFAULT_SIZE = 10;

    private T[] array;
    private int size;
    private int vector;

    public VectorArray(int vector) {
        this.vector = vector;
        array = (T[]) new Object[vector];
        this.size = 0;
    }

    public VectorArray() {
        this(DEFAULT_SIZE);
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
        if (size == array.length) {
            grow();
        }
        array[size] = item;
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
            dstArray = (T[]) new Object[size + vector];
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
        if (index >= array.length) {
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
        T[] newArray = (T[]) new Object[size + vector];
        if (!isEmpty())
            System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}

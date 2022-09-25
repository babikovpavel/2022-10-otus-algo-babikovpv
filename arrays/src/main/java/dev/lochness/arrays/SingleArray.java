package dev.lochness.arrays;

public class SingleArray<T> implements IArray<T> {

    private T[] array;

    public SingleArray() {
        array = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void put(T item) {
        grow();
        array[size() - 1] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void add(T item, int index) {
        if (index > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index == array.length) {
            put(item);
            return;
        }
        T[] newArray = (T[]) new Object[size() + 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(i == index) {
                newArray[j++] = item;
            }
            newArray[j++] = array[i];
        }
    }

    @Override
    public T remove(int index) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T removedElement = null;
        T[] newArray = (T[]) new Object[size() - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                removedElement = array[i];
            } else {
                newArray[j++] = array[i];
            }
        }
        array = newArray;
        return removedElement;
    }

    private void grow() {
        T[] newArray = (T[]) new Object[size() + 1];
        if (!isEmpty())
            System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}

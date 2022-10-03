package dev.lochness.hash;

import java.util.Objects;

public class CustomHashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private Bag<K, V>[] values;
    private int size;

    public CustomHashTable() {
        values = new Bag[DEFAULT_CAPACITY];
    }

    public CustomHashTable(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        values = new Bag[capacity];
    }

    public void put(K key, V value) {
        Objects.requireNonNull(key, "Key can't be null");
        put(key, value, values);
        size++;
        if (size == values.length) {
            rehash();
        }
    }

    public V get(K key) {
        Objects.requireNonNull(key, "Key can't be null");
        int i = key.hashCode() % values.length;
        Bag<K, V> bag = values[i];
        while (bag != null) {
            if (bag.key.equals(key)) {
                return bag.value;
            }
            bag = bag.nextElem;
        }
        return null;
    }

    public void delete(K key) {
        Objects.requireNonNull(key, "Key can't be null");
        int i = key.hashCode() % values.length;
        Bag<K, V> bag = values[i];
        if (bag == null)
            return;
        Bag<K, V> prevBag = null;
        while (bag != null) {
            if (bag.key.equals(key)) {
                if (bag.nextElem != null) {
                    if(prevBag == null) {
                        values[i] = bag.nextElem;
                    } else {
                        prevBag.nextElem = bag.nextElem;
                    }
                } else {
                    values[i] = null;
                }
                return;
            }
            prevBag = bag;
            bag = bag.nextElem;
        }
    }

    public int getSize() {
        return size;
    }

    public void put(K key, V value, Bag<K, V>[] array) {
        Objects.requireNonNull(key, "Key can't be null");
        int i = key.hashCode() % array.length;
        Bag<K, V> bag = array[i];
        if (bag == null) {
            array[i] = new Bag<>(key, value);
        } else {
            boolean exists;
            do {
                exists = bag.key.equals(key);
                if (exists) {
                    bag.value = value;
                    return;
                }
                bag = bag.nextElem;
            } while (bag != null);
            Bag<K, V> newBag = new Bag(key, value);
            newBag.nextElem = array[i];
            array[i] = newBag;
        }
    }

    private void rehash() {
        Bag<K, V>[] newArray = new Bag[size * 2];
        for (int i = 0; i < values.length; i++) {
            Bag<K, V> bag = values[i];
            while (bag != null) {
                put(bag.key, bag.value, newArray);
                bag = bag.nextElem;
            }
        }
        values = newArray;
    }

    static class Bag<K, V> {
        private final K key;
        private V value;
        private Bag<K, V> nextElem;

        Bag(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

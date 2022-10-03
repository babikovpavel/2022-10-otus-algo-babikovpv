package dev.lochness.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomHashTableTest {

    private CustomHashTable<String, Integer> hashTable;

    @Test
    void putAndGetTest() {
        hashTable = new CustomHashTable<String, Integer>();
        hashTable.put("dog", 10);
        Integer actual = hashTable.get("dog");
        assertEquals(10, actual);
    }

    @Test
    void rewriteValueTest() {
        hashTable = new CustomHashTable<String, Integer>();
        hashTable.put("dog", 10);
        hashTable.put("dog", 50);
        Integer actual = hashTable.get("dog");
        assertEquals(50, actual);
    }

    @Test
    void rehashTest() {
        hashTable = new CustomHashTable<String, Integer>(1);
        hashTable.put("dog", 10);
        hashTable.put("god", 15);
        hashTable.put("not", 20);
        assertEquals(3, hashTable.getSize());
    }

    @Test
    void deleteTest() {
        hashTable = new CustomHashTable<String, Integer>();
        hashTable.put("dog", 10);
        hashTable.delete("dog");
        Integer actual = hashTable.get("dog");
        assertNull(actual);
    }
}
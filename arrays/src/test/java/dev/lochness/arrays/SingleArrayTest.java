package dev.lochness.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleArrayTest {

    private SingleArray<Integer> singleArray;

    @BeforeEach
    void setUp() {
        singleArray = new SingleArray<>();
    }

    @Test
    void sizeTest() {
        assertEquals(0, singleArray.size());
        singleArray.put(1);
        assertEquals(1, singleArray.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(singleArray.isEmpty());
        singleArray.put(1);
        assertFalse(singleArray.isEmpty());
    }

    @Test
    void putAndGetTest() {
        singleArray.put(1);
        Integer actual = singleArray.get(0);
        assertEquals(1, actual);
    }

    @Test
    void getOutOfBoundsTest() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> singleArray.get(1));
    }

    @Test
    void addToEndTest() {
        singleArray.add(1, 0);
        Integer actual = singleArray.get(0);
        assertEquals(1, actual);
    }

    @Test
    void addOutOfBoundsTest() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> singleArray.add(1, 10));
    }

    @Test
    void removeTest() {
        singleArray.put(1);
        Integer actual = singleArray.remove(0);
        assertEquals(1, actual);
        assertEquals(0, singleArray.size());
    }
}
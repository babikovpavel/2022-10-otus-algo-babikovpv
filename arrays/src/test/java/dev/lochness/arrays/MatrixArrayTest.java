package dev.lochness.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixArrayTest {

    private MatrixArray<Integer> matrixArray;

    @BeforeEach
    void setUp() {
        matrixArray = new MatrixArray<>();
    }

    @Test
    void sizeTest() {
        assertEquals(0, matrixArray.size());
        for (int i = 0; i < matrixArray.DEFAULT_SIZE + 1; i++) {
            matrixArray.put(i);
        }
        assertEquals(11, matrixArray.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(matrixArray.isEmpty());
        matrixArray.put(1);
        assertFalse(matrixArray.isEmpty());
    }

    @Test
    void putAndGetTest() {
        matrixArray.put(1);
        Integer actual = matrixArray.get(0);
        assertEquals(1, actual);
    }

    @Test
    void addTest() {
        for (int i = 0; i < 30; i++) {
            matrixArray.put(i);
        }
        matrixArray.add(1, 0);
        assertEquals(1, matrixArray.get(0));
        matrixArray.add(2, 0);
        assertEquals(2, matrixArray.get(0));
        assertEquals(32, matrixArray.size());
    }

    @Test
    void removeTest() {
        for (int i = 0; i < 35; i++) {
            matrixArray.put(i);
        }
        matrixArray.remove(0);
        assertEquals(34, matrixArray.size());
        assertEquals(1, matrixArray.get(0));
        assertEquals(34, matrixArray.get(33));
    }
}
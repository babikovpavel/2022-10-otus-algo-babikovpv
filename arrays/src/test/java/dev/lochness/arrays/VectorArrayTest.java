package dev.lochness.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VectorArrayTest {

    private VectorArray<Integer> vectorArray;

    @BeforeEach
    void setUp() {
        vectorArray = new VectorArray<>();
    }

    @Test
    void sizeTest() {
        assertEquals(0, vectorArray.size());
        for (int i = 0; i < VectorArray.DEFAULT_SIZE + 1; i++) {
            vectorArray.put(i);
        }
        assertEquals(11, vectorArray.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(vectorArray.isEmpty());
        vectorArray.put(1);
        assertFalse(vectorArray.isEmpty());
    }

    @Test
    void putAndGetTest() {
        vectorArray.put(1);
        Integer actual = vectorArray.get(0);
        assertEquals(1, actual);
    }

    @Test
    void addTest() {
        vectorArray.add(1, 0);
        assertEquals(1, vectorArray.get(0));
        vectorArray.add(2, 0);
        assertEquals(2, vectorArray.get(0));
    }

    @Test
    void removeTest() {
        vectorArray.put(1);
        vectorArray.put(2);
        vectorArray.remove(0);
        Integer actual = vectorArray.get(0);
        assertEquals(1, vectorArray.size());
        assertEquals(2, actual);
    }
}
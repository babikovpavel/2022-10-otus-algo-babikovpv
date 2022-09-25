package dev.lochness.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorArrayTest {

    private FactorArray<Integer> factorArray;

    @BeforeEach
    void setUp() {
        factorArray = new FactorArray<>();
    }

    @Test
    void sizeTest() {
        assertEquals(0, factorArray.size());
        for (int i = 0; i < factorArray.DEFAULT_SIZE + 1; i++) {
            factorArray.put(i);
        }
        assertEquals(11, factorArray.size());
    }

    @Test
    void isEmptyTest() {
        assertTrue(factorArray.isEmpty());
        factorArray.put(1);
        assertFalse(factorArray.isEmpty());
    }

    @Test
    void putAndGetTest() {
        factorArray.put(1);
        Integer actual = factorArray.get(0);
        assertEquals(1, actual);
    }

    @Test
    void addTest() {
        factorArray.add(1, 0);
        assertEquals(1, factorArray.get(0));
        factorArray.add(2, 0);
        assertEquals(2, factorArray.get(0));
    }

    @Test
    void removeTest() {
        factorArray.put(1);
        factorArray.put(2);
        factorArray.remove(0);
        Integer actual = factorArray.get(0);
        assertEquals(1, factorArray.size());
        assertEquals(2, actual);
    }
}
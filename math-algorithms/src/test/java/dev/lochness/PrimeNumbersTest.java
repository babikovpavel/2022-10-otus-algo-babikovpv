package dev.lochness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {

    private PrimeNumbers primeNumbers;

    @BeforeEach
    void setUp() {
        primeNumbers = new PrimeNumbers();
    }

    @Test
    void countPrimeNumbers10Test() {
        long limit = 10;
        int expected = 4;
        int actual = primeNumbers.countPrimeNumbers(limit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countPrimeNumbers100Test() {
        long limit = 100;
        int expected = 25;
        int actual = primeNumbers.countPrimeNumbers(limit);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void countPrimeNumbers1000Test() {
        long limit = 1000;
        int expected = 168;
        int actual = primeNumbers.countPrimeNumbers(limit);
        Assertions.assertEquals(expected, actual);
    }
}
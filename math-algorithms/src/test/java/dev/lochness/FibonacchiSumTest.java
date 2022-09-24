package dev.lochness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacchiSumTest {

    private FibonacchiSum fibonacchiSum;

    @BeforeEach
    void setUp() {
        fibonacchiSum = new FibonacchiSum();
    }

    @Test
    void recursiveFibonacchiSum1Test() {
        int expected = 1;
        int number = 1;
        int actual = fibonacchiSum.recursiveSum(number);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void recursiveFibonacchiSum9Test() {
        int expected = 34;
        int number = 9;
        int actual = fibonacchiSum.recursiveSum(number);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void iterativeFibonacchiSum0Test() {
        int expected = 0;
        int number = 0;
        int actual = fibonacchiSum.iterativeSum(number);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void iterativeFibonacchiSum1Test() {
        int expected = 1;
        int number = 1;
        int actual = fibonacchiSum.iterativeSum(number);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void iterativeFibonacchiSum9Test() {
        int expected = 34;
        int number = 9;
        int actual = fibonacchiSum.iterativeSum(number);
        Assertions.assertEquals(expected, actual);
    }

}
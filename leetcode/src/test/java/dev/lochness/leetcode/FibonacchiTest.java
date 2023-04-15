package dev.lochness.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacchiTest {

    private Fibonacchi fibonacchi;

    @BeforeEach
    void setUp() {
        fibonacchi = new Fibonacchi();
    }

    @ParameterizedTest
    @CsvSource({"0, 0", "1, 1", "2, 1", "3, 2", "4, 3", "5, 5",
            "6, 8", "7, 13", "8, 21", "9, 34", "10, 55",
            "29, 514229", "30, 832040"})
    void fib(int n, int result) {
        int actual = fibonacchi.fib(n);
        assertEquals(result, actual);
    }
}
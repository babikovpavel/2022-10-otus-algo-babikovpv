package dev.lochness.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiveEightTest {

    private FiveEight fiveEight;

    @BeforeEach
    void setUp() {
        fiveEight = new FiveEight();
    }

    @Test
    void solve1() {
        int expected = 2;
        int actual = fiveEight.solve(1);
        assertEquals(expected, actual);
    }

    @Test
    void solve3() {
        int expected = 6;
        int actual = fiveEight.solve(3);
        assertEquals(expected, actual);
    }

    @Test
    void solve5() {
        int expected = 16;
        int actual = fiveEight.solve(5);
        assertEquals(expected, actual);
    }

    @Test
    void solve88() {
        int expected = 1022344602;
        int actual = fiveEight.solve(88);
        assertEquals(expected, actual);
    }
}
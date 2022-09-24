package dev.lochness.bitboards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovesCounterTest {

    private MovesCounter movesCounter;

    @BeforeEach
    void setUp() {
        movesCounter = new MovesCounter();
    }

    @Test
    void popCountByShift() {
        int expected = 3;
        int actual = movesCounter.popCountByShift(770);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void popCountBySub() {
        int expected = 3;
        int actual = movesCounter.popCountBySub(770);
        Assertions.assertEquals(expected, actual);
    }
}
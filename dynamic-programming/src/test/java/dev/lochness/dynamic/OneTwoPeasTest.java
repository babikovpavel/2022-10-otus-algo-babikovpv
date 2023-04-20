package dev.lochness.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneTwoPeasTest {

    private OneTwoPeas oneTwoPeas;

    @BeforeEach
    void setUp() {
        oneTwoPeas = new OneTwoPeas();
    }

    @Test
    void sum1() {
        String expected = "46/35";
        String actual = oneTwoPeas.sum("3/5 + 5/7");
        assertEquals(expected, actual);
    }

    @Test
    void sum2() {
        String expected = "19/45";
        String actual = oneTwoPeas.sum("3/15 + 4/18");
        assertEquals(expected, actual);
    }

    @Test
    void sum3() {
        String expected = "4/3";
        String actual = oneTwoPeas.sum("2/3 + 4/6");
        assertEquals(expected, actual);
    }
}
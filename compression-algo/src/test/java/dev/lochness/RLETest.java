package dev.lochness;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RLETest {

    private RLE rle;

    @BeforeEach
    void setUp() {
        rle = new RLE();
    }

    @Test
    void encodeStr1() {
        String expected = "6A3B1C5A1D1E2F1G5H";
        String actual = rle.encode("AAAAAABBBCAAAAADEFFGHHHHH");
        assertEquals(expected, actual);
    }

    @Test
    void encodeStr2() {
        String expected = "81A";
        String actual = rle.encode("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        assertEquals(expected, actual);
    }
}
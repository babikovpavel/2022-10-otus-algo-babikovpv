package dev.lochness.string.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BruteStringSearchTest {

    private BruteStringSearch bruteStringSearch;

    @BeforeEach
    void setUp() {
        bruteStringSearch = new BruteStringSearch();
    }

    @Test
    void simpleSearchTrue() {
        int expected = 2;
        int actual = bruteStringSearch.simpleSearch("a long long string", "long");
        assertEquals(expected, actual);
    }

    @Test
    void simpleSearchAtTheEnd() {
        int expected = 12;
        int actual = bruteStringSearch.simpleSearch("a long long string", "string");
        assertEquals(expected, actual);
    }

    @Test
    void simpleSearchFalse() {
        int expected = -1;
        int actual = bruteStringSearch.simpleSearch("a long long string", "short");
        assertEquals(expected, actual);
    }

    @Test
    void simpleSearchFalseLongSub() {
        int expected = -1;
        int actual = bruteStringSearch.simpleSearch("abc", "abcde");
        assertEquals(expected, actual);
    }

    @Test
    void searchWithShiftsTrue() {
        int expected = 2;
        int actual = bruteStringSearch.searchWithShifts("a long long string", "long");
        assertEquals(expected, actual);
    }

    @Test
    void searchWithShiftsFalse() {
        int expected = -1;
        int actual = bruteStringSearch.searchWithShifts("a long long string", "short");
        assertEquals(expected, actual);
    }
}
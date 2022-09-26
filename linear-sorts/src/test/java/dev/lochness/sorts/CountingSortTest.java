package dev.lochness.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static dev.lochness.sorts.ArrayUtils.fillRandom;
import static dev.lochness.sorts.ArrayUtils.isSorted;
import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {

    private CountingSort countingSort;

    @BeforeEach
    void setUp() {
        countingSort = new CountingSort();
    }

    @Test
    void sortTest() {
        int[] source = {1, 5, 6, 2, 8, 1};
        int[] expected = {1, 1, 2, 5, 6, 8};
        countingSort.sort(source);
        assertArrayEquals(expected, source);
    }

    @Test
    void sortSortedTest() {
        int[] source = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        countingSort.sort(source);
        assertArrayEquals(expected, source);
    }

    @Test
    void sort100Test() {
        int[] source = new int[100];
        fillRandom(source, 0, 999);
        LocalTime startTime = LocalTime.now();
        countingSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }

    @Test
    void sort1000Test() {
        int[] source = new int[1000];
        fillRandom(source, 0, 999);
        LocalTime startTime = LocalTime.now();
        countingSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }

    @Test
    void sort10_000Test() {
        int[] source = new int[10_000];
        fillRandom(source, 0, 999);
        LocalTime startTime = LocalTime.now();
        countingSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }

    @Test
    void sort100_000Test() {
        int[] source = new int[100_000];
        fillRandom(source, 0, 999);
        LocalTime startTime = LocalTime.now();
        countingSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }

    @Test
    void sort1_000_000Test() {
        int[] source = new int[1_000_000];
        fillRandom(source, 0, 999);
        LocalTime startTime = LocalTime.now();
        countingSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }
}
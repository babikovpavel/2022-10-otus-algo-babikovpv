package dev.lochness.sorts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static dev.lochness.sorts.ArrayUtils.fillRandom;
import static dev.lochness.sorts.ArrayUtils.isSorted;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleSortTest {

    private BubbleSort bubbleSort;

    @BeforeEach
    void setUp() {
        bubbleSort = new BubbleSort();
    }

    @Test
    void sortTest() {
        int[] source = {1, 5, 6, 2, 8, 1};
        int[] expected = {1, 1, 2, 5, 6, 8};
        bubbleSort.sort(source);
        assertArrayEquals(expected, source);
    }

    @Test
    void sortSortedTest() {
        int[] source = {1, 2, 3, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};
        bubbleSort.sort(source);
        assertArrayEquals(expected, source);
    }

    @Test
    void sort10_000Test() {
        int[] source = new int[10_000];
        fillRandom(source, 10_000);
        LocalTime startTime = LocalTime.now();
        bubbleSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }

    @Test
    void sort100_000Test() {
        int[] source = new int[100_000];
        fillRandom(source, 100_000);
        LocalTime startTime = LocalTime.now();
        bubbleSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }

    @Test
    void sort1_000_000Test() {
        int[] source = new int[1_000_000];
        fillRandom(source, 1_000_000);
        LocalTime startTime = LocalTime.now();
        bubbleSort.sort(source);
        LocalTime endTime = LocalTime.now();
        System.out.println(startTime.until(endTime, ChronoUnit.MILLIS));
        assertTrue(isSorted(source));
    }
}
package dev.lochness.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    @Test
    void twoSum1() {
        int[] nums = {2, 7, 11, 15};
        int[] expected = {0, 1};
        int[] actual = twoSum.twoSum(nums, 9);
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    @Test
    void twoSum2() {
        int[] nums = {0, 4, 3, 0};
        int[] expected = {0, 3};
        int[] actual = twoSum.twoSum(nums, 0);
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    @Test
    void twoSum3() {
        int[] nums = {3, 3};
        int[] expected = {0, 1};
        int[] actual = twoSum.twoSum(nums, 6);
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    @Test
    void twoSum4() {
        int[] nums = {3, 2, 4};
        int[] expected = {};
        int[] actual = twoSum.twoSum(nums, 9);
        assertArrayEquals(expected, actual);
    }
}
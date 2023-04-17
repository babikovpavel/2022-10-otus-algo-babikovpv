package dev.lochness.leetcode;

// https://leetcode.com/problems/house-robber
public class Robber {

    public int rob(int[] nums) {
        return doRobbery(nums, nums.length - 1);
    }

    private int doRobbery(int[] nums, int index) {
        if (index == 0) {
            return nums[0];
        }
        if (index == 1) {
            return Math.max(nums[0], nums[1]);
        }
        int previousMax = nums[0];
        int currentMax = Math.max(nums[0], nums[1]);
        for (int i = 2; i <= index; i++) {
            int k = previousMax;
            previousMax = currentMax;
            currentMax = Math.max(nums[i] + k, currentMax);
        }
        return currentMax;
    }
}

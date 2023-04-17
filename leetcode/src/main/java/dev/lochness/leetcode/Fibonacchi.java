package dev.lochness.leetcode;

// https://leetcode.com/problems/fibonacci-number/
public class Fibonacchi {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n > 1 && n <= 30) {
            int[] fibCalc = new int[n + 1]; //для кэширования предыдущего значения
            fibCalc[1] = 1;
            fibCalc[2] = 1;
            for (int i = 3; i <= n; i++) {
                fibCalc[i] = fibCalc[i - 2] + fibCalc[i - 1];
            }
            return fibCalc[n];
        }
        throw new IllegalArgumentException("n must be between 0 and 30");
    }
}

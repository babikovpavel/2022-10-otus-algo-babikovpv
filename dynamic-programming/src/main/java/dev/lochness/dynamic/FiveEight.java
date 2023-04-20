package dev.lochness.dynamic;

// задача "Пятью-восемь"
public class FiveEight {

    // 1 <= N <= 88
    public int solve(int N) {
        if (N < 1 || N > 88) {
            throw new IllegalArgumentException("N must be between 1 and 88");
        }
        if(N == 1) {
            return 2;
        }
        if(N == 2) {
            return 4;
        }

        //x5, x55, x8, x88
        int[] variants = {1, 1, 1, 1};

        //x5 -> x55 || x8
        //x8 -> x88 || x5
        //x55 -> x8
        //x88 -> x5
        for (int i = 3; i <= N; i++) {
            int x5 = variants[0];
            int x55 = variants[1];
            int x8 = variants[2];
            int x88 = variants[3];

            variants[0] = x8 + x88;
            variants[1] = x5;
            variants[2] = x5 + x55;
            variants[3] = x8;
        }


        int sum = 0;
        for(int j : variants) {
            sum += j;
        }

        return sum;
    }
}

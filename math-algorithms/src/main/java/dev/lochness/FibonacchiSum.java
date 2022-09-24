package dev.lochness;

public class FibonacchiSum {

    public int recursiveSum(int number) {
        switch (number) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return recursiveSum(number - 1) + recursiveSum(number - 2);
        }
    }

    public int iterativeSum(int number) {
        if(number == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;
        int sum = a + b;
        for (int i = 1; i < number; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }
}

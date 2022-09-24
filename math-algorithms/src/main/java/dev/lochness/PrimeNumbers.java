package dev.lochness;

public class PrimeNumbers {

    public int countPrimeNumbers(long limit) {
        int count = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(long number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

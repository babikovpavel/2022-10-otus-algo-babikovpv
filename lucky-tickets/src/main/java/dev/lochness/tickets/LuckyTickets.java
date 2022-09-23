package dev.lochness.tickets;

public class LuckyTickets {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 999; i++) {
            for (int j = 0; j <= 999; j++) {
                if(sumOfNumbers(i) == sumOfNumbers(j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static int sumOfNumbers(int number) {
        int hundreds = number / 100;
        int dozens = number % 100 / 10;
        int units = number % 10;
        return hundreds + dozens + units;
    }
}
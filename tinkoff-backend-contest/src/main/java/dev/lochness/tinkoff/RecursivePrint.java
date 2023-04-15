package dev.lochness.tinkoff;

import java.util.Scanner;

public class RecursivePrint {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var inputNumber = Integer.parseInt(scanner.nextLine());
        print(inputNumber);
    }

    public static void print(int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1);
        }
    }
}

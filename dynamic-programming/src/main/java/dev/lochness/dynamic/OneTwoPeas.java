package dev.lochness.dynamic;

// задача "раз/два горох"
// На вход приходит строка, например "3/5 + 7/9", выход - сумма дробей.
public class OneTwoPeas {

    public String sum(String source) {
        String[] numbers = source.split(" \\+ ");
        String[] firstNumber = numbers[0].split("/");
        String[] secondNumber = numbers[1].split("/");
        int firstDividend = Integer.parseInt(firstNumber[0]);
        int firstDivisor = Integer.parseInt(firstNumber[1]);
        int secondDividend = Integer.parseInt(secondNumber[0]);
        int secondDivisor = Integer.parseInt(secondNumber[1]);
        int LCM = LCM(firstDivisor, secondDivisor);
        int sumDividend = firstDividend * (LCM / firstDivisor) + secondDividend * (LCM / secondDivisor);
        int GCD = GCD(sumDividend, LCM);
        return String.format("%d/%d", sumDividend / GCD, LCM / GCD);
    }

    //наибольший общий делитель
    private static int GCD(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (isEven(a) && isEven(b)) {
            return GCD(a >> 1, b >> 1) << 1;
        }
        if (isEven(a) && isOdd(b)) {
            return GCD(a >> 1, b);
        }
        if (isOdd(a) && isEven(b)) {
            return GCD(a, b >> 1);
        }
        if (a > b) {
            return GCD((a - b) >> 1, b);
        }
        return GCD(a, (b - a) >> 1);
    }

    //наименьшее общее кратное
    private static int LCM(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a == b) {
            return a;
        } else if (a > b) {
            return a % b == 0 ? a : a * b;
        } else {
            return b % a == 0 ? b : a * b;
        }
    }

    private static boolean isEven(int a) {
        return a % 2 == 0;
    }

    private static boolean isOdd(int a) {
        return !isEven(a);
    }
}

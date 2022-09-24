package dev.lochness;

public class PowNumber {

    public double iterativePow(double number, int degree) {
        double result = 1;
        for (int i = 0; i < degree; i++) {
            result *= number;
        }
        return result;
    }

}

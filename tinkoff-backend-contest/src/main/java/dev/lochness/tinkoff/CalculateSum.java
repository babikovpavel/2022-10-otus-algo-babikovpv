package dev.lochness.tinkoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class CalculateSum {
    public static void main(String args[]) {
        BufferedReader inputDataBR = new BufferedReader(new InputStreamReader(System.in));
        List<Double> persents = TCupUtil.getDoubles(inputDataBR);
        List<Double> purchases = TCupUtil.getDoubles(inputDataBR);
        System.out.println(getSum(persents, purchases));
    }

    public static double getSum(List<Double> persents, List<Double> purchases) {
        double sum = 0;
        for (int i = 0; i < purchases.size(); i++) {
            sum = sum + purchases.get(i) * persents.get(i + 1);
        }
        return sum;
    }

}

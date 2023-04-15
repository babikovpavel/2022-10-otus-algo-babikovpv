package dev.lochness.tinkoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;

public class CalculateSum2 {
    public static void main(String args[]) {
        BufferedReader inputDataBR = new BufferedReader(new InputStreamReader(System.in));

        List<Double> persents = List.of(0.1, 0.02);
        List<Double> purchases = List.of(100.0, 300.0);

        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < purchases.size(); i++) {
            BigDecimal cashback = BigDecimal.valueOf(purchases.get(i)).multiply(BigDecimal.valueOf(persents.get(i)));
            sum = sum.add(cashback);
        }
        System.out.println(sum);
    }

}

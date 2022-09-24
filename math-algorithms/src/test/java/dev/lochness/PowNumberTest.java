package dev.lochness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PowNumberTest {

    private PowNumber powNumber;

    @BeforeEach
    void setUp() {
        powNumber = new PowNumber();
    }

    @Test
    void iterativePow1000Test() {
        double expected = 2.7169239322355985;
        double number = 1.001;
        int degree = 1000;
        double actual = powNumber.iterativePow(number, degree);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void iterativePowZeroDegreeTest() {
        double expected = 1;
        double number = 1.001;
        int degree = 0;
        double actual = powNumber.iterativePow(number, degree);
        Assertions.assertEquals(expected, actual);
    }
}
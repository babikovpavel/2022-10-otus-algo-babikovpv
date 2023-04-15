package dev.lochness.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobberTest {

    private Robber robber;

    @BeforeEach
    void setUp() {
        robber = new Robber();
    }

    @Test
    void rob1() {
        int[] houses = {1, 2, 3, 1};
        int money = robber.rob(houses);
        assertEquals(4, money);
    }

    @Test
    void rob2() {
        int[] houses = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236,
                81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188,
                67, 205, 94, 205, 169, 241, 202, 144, 240};
        int money = robber.rob(houses);
        assertEquals(4173, money);
    }
}
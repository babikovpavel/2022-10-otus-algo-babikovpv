package dev.lochness.btree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomTreeTest {

    private RandomTree randomTree;

    @BeforeEach
    public void init() {
        randomTree = new RandomTree();
    }

    @Test
    void insertSplayRequiredTest() {
        while (randomTree.getNodesCount() < 100) {
            randomTree.insert(getRandomInt(1000));
        }
        randomTree.insert(1001);
        assertEquals(1001, randomTree.getRoot().getKey());
    }

    @Test
    void complex10000RandomTest() {
        RandomTree randomTree = new RandomTree();

        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < 10000; i++) {
            randomTree.insert(getRandomInt(10000));
        }
        LocalTime insertTime = LocalTime.now();
        System.out.println("Insert 10000 random numbers: " + startTime.until(insertTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            randomTree.search(getRandomInt(10000));
        }
        LocalTime searchTime = LocalTime.now();
        System.out.println("Random number search 1000x times: " + insertTime.until(searchTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            randomTree.search(getRandomInt(10));
        }
        LocalTime searchZeroToTenTime = LocalTime.now();
        System.out.println("1 to 10 search 1000x times: " + searchTime.until(searchZeroToTenTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            randomTree.remove(getRandomInt(10000));
        }
        LocalTime removeTime = LocalTime.now();
        System.out.println("Remove 1000 random numbers: " + searchZeroToTenTime.until(removeTime, ChronoUnit.MILLIS));
    }

    @Test
    void complex10000SortedTest() {
        RandomTree randomTree = new RandomTree();

        LocalTime startTime = LocalTime.now();
        for (int i = 1; i <= 10000; i++) {
            randomTree.insert(i);
        }
        LocalTime insertTime = LocalTime.now();
        System.out.println("Insert 10000 serial numbers: " + startTime.until(insertTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            randomTree.search(getRandomInt(10000));
        }
        LocalTime searchTime = LocalTime.now();
        System.out.println("Random number search 1000x times: " + insertTime.until(searchTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            randomTree.search(getRandomInt(10));
        }
        LocalTime searchZeroToTenTime = LocalTime.now();
        System.out.println("1 to 10 search 1000x times: " + searchTime.until(searchZeroToTenTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            randomTree.remove(getRandomInt(10000));
        }
        LocalTime removeTime = LocalTime.now();
        System.out.println("Remove 1000 random numbers: " + searchZeroToTenTime.until(removeTime, ChronoUnit.MILLIS));
    }

    private int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }
}
package dev.lochness.btree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private SplayTree splayTree;

    @BeforeEach
    void setUp() {
        splayTree = new SplayTree();
    }

    @Test
    void insertRootElementTest() {
        splayTree.insert(10);
        assertEquals(10, splayTree.getRoot().getKey());
    }

    @Test
    void insertMultipleNodesTest() {
        splayTree.insert(10);
        splayTree.insert(5);
        splayTree.insert(15);
        splayTree.insert(1);
        SplayTreeNode actualRoot = splayTree.getRoot();
        assertAll(() -> {
            assertEquals(1, actualRoot.getKey());
            assertNull(actualRoot.getLeft());
            assertEquals(actualRoot, actualRoot.getRight().getParent());
        });
    }

    @Test
    void removeRootNodeTest() {
        splayTree.insert(10);
        splayTree.insert(5);
        splayTree.insert(15);
        splayTree.insert(1);
        splayTree.remove(1);
        SplayTreeNode actualRoot = splayTree.getRoot();
        assertAll(() -> {
            assertEquals(15, actualRoot.getKey());
            assertNull(actualRoot.getRight());
            assertEquals(actualRoot, actualRoot.getLeft().getParent());
        });
    }

    @Test
    void removeNodeTest() {
        splayTree.insert(10);
        splayTree.insert(5);
        splayTree.insert(15);
        splayTree.insert(1);
        splayTree.remove(5);
        SplayTreeNode actualRoot = splayTree.getRoot();
        assertAll(() -> {
            assertEquals(1, actualRoot.getKey());
            assertNull(actualRoot.getLeft());
            assertEquals(15, actualRoot.getRight().getKey());
        });
    }

    @Test
    void searchNodeTrueTest() {
        splayTree.insert(10);
        splayTree.insert(5);
        splayTree.insert(15);
        splayTree.insert(1);
        boolean isFound = splayTree.search(5);
        SplayTreeNode actualRoot = splayTree.getRoot();
        assertAll(() -> {
            assertTrue(isFound);
            assertEquals(5, actualRoot.getKey());
        });
    }

    @Test
    void searchNodeFalseTest() {
        splayTree.insert(10);
        splayTree.insert(5);
        splayTree.insert(15);
        splayTree.insert(1);
        boolean isFound = splayTree.search(50);
        SplayTreeNode actualRoot = splayTree.getRoot();
        assertAll(() -> {
            assertFalse(isFound);
            assertEquals(1, actualRoot.getKey());
        });
    }

    @Test
    void complex10000RandomTest() {
        SplayTree splayTree = new SplayTree();

        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < 10000; i++) {
            splayTree.insert(getRandomInt(10000));
        }
        LocalTime insertTime = LocalTime.now();
        System.out.println("Insert 10000 random numbers: " + startTime.until(insertTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            splayTree.search(getRandomInt(10000));
        }
        LocalTime searchTime = LocalTime.now();
        System.out.println("Random number search 1000x times: " + insertTime.until(searchTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            splayTree.search(getRandomInt(10));
        }
        LocalTime searchZeroToTenTime = LocalTime.now();
        System.out.println("1 to 10 search 1000x times: " + searchTime.until(searchZeroToTenTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            splayTree.remove(getRandomInt(10000));
        }
        LocalTime removeTime = LocalTime.now();
        System.out.println("Remove 1000 random numbers: " + searchZeroToTenTime.until(removeTime, ChronoUnit.MILLIS));
    }

    @Test
    void complex10000SortedTest() {
        SplayTree splayTree = new SplayTree();

        LocalTime startTime = LocalTime.now();
        for (int i = 1; i <= 10000; i++) {
            splayTree.insert(i);
        }
        LocalTime insertTime = LocalTime.now();
        System.out.println("Insert 10000 sorted numbers: " + startTime.until(insertTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            splayTree.search(getRandomInt(10000));
        }
        LocalTime searchTime = LocalTime.now();
        System.out.println("Random number search 1000x times: " + insertTime.until(searchTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            splayTree.search(getRandomInt(10));
        }
        LocalTime searchZeroToTenTime = LocalTime.now();
        System.out.println("1 to 10 search 1000x times: " + searchTime.until(searchZeroToTenTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 1000; i++) {
            splayTree.remove(getRandomInt(10000));
        }
        LocalTime removeTime = LocalTime.now();
        System.out.println("Remove 1000 random numbers: " + searchZeroToTenTime.until(removeTime, ChronoUnit.MILLIS));
    }


    private int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }
}
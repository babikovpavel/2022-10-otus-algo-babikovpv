package dev.lochness.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void setUp() {
        binarySearchTree = new BinarySearchTree(45);
    }

    @Test
    void insertSmallerTest() {
        binarySearchTree.insert(30);
        assertAll(() -> {
            assertEquals(30, binarySearchTree.getLeft().getKey());
            assertNull(binarySearchTree.getRight());
            assertEquals(binarySearchTree, binarySearchTree.getLeft().getParent());
        });
    }

    @Test
    void insertBiggerTest() {
        binarySearchTree.insert(60);
        assertAll(() -> {
            assertEquals(60, binarySearchTree.getRight().getKey());
            assertNull(binarySearchTree.getLeft());
            assertEquals(binarySearchTree, binarySearchTree.getRight().getParent());
        });
    }

    @Test
    void insertEqualTest() {
        binarySearchTree.insert(45);
        assertAll(() -> {
            assertNull(binarySearchTree.getLeft());
            assertNull(binarySearchTree.getRight());
        });
    }

    @Test
    void searchTest() {
        binarySearchTree.insert(10);
        binarySearchTree.insert(64);
        binarySearchTree.insert(32);
        binarySearchTree.insert(86);
        assertAll(() -> {
            assertTrue(binarySearchTree.search(86));
            assertFalse(binarySearchTree.search(11));
        });
    }

    /*      45
             \
              64
             /  \
            63  86
            /   / \
           62  84  90
     */
    @Test
    void remove2ChildsTest() {
        binarySearchTree.insert(64);
        binarySearchTree.insert(63);
        binarySearchTree.insert(62);
        binarySearchTree.insert(86);
        binarySearchTree.insert(84);
        binarySearchTree.insert(90);
        //test
        binarySearchTree.remove(64);
        //assert
        BinarySearchTree actual = binarySearchTree.getRight();
        assertAll(() -> {
            assertEquals(84, actual.getKey());
            assertEquals(63, actual.getLeft().getKey());
            assertEquals(86, actual.getRight().getKey());
        });
    }

    /*      45
             \
              64
             /
            63
     */
    @Test
    void remove0ChildsTest() {
        binarySearchTree.insert(64);
        binarySearchTree.insert(63);
        //test
        binarySearchTree.remove(63);
        //assert
        assertNull(binarySearchTree.getRight().getLeft());
    }

    /*  45
         \
          64
         /
        63
    */
    @Test
    void remove1ChildsTest() {
        binarySearchTree.insert(64);
        binarySearchTree.insert(63);
        //test
        binarySearchTree.remove(64);
        //assert
        assertEquals(63, binarySearchTree.getRight().getKey());
    }

    /*  45
         \
         64
           \
            89

*/
    @Test
    void remove1ChildBiggerTest() {
        binarySearchTree.insert(64);
        binarySearchTree.insert(89);
        //test
        binarySearchTree.remove(64);
        //assert
        assertEquals(89, binarySearchTree.getRight().getKey());
    }

    @Test
    void sort() {
        System.setOut(new PrintStream(outputStreamCaptor));
        binarySearchTree.insert(64);
        binarySearchTree.insert(63);
        binarySearchTree.insert(62);
        binarySearchTree.insert(86);
        binarySearchTree.insert(84);
        binarySearchTree.insert(90);
        binarySearchTree.sort();
        assertEquals("[45] [62] [63] [64] [84] [86] [90]", outputStreamCaptor.toString().trim());
    }

    @Test
    void complex1000RandomTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(5000);

        LocalTime startTime = LocalTime.now();
        for (int i = 0; i < 10000; i++) {
            binarySearchTree.insert(getRandomInt());
        }
        LocalTime insertTime = LocalTime.now();
        System.out.println(startTime.until(insertTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 100; i++) {
            binarySearchTree.search(getRandomInt());
        }
        LocalTime searchTime = LocalTime.now();
        System.out.println(insertTime.until(searchTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 100; i++) {
            binarySearchTree.remove(getRandomInt());
        }
        LocalTime removeTime = LocalTime.now();
        System.out.println(searchTime.until(removeTime, ChronoUnit.MILLIS));
    }

    @Test
    void complex1000SortedTest() {
        BinarySearchTree binarySearchTree = new BinarySearchTree(0);

        LocalTime startTime = LocalTime.now();
        for (int i = 1; i <= 10000; i++) {
            binarySearchTree.insert(i);
        }
        LocalTime insertTime = LocalTime.now();
        System.out.println(startTime.until(insertTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 100; i++) {
            binarySearchTree.search(getRandomInt());
        }
        LocalTime searchTime = LocalTime.now();
        System.out.println(insertTime.until(searchTime, ChronoUnit.MILLIS));

        for (int i = 0; i < 100; i++) {
            binarySearchTree.remove(getRandomInt());
        }
        LocalTime removeTime = LocalTime.now();
        System.out.println(searchTime.until(removeTime, ChronoUnit.MILLIS));
    }


    private int getRandomInt() {
        return (int) (Math.random() * 10000);
    }
}
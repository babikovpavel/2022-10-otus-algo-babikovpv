package dev.lochness.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IslandsTest {

    private Islands islands;

    @BeforeEach
    void setUp() {
        islands = new Islands();
    }

    @Test
    void solve1() {
        int[][] map = {
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };
        int expected = 4;
        int actual = islands.solve(map);
        assertEquals(expected, actual);
    }

    @Test
    void solve2() {
        int[][] map = {
                {0, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0}
        };
        int expected = 4;
        int actual = islands.solve(map);
        assertEquals(expected, actual);
    }

    @Test
    void solve3() {
        int[][] map = {
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 1}
        };
        int expected = 6;
        int actual = islands.solve(map);
        assertEquals(expected, actual);
    }

    @Test
    void solve4() {
        int[][] map = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        int expected = 1;
        int actual = islands.solve(map);
        assertEquals(expected, actual);
    }

    @Test
    void solve5() {
        int[][] map = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int expected = 0;
        int actual = islands.solve(map);
        assertEquals(expected, actual);
    }
}
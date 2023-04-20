package dev.lochness.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChristmasTreeGarlandTest {

    private ChristmasTreeGarland christmasTreeGarland;

    @BeforeEach
    void setUp() {
        christmasTreeGarland = new ChristmasTreeGarland();
    }

    @Test
    void solve() {
        Integer[][] tree = {
                {1, null, null, null},
                {2, 3, null, null},
                {4, 5, 6, null},
                {9, 8, 0, 3}
        };
        int expected = 17;
        int actual = christmasTreeGarland.solve(tree);
        assertEquals(expected, actual);
    }
}
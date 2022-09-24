package dev.lochness.bitboards.knight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KnightMovesTest {

    private KnightMoves knightMoves;

    @BeforeEach
    void setUp() {
        knightMoves = new KnightMoves();
    }

    @Test
    void getPossibleKnightMovesA1Test() {
        long expected = Long.parseUnsignedLong("132096");
        long actual = knightMoves.getPossibleKnightMoves(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPossibleKnightMovesD4Test() {
        long expected = Long.parseUnsignedLong("22136263676928");
        long actual = knightMoves.getPossibleKnightMoves(27);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPossibleKnightMovesG8Test() {
        long expected = Long.parseUnsignedLong("4679521487814656");
        long actual = knightMoves.getPossibleKnightMoves(62);
        Assertions.assertEquals(expected, actual);
    }
}
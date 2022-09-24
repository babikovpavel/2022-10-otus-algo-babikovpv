package dev.lochness.bitboards.king;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingMovesTest {

    private KingMoves kingMoves;

    @BeforeEach
    void setUp() {
        kingMoves = new KingMoves();
    }

    @Test
    void getPossibleKingMovesA1Test() {
        long expected = Long.parseUnsignedLong("770");
        long actual = kingMoves.getPossibleKingMoves(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPossibleKingMovesD4Test() {
        long expected = Long.parseUnsignedLong("120596463616");
        long actual = kingMoves.getPossibleKingMoves(27);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPossibleKingMovesG8Test() {
        long expected = Long.parseUnsignedLong("11592265440851656704");
        long actual = kingMoves.getPossibleKingMoves(62);
        Assertions.assertEquals(expected, actual);
    }
}
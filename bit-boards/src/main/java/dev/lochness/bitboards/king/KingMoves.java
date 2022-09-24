package dev.lochness.bitboards.king;

public class KingMoves {

    public long getPossibleKingMoves(int position) {
        long startPosition = Long.parseUnsignedLong("1") << position;
        long notA = Long.parseUnsignedLong("18374403900871474942");
        long notH = Long.parseUnsignedLong("9187201950435737471");
        long leftKingMoves = startPosition & notA;
        long rightKingMoves = startPosition & notH;
        return leftKingMoves << 7  | startPosition << 8 | rightKingMoves << 9 |
                leftKingMoves >> 1 |                     rightKingMoves << 1 |
                leftKingMoves >> 9 | startPosition >> 8 | rightKingMoves >> 7;
    }
}

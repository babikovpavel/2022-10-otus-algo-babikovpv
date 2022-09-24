package dev.lochness.bitboards.knight;

public class KnightMoves {

    public long getPossibleKnightMoves(int position) {
        long startPosition = Long.parseUnsignedLong("1") << position;
        long notA = Long.parseUnsignedLong("18374403900871474942");
        long notAB = Long.parseUnsignedLong("18229723555195321596");
        long notH = Long.parseUnsignedLong("9187201950435737471");
        long notGH = Long.parseUnsignedLong("4557430888798830399");
        return notGH & (startPosition << 6  | startPosition >> 10)
                | notH & (startPosition << 15 | startPosition >> 17)
                | notA & (startPosition << 17 | startPosition >> 15)
                | notAB & (startPosition << 10 | startPosition >> 6);
    }
}

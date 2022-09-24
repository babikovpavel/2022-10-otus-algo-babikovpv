package dev.lochness.bitboards;

public class MovesCounter {

    public int popCountByShift(long mask) {
        int count = 0;
        while (mask > 0) {
            if ((mask & 1) == 1) {
                count++;
            }
            mask >>= 1;
        }
        return count;
    }

    public int popCountBySub(long mask) {
        int count = 0;
        while (mask > 0) {
            count++;
            mask &= mask - 1;
        }
        return count;
    }
}

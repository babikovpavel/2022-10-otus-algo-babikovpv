package dev.lochness.harry;

import java.io.IOException;

public class HarryPotterSquare {

    /*
    1. x < y
    2. x == y
    3. x == 24 - y
    4. x < 30 - y
    5. x == y / 2 + 3
    6. x < 10 || y < 10
    7. x > 15 && y > 15
     */
    public static void main(String[] args) throws IOException {
        for (int x = 0; x < 25; x++) {
            for (int y = 0; y < 25; y++) {
                System.out.print(x < y ? "# " : ". ");
            }
            System.out.println();
        }
        System.in.read();
    }
}

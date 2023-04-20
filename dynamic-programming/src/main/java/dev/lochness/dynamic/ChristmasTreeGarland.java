package dev.lochness.dynamic;

// задача "Цифровая ёлочка"
public class ChristmasTreeGarland {

    public int solve(Integer[][] source) {
        for (int i = source.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                source[i][j] = Math.max(source[i + 1][j], source[i + 1][j + 1]) + source[i][j];
            }
        }
        return source[0][0];
    }
}

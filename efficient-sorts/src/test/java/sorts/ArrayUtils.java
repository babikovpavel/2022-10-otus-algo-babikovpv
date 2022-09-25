package sorts;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class ArrayUtils {

    public static void fillRandom(int[] source, int seed) {
        Random random = new Random(seed);
        for (int i = 0; i < source.length; i++) {
            source[i] = random.nextInt();
        }
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}

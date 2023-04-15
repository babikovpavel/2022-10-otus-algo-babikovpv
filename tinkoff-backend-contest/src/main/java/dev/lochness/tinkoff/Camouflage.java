package dev.lochness.tinkoff;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Camouflage {

    public static void main(String args[])
    {
        var scanner = new Scanner(System.in);
        var input = "РҐРѕС‰СѓСЏ СЋСЉРЅР¶СѓР±, Рѕ С‘РѕС€СЊС‡С‰ СЋСЉРѕС‘СѓР±.";

        // декодируйте строку

        String result = new String(input.getBytes(), StandardCharsets.UTF_8);

        result = result.replace("о", "а").replace("щ", "к").replace("у","е").replace("я", "р")
                        .replace("ю", "п").replace("ъ","л").replace("н","я")
                        .replace("к", "ш").replace("б","т")
                        .replace("ё","ч").replace("о","а").replace("ш", "й")
                        .replace("ь","н").replace("ч","и")
                        .replace("у", "е");

        System.out.println(result);
    }
}

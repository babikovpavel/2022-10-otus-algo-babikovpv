package dev.lochness;

public class RLE {

    public String encode(String source) {
        StringBuilder output = new StringBuilder();
        int length = source.length();
        for (int i = 0; i < length; i++) {
            int count = 1;
            while (i < length - 1 && source.charAt(i) == source.charAt(i + 1)) {
                count++;
                i++;
            }
            output.append(count)
                    .append(source.charAt(i));
        }
        return output.toString();
    }
}

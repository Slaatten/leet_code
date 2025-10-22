package lc.arrayshashing;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray(); // omgjør til et array
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray); // sorterer arrayet
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        boolean result = va.isAnagram("cba", "bce");
        System.out.println(result);
    }
}
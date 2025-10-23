package lc.arrayshashing;

import java.util.HashMap;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            System.out.println("Ikke samme lengde på strengene");
            return false;

        }

        // Hashmaps inneholder nøkkel-verdi par
        HashMap<Character, Integer> sHashMap = new HashMap<>();
        HashMap<Character, Integer> tHashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sHashMap.put(s.charAt(i), sHashMap.getOrDefault(s.charAt(i), 0) + 1);
            // s.charAt(i) legger til nøkkelen, altså selve tegnet.
            // getOrDefault sjekker om tegnet vi har lagt til finnes, hvis ja så henter den
            // verdien.
            // hvis ikke så bruker den 0 som standard verdi og plusser forekomsten med 1.
            tHashMap.put(t.charAt(i), tHashMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sHashMap.equals(tHashMap);

        /*
         * char[] sArray = s.toCharArray(); // omgjør til et array
         * char[] tArray = t.toCharArray();
         * 
         * Arrays.sort(sArray); // sorterer arrayet
         * Arrays.sort(tArray);
         * 
         * return Arrays.equals(sArray, tArray);
         */
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        boolean result = va.isAnagram("acr", "abc");
        System.out.println(result);
    }
}
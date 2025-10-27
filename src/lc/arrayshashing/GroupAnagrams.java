package lc.arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>(); // nøkkelen er en streng verdien er lista med ord som er koblet
                                                         // opp imot nøkkelen.

        for (String s : strs) { // iterer gjennom array strs hvorav s er hvert element
            int[] count = new int[26]; // lager et array som holder styr på hva da?
            for (char c : s.toCharArray()) {
                count[c - 'a']++; // 'b' = 98 'a' = 97, derfor får b plass count[1] f.eks.
            }
            String key = Arrays.toString(count); // gjør arrayet om til en streng som kan brukes til nøkkel
            res.putIfAbsent(key, new ArrayList<>()); // legger til dersom nøkkel ikke finnes fra før
            res.get(key).add(s); // henter nøkkelen og legger til verdien som passer nøkkelen.
        }
        return new ArrayList<>(res.values()); // returnerer verdiene i hashmappet.
    }

    public static void main(String[] args) {
        String[] res = { "act", "pots", "tops", "cat", "stop", "hat" };
        GroupAnagrams ga = new GroupAnagrams();
        List<List<String>> anagram = ga.groupAnagrams(res);
        System.out.println(anagram);
    }
    /*
     * Tidskompleksitet = O (m * n log n) hvorav m er antall strenger og n er lengde
     * på den lengste strengen.
     * public List<List<String>> groupAnagrams(String[] strs) {
     * if (strs.length < 1 || strs.length > 1000) {
     * System.out.
     * println("Listen må bestå av minst ett element og kan ikke overstige 1000");
     * return new ArrayList<>();
     * }
     * 
     * Map<String, List<String>> res = new HashMap<>();
     * 
     * for (String s : strs) {
     * char[] charArray = s.toCharArray(); // legger vi til elementene i et
     * charArray
     * Arrays.sort(charArray); // sorterer
     * String sorted = new String(charArray); // Lager dette om til en String
     * res.putIfAbsent(sorted, new ArrayList<>()); // dersom det ikke finnes så
     * legger vi dette til i vårt HashMap
     * // som en nøkkel
     * res.get(sorted).add(s); // vi finner en match og legger f.eks. "cat" inn i
     * nøkkelen som matcher. { "act"
     * // = ["act", "cat"] }
     * }
     * return new ArrayList<>(res.values());
     * }
     */
}

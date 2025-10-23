package lc.arrayshashing;

import java.util.HashMap;
// import java.util.logging.Handler;

// Hashmap løsning med tidskompleksitet på O(n)
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        // Lager et hashmap som kobler tallet med indeksen det ligger på i arrayet.
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        // denne løkka kjører 2 ganger før den treffer dersom nums og target er slik som
        // de er nå.
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; // henter ut tallet vi skal se på akkurat nå
            int diff = target - nums[i]; // regner ut hva vi trenger for å finne target.

            // sjekker om differansen vi trenger finnes
            if (prevMap.containsKey(diff)) {
                // returnerer indeksen til diffen, returnerer indeksen til tallet vi traff
                // nettop
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i); // legger til tallet på en valgt indeks til senere
        }

        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 6 };
        int target = 7;
        TwoSum ts = new TwoSum(); // lager et objekt av klassen TwoSum og kaller den ts
        int[] result = ts.twoSum(nums, target); // lager et array result som er resultatet av metoden twoSum
        if (result.length == 2) {
            System.out.println(result[0] + " " + result[1]);
        } else {
            System.out.println("Ingen løsning");
        }
    }
}

// Brute Force med tidskompleksitet: O(n^2)
/*
 * public class TwoSum {
 * public int[] twoSum(int[] nums, int target) {
 * 
 * for (int i = 0; i < nums.length; i++) {
 * for (int j = i + 1; j < nums.length; j++) {
 * if (nums[i] + nums[j] == target && nums[i] != nums[j]) {
 * return new int[] { i, j };
 * }
 * }
 * }
 * 
 * return new int[0]; // returner et tomt array hvis ingen løsning blir funnet
 * }
 * 
 * public static void main(String[] args) {
 * int[] nums = { 3, 4, 5, 6 };
 * int target = 12;
 * TwoSum ts = new TwoSum(); // lager et objekt av klassen TwoSum og kaller den
 * ts
 * int[] result = ts.twoSum(nums, target); // lager et array result som er
 * resultatet av metoden twoSum
 * if (result.length == 2) {
 * System.out.println(result[0] + " " + result[1]);
 * } else {
 * System.out.println("Ingen løsning");
 * }
 * }
 * 
 * }
 */

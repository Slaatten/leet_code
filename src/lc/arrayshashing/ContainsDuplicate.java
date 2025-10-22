package lc.arrayshashing;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>(); // lagret et tomt HashSet som lagrer tall vi har sett
        for (int num : nums) { // iterer over arrayet nums
            if (numSet.contains(num)) { // sjekker om Hashsettet innholder verdien
                return true; // returner true dersom det er en duplikat
            }
            numSet.add(num); // legger så til tallet
        }
        return false; // fant ingen duplikater
    }

    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        boolean result = cd.hasDuplicate(new int[] { 1, 2, 3, 4 });
        System.out.println(result);
    }

    // Brute force løsning
    /*
     * public boolean hasDuplicate(int[] nums) {
     * 
     * for (int i = 0; i < nums.length; i++) { // bruk -1 dersom du må se framover
     * (i+1) i arrayet, ikke nødvendig her
     * // pga 2 løkker.
     * for (int j = i + 1; j < nums.length; j++) {
     * if (nums[i] == nums[j]) {
     * return true;
     * }
     * }
     * }
     * return false;
     * }
     */
}

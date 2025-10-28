package lc.arrayshashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Tidskompleksitet på O(n log n)
// Plass brukt O(n)

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < 1 || nums.length > Math.powExact(10, 4)) {
            System.out.println("Arrayet må minst ha ett element og kan ikke ha flere enn 10^4");
        }

        Map<Integer, Integer> set = new HashMap<>();

        // Setter hele nums [] inni hashmappet.
        for (int i : nums) {
            // Hvis i finnes hent verdien og pluss 1. Hvis ikke, bruk 0 og legg til 1.
            set.put(i, set.getOrDefault(i, 0) + 1);
        }

        // Lager en liste som skal holde par [frekvens, tall], dette gjør vi fordi vi
        // kan IKKE sortere et hashmap.
        List<int[]> arr = new ArrayList<>();
        // henter både nøkkel og verdien samtidlig fra hashmappet.
        for (Map.Entry<Integer, Integer> entry : set.entrySet()) {
            // legger til verdien og nøkkelen inn i arrayet. Legger til verdien først da vi
            // bruker første element for sortering senere.
            arr.add(new int[] { entry.getValue(), entry.getKey() });
        }
        // sorterer synkende etter frekvenser siden vi la in getValue først over.
        // -> betyr returner dette utrykket.
        // .sort metoden er en algotime som plukker ut 2 elementer fra lista og utfører
        // den vi sier den skal gjøre.
        arr.sort((a, b) -> b[0] - a[0]);

        // Vi vil ha de k mest frekvente tallene. Så hvis vi spør om de 2 mest frekvente
        // tallene så bør svaret være en array med 2 plasser.
        int[] res = new int[k];
        // Går gjennom de k første elementene i lista. Siden lista er sortert synkende
        // så får vi de mest frekvente.
        for (int i = 0; i < k; i++) {
            // legger til nøkkelen til de meste frekvente tallene
            res[i] = arr.get(i)[1];
        }
        return res; // svaret.
    }

    public static void main(String[] args) {
        int[] nums = { 7, 7 };
        int k = 1;
        TopKFrequentElements tkfe = new TopKFrequentElements();
        int[] liste = tkfe.topKFrequent(nums, k);
        System.out.println(Arrays.toString(liste));
    }
}

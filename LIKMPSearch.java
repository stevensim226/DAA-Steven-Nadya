import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Reference: Lu, X., 2019
 * Modified by Steven et al., 2021
 */
public class LIKMPSearch {
    public static Map<Character, LinkedList<Integer>> buildCharTable(String pattern, int m) {
        Map<Character, LinkedList<Integer>> charTable = new HashMap<>();
        int ptr = m - 1;

        while (ptr >= 0) {
            char charPtr = pattern.charAt(ptr);
            if (!charTable.containsKey(charPtr)) {
                charTable.put(charPtr, new LinkedList<Integer>());
            }
            charTable.get(charPtr).add(ptr);
            ptr--;
        }
        return charTable;
    }

    public static int likmpSearch(String pattern, String target, int m, int n, Map<Character, LinkedList<Integer>> charTable) {
        int p = 0;
        int t = 0;
        int jump = m;
        while (t < n) {
            while (p < m && pattern.charAt(p) == target.charAt(t)) {
                p++;
                t++;
            }
            if (p == m) {
                return t - m;
            }
            if (jump < n && charTable.containsKey(target.charAt(jump))) {
                for (int idx: charTable.get(target.charAt(jump))) {
                    int p2 = 0;
                    int t2 = jump - idx; // Get new target start check
                    if (t2 + m > n) {
                        continue; // Continue if t2 + pattern length exceeds target length
                    }
                    while (p2 < m && pattern.charAt(p2) == target.charAt(t2)) {
                        p2++;
                        t2++;
                    }
                    if (p2 == m) {
                        return t2 - m;
                    }
                }
            }
            p = 0;
            t = jump + 1;
            jump = t + m;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String target  = sc.nextLine();
        int m = pattern.length();
        int n = target.length();

        Map<Character, LinkedList<Integer>> charTable = buildCharTable(pattern, m);
        // charTable.entrySet().forEach(entry -> {
        //     System.out.println(entry.getKey() + " -> " + entry.getValue());
        // });
        long start = System.nanoTime();
        int result = likmpSearch(pattern, target, m, n, charTable);
        long finish = System.nanoTime();
        System.out.println(finish - start);
        System.out.println(result);
        
    }
}

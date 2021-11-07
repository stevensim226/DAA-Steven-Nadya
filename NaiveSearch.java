import java.util.Scanner;

/**
 * Reference: Sryheni, 2020
 * Modified by Steven et al., 2021
 */
public class NaiveSearch {
    public static int naiveSearch(String pattern,String target,int m,int n) {
        int t = 0;
        while (t <= n - m) {
            int p2 = 0;
            int t2 = t;
            while (p2 < m && pattern.charAt(p2) == target.charAt(t2)) {
                p2++;
                t2++;
            }
            if (p2 == m) {
                return t2 - m;
            }
            t++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String target  = sc.nextLine();
        int m = pattern.length();
        int n = target.length();

        // Naive search starts here
        long start = System.nanoTime();
        int result = naiveSearch(pattern, target, m, n);      
        long finish = System.nanoTime();
        System.out.println(finish - start);
        System.out.println(result);
    }
}
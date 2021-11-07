import java.util.Scanner;

/**
 * Reference: Sryheni, 2020 and GeeksForGeeks, 2021
 * Modified by Steven et al., 2021
 */
public class KMPSearch {
    public static void buildLPS(String pattern, int m, int[] lps_arr) {
        int a = 0;
        int b = 1;
        lps_arr[0] = 0;

        while (b < m) {
            if (pattern.charAt(a) == pattern.charAt(b)) {
                a++;
                lps_arr[b] = a;
                b++;
            } else {
                if (a == 0) {
                    lps_arr[b] = 0;
                    b++;
                } else {
                    a = lps_arr[a - 1];
                }
            }
        }
    }

    public static int kmpSearch(String pattern, String target, int m, int n, int[] lps_arr) {
        int p = 0;
        int t = 0;
        while (t <= n) {
            while (p > 0 && pattern.charAt(p) != target.charAt(t)) {
                p = lps_arr[p - 1];
            }

            if (pattern.charAt(p) == target.charAt(t)) {
                p++;
            }

            t++;

            if (p == m) {
                return t - m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String target  = sc.nextLine();
        int m = pattern.length();
        int n = target.length();
        int[] lps_arr = new int[m];

        // Naive search starts here
        long start = System.nanoTime();
        buildLPS(pattern, m, lps_arr);
        int result = kmpSearch(pattern, target, m, n, lps_arr);
        long finish = System.nanoTime();
        System.out.println(finish - start);
        System.out.println(result);
    }
}

import java.util.Arrays;

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
        String pattern = "abcaby";
        String target  = "abxabcabcaby";
        int m = pattern.length();
        int n = target.length();
        int[] lps_arr = new int[m];

        // Naive search starts here
        buildLPS(pattern, m, lps_arr);
        System.out.println(Arrays.toString(lps_arr));
        System.out.println(kmpSearch(pattern, target, m, n, lps_arr));
    }
}

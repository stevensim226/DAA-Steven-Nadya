import java.util.Arrays;

/**
 * Reference: Zhou, Y. et al., 2019
 * Modified by Aprillia, N. et al., 2021
 */
public class IKMPSearch {
    public static void buildNextval(String pattern, int m, int[] nextval) {
        int i = 1;
        int j = 0;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                nextval[i] = nextval[j];
            } else {
                nextval[i] = j;
            }
            i++;
            j++;
        }
    }

    public static int ikmpSearch(String pattern, String target, int m, int n, int[] nextval) {
        int p = 0;
        int t = 0;
        while (p < m && t < n) {
            if (pattern.charAt(p) == target.charAt(t)) {
                p++;
                t++;
            } else {
                if (p == 0) {
                    t++;
                } else {
                    p = nextval[p];
                }
            }
        }
        if (p == m) {
            return t - m;
        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern = "IMAIMO";
        String target  = "IMAIMAIMO";
        int m = pattern.length();
        int n = target.length();
        int[] nextval = new int[m];

        buildNextval(pattern, m, nextval);
        System.out.println(Arrays.toString(nextval));
        System.out.println(ikmpSearch(pattern, target, m, n, nextval));

    }
}

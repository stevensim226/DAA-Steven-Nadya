import java.util.Scanner;

/**
 * Reference: Zhou, Y. et al., 2019
 * Modified by Aprillia, N. et al., 2021
 */
public class IKMPSearchCounter {
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
            if (MatchingUtils.isEqual(pattern.charAt(p), target.charAt(t))) {
                //System.out.println("match at " + p + " " + t);
                //System.out.println(pattern.charAt(p) + " " + target.charAt(t));
                p++;
                t++;
            } else {
                //System.out.println("unmatch at " + p + " " + t);
                if (p == 0) {
                    t++;
                } else {
                    p = nextval[p];
                    //System.out.println("moving to " + p);
                }
            }
        }
        if (p == m) {
            return t - m;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String target  = sc.nextLine();
        int m = pattern.length();
        int n = target.length();
        int[] nextval = new int[m];

        buildNextval(pattern, m, nextval);
        int result = ikmpSearch(pattern, target, m, n, nextval);
        
        //System.out.println(result);
        System.out.println(MatchingUtils.getCounter());
    }
}

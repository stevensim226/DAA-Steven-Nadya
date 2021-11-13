
public class MatchingUtils {
    private static long counter = 0;

    public static boolean isEqual(char x, char y) {
        counter++;
        return x == y;
    }

    public static boolean isNotEqual(char x, char y) {
        counter++;
        return x != y;
    }

    public static long getCounter() {
        return counter;
    }
}

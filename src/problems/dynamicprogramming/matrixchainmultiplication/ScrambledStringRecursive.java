package problems.dynamicprogramming.matrixchainmultiplication;

public class ScrambledStringRecursive {
    public static void main(String args[]) {
        String s1 = "abcdem";
        String s2 = "baecdm";
        if (s1.length() != s2.length()) {
            System.out.println(false);
        } else if ("".equalsIgnoreCase(s1)) {
            System.out.println(true);
        } else {
            System.out.println(solve(s1, s2));
        }
    }

    private static boolean solve(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() <= 1) {
            return false;
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if(isSwapped(s1, s2, n, i) || isNotSwapped(s1, s2, i)){
                return true;
            }
        }
        return false;
    }

    private static boolean isNotSwapped(String s1, String s2, int i) {
        return solve(s1.substring(0, i),s2.substring(0, i)) && solve(s1.substring(i), s2.substring(i));
    }

    private static boolean isSwapped(String s1, String s2, int n, int i) {
        return solve(s1.substring(0, i),s2.substring(n-i,n)) && solve(s1.substring(i),s2.substring(0,n-i));
    }
}
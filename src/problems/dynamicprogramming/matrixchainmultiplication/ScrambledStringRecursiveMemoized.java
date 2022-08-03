package problems.dynamicprogramming.matrixchainmultiplication;

import java.util.HashMap;
import java.util.Map;

public class ScrambledStringRecursiveMemoized {
    public static void main(String args[]) {
        String s1 = "abcdem";
        String s2 = "baecdm";
        if (s1.length() != s2.length()) {
            System.out.println(false);
        } else if ("".equalsIgnoreCase(s1)) {
            System.out.println(true);
        } else {
            Map<String,Boolean> memo = new HashMap<>();
            System.out.println(solve(s1, s2,memo));
        }
    }

    private static boolean solve(String s1, String s2,Map<String,Boolean> memo) {
        String key =s1+"_"+s2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() <= 1) {
            return false;
        }
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            if(isSwapped(s1, s2, n, i,memo) || isNotSwapped(s1, s2, i,memo)){
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    private static boolean isNotSwapped(String s1, String s2, int i,Map<String,Boolean> memo) {
        return solve(s1.substring(0, i),s2.substring(0, i),memo) && solve(s1.substring(i), s2.substring(i),memo);
    }

    private static boolean isSwapped(String s1, String s2, int n, int i,Map<String,Boolean> memo) {
        return solve(s1.substring(0, i),s2.substring(n-i,n),memo) && solve(s1.substring(i),s2.substring(0,n-i),memo);
    }
}
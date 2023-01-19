package dynamicprogramming;
/*
 * Problem link :
 * https://leetcode.com/problems/edit-distance/
 *
 * Solution link :
 *
 *
 */

public class EditDistance {

    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // Bottom up approach
    private static void type3() {
        String word1 = "abc";
        String word2 = "efg";

        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) {
            System.out.println(n2);
            return;
        }
        if (n2 == 0) {
            System.out.println(n1);
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        // initialization
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = j;
        }

        // top down calculation
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n1][n2]);
    }

    // memoization approach
    private static void type2() {
        String word1 = "abc";
        String word2 = "efg";

        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) {
            System.out.println(n2);
            return;
        }
        if (n2 == 0) {
            System.out.println(n1);
        }
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // initialization
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = -1;
                }
            }
        }
        int editDistance = minDistance(w1, n1, w2, n2, dp);
        System.out.println(editDistance);
    }

    private static int minDistance(char[] word1, int n1, char[] word2, int n2, int[][] dp) {
        if (dp[n1][n2] == -1) {
            // if the current last characters are same then we dont have to consider that
            // character
            if (word1[n1 - 1] == word2[n2 - 1]) {
                dp[n1][n2] = minDistance(word1, n1 - 1, word2, n2 - 1, dp);
            } else {
                // if that is not same
                // the we have 3 options

                // to replace the last character and search again, that cost 1 operation
                int replacedLastChar = minDistance(word1, n1 - 1, word2, n2 - 1, dp);
                // to remove the last character from first string and search again, that cost 1
                int deleteLastCharacterFromFirstString = minDistance(word1, n1, word2, n2 - 1, dp);
                // to remove the last character from second string and search again, that cost 1
                int deleteLastCharacterFromSecondString = minDistance(word1, n1 - 1, word2, n2, dp);
                // ans would be minimum from these 3 choices
                dp[n1][n2] = 1 + min(replacedLastChar, deleteLastCharacterFromFirstString,
                        deleteLastCharacterFromSecondString);
            }
        }
        return dp[n1][n2];
    }

    private static void type1() {
        String word1 = "abc";
        String word2 = "efg";
        char[] w1 = word1.toCharArray();
        int n1 = w1.length;
        char[] w2 = word2.toCharArray();
        int n2 = word2.length();
        int editDistance = minDistance(w1, n1, w2, n2);
        System.out.println(editDistance);
    }

    private static int minDistance(char[] word1, int n1, char[] word2, int n2) {
        if (n1 == 0 || n2 == 0) {
            return n1 == 0 ? n2 : n1;
        } else if (word1[n1 - 1] == word2[n2 - 1]) {
            return minDistance(word1, n1 - 1, word2, n2 - 1);
        } else {
            int replacedLastChar = minDistance(word1, n1 - 1, word2, n2 - 1);
            int deleteLastCharacterFromFirstString = minDistance(word1, n1, word2, n2 - 1);
            int deleteLastCharacterFromSecondString = minDistance(word1, n1 - 1, word2, n2);
            return 1 + min(replacedLastChar, deleteLastCharacterFromFirstString, deleteLastCharacterFromSecondString);
        }
    }

    private static int min(int num, int... nums) {
        for (int item : nums) {
            num = num > item ? item : num;
        }
        return num;
    }
}

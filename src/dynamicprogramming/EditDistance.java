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

    // Bottom-up approach
    private static void type3() {
        String word1 = "abc";
        String word2 = "efg";

        int editDistance = editDistance3(word1, word2);
        System.out.println(editDistance);
    }

    private static int editDistance3(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) return n2;
        if (n2 == 0) return n1;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // initialization
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) dp[i][0] = i;
        for (int j = 1; j <= n2; j++) dp[0][j] = j;
        // top-down calculation
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    // memoization approach
    private static void type2() {
        String word1 = "abc";
        String word2 = "efg";


        int editDistance = editDistance2(word1, word2);
        System.out.println(editDistance);
    }

    private static int editDistance2(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) return n2;
        if (n2 == 0) return n1;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // initialization
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                // for initialization, we have three cases, if i=0 then it will be j and vise versa
                // for others we will initialize it to -1
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else dp[i][j] = -1;
            }
        }
        return minDistance(w1, n1, w2, n2, dp);
    }

    private static int minDistance(char[] word1, int n1, char[] word2, int n2, int[][] dp) {
        if (dp[n1][n2] != -1) return dp[n1][n2];
        // if the current last characters are same, then we don't have to consider that character
        if (word1[n1 - 1] == word2[n2 - 1])
            dp[n1][n2] = minDistance(word1, n1 - 1, word2, n2 - 1, dp);

        // if that is different, then we have 3 options
        // to replace the last character and search again; that cost 1 operation
        int changeLastChar = minDistance(word1, n1 - 1, word2, n2 - 1, dp);
        // to remove the last character from the first string and search again, that cost 1
        int deleteLastChar1 = minDistance(word1, n1 - 1, word2, n2, dp);
        // to remove the last character from the second string and search again, that cost 1
        int deleteLastChar2 = minDistance(word1, n1, word2, n2 - 1, dp);

        // and would be minimum from these 3 choices
        return dp[n1][n2] = 1 + min(changeLastChar, deleteLastChar2, deleteLastChar1);
    }

    private static void type1() {
        String word1 = "abc";
        String word2 = "efg";

        int editDistance = editDistance1(word1, word2);
        System.out.println(editDistance);
    }

    private static int editDistance1(String word1, String word2) {
        return minDistance(word1.toCharArray(), word1.length(), word2.toCharArray(), word2.length());
    }

    private static int minDistance(char[] word1, int n1, char[] word2, int n2) {
        // if n1 or n2 is at 0, means one of the strings is exhausted completely,
        // then we will return the remaining length of the other string
        if (n1 == 0 || n2 == 0) return n1 == 0 ? n2 : n1;
        // if the character is same then we will directly check for the 1-character small string
        if (word1[n1 - 1] == word2[n2 - 1]) return minDistance(word1, n1 - 1, word2, n2 - 1);
        // else we have three cases, 1. replace last character for both of the strings
        int changeLastChar = minDistance(word1, n1 - 1, word2, n2 - 1);
        // remove the last character from the first word
        int deleteLastChar1 = minDistance(word1, n1 - 1, word2, n2);
        // remove the last character from the second word
        int deleteLastChar2 = minDistance(word1, n1, word2, n2 - 1);
        // we will return the min of them and plus 1 for the one operation we did here
        return 1 + min(changeLastChar, deleteLastChar2, deleteLastChar1);
    }

    private static int min(int num, int... nums) {
        for (int item : nums) num = Math.min(num, item);
        return num;
    }
}

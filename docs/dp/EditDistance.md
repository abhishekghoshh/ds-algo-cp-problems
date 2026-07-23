# EditDistance

**Topic:** `dp`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/edit-distance/description/)
- [📄 NeetCode](https://neetcode.io/problems/edit-distance)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/edit-distance_630420)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/shortest-common-supersequence_4244493)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=fJaKO8FbDdo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=35)
- [▶ YouTube](https://www.youtube.com/watch?v=XYi2-LPrwm4)
- [📄 takeUforward](https://takeuforward.org/data-structure/edit-distance-dp-33/)

## 📝 Problem Statement

Given two strings word1 and word2, return the minimum number of operations (insert, delete, replace) required to convert word1 to word2.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

tabulation with space optimization. same as previous with some space optimization. we will only use two arrays for storing current and previous row Initialize the first row with their respective indices here the first string length is 0, so edit distance will be the length of the second string if both characters are same, then edit distance will be same as (i-1,j-1) If the characters don't match, take the minimum of three possibilities: 1.

Replace the character in S1 with the character in S2 (diagonal). 2. Delete the character in S1 (left). 3. Insert the character from S2 into S1 (up). assigning the curr array to prev

```java
    private static void type4() {
        String word1 = "abc";
        String word2 = "efg";

        int editDistance = editDistance4(word1, word2);
        System.out.println(editDistance);
    }

    private static int editDistance4(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) return n2;
        if (n2 == 0) return n1;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // initialization
        int[] prev = new int[n2 + 1];
        // Initialize the first row with their respective indices
        // here the first string length is 0, so edit distance will be the length of the second string
        for (int j = 1; j <= n2; j++) prev[j] = j;
        // top-down calculation
        for (int i = 1; i <= n1; i++) {
            int[] curr = new int[n2 + 1];
            curr[0] = i;
            for (int j = 1; j <= n2; j++) {
                // if both characters are same, then edit distance will be same as (i-1,j-1)
                if (w1[i - 1] == w2[j - 1]) {
                    curr[j] = prev[j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in S1 with the character in S2 (diagonal).
                    // 2. Delete the character in S1 (left).
                    // 3. Insert the character from S2 into S1 (up).
                    curr[j] = 1 + min(
                            prev[j - 1],
                            prev[j],
                            curr[j - 1]
                    );
                }
            }
            // assigning the curr array to prev
            prev = curr;
        }
        return prev[n2];
    }
```

### Approach 3

iterative approach with tabulation Bottom-up approach here the second string length is 0, so edit distance will be the length of the first string here the first string length is 0, so edit distance will be the length of the second string if both characters are same, then edit distance will be same as (i-1,j-1) If the characters don't match, take the minimum of three possibilities: 1.

Replace the character in S1 with the character in S2 (diagonal). 2. Delete the character in S1 (left). 3. Insert the character from S2 into S1 (up).

```java
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
        // here the second string length is 0, so edit distance will be the length of the first string
        for (int i = 1; i <= n1; i++) dp[i][0] = i;
        // here the first string length is 0, so edit distance will be the length of the second string
        for (int j = 1; j <= n2; j++) dp[0][j] = j;

        // top-down calculation
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // if both characters are same, then edit distance will be same as (i-1,j-1)
                if (w1[i - 1] == w2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters don't match, take the minimum of three possibilities:
                    // 1. Replace the character in S1 with the character in S2 (diagonal).
                    // 2. Delete the character in S1 (left).
                    // 3. Insert the character from S2 into S1 (up).
                    dp[i][j] = 1 + min(
                            dp[i - 1][j - 1],
                            dp[i - 1][j],
                            dp[i][j - 1]
                    );
                }
            }
        }
        return dp[n1][n2];
    }
```

### Approach 2

memoization approach recursion with memoization if n1 or n2 is at 0, means one of the strings is exhausted completely, then we will return the remaining length of the other string if the current last characters are same, then we don't have to consider that character if that is different, then we have 3 options to replace the last character and search again; that cost 1 operation to remove the last character from the first string and search again, that cost 1 to remove the last character from the second string and search again, that cost 1 and would be minimum from these 3 choices

```java
    private static void type2() {
        String word1 = "abc";
        String word2 = "efg";


        int editDistance = editDistance2(word1, word2);
        System.out.println(editDistance);
    }

    // recursion with memoization
    // bottom-up approach
    private static int editDistance2(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        if (n1 == 0) return n2;
        if (n2 == 0) return n1;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        // initialization
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return minDistance(n1, n2, w2, w1, dp);
    }

    private static int minDistance(int n1, int n2, char[] word2, char[] word1, int[][] dp) {
        // if n1 or n2 is at 0, means one of the strings is exhausted completely,
        // then we will return the remaining length of the other string
        if (n1 == 0 || n2 == 0) return (n1 == 0) ? n2 : n1;

        if (dp[n1][n2] != -1) return dp[n1][n2];
        // if the current last characters are same, then we don't have to consider that character
        if (word1[n1 - 1] == word2[n2 - 1])
            return dp[n1][n2] = minDistance(n1 - 1, n2 - 1, word2, word1, dp);

        // if that is different, then we have 3 options
        // to replace the last character and search again; that cost 1 operation
        int d1 = minDistance(n1 - 1, n2 - 1, word2, word1, dp);
        // to remove the last character from the first string and search again, that cost 1
        int d2 = minDistance(n1 - 1, n2, word2, word1, dp);
        // to remove the last character from the second string and search again, that cost 1
        int d3 = minDistance(n1, n2 - 1, word2, word1, dp);

        // and would be minimum from these 3 choices
        return dp[n1][n2] = 1 + min(d1, d3, d2);
    }
```

### Approach 1: 🔨 Brute Force

recursion and brute force approach we will construct the recurrence relation if the character is same then we will check for editDistance1(n1-1, n2-1) else we have 3 options either remove char from 1st string or from 2nd string or replace last char of the string if the n1 is 0 then the edit distance will be n2 or n2 is 0 then the edit distance will be n1 if n1 or n2 is at 0, means one of the strings is exhausted completely, then we will return the remaining length of the other string if the character is same then we will directly check for the 1-character small string else we have three cases, 1.

replace last character for both of the strings remove the last character from the first word remove the last character from the second word we will return the min of them and plus 1 for the one operation we did here

```java
    private static void type1() {
        String word1 = "abc";
        String word2 = "efg";

        int editDistance = editDistance1(word1, word2);
        System.out.println(editDistance);
    }

    private static int editDistance1(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        // if the n1 is 0 then the edit distance will be n2 or n2 is 0 then the edit distance will be n1
        if (n1 == 0 || n2 == 0) return (n1 == 0) ? n2 : n1;
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        return minDistance(n1, n2, w1, w2);
    }

    private static int minDistance(int n1, int n2, char[] word2, char[] word1) {
        // if n1 or n2 is at 0, means one of the strings is exhausted completely,
        // then we will return the remaining length of the other string
        if (n1 == 0 || n2 == 0) return (n1 == 0) ? n2 : n1;
        // if the character is same then we will directly check for the 1-character small string
        if (word1[n1 - 1] == word2[n2 - 1]) return minDistance(n1 - 1, n2 - 1, word2, word1);
        // else we have three cases, 1. replace last character for both of the strings
        int ch1 = minDistance(n1 - 1, n2 - 1, word2, word1);
        // remove the last character from the first word
        int ch2 = minDistance(n1 - 1, n2, word2, word1);
        // remove the last character from the second word
        int ch3 = minDistance(n1, n2 - 1, word2, word1);
        // we will return the min of them and plus 1 for the one operation we did here
        return 1 + min(ch1, ch3, ch2);
    }

    private static int min(int num, int... nums) {
        for (int item : nums) num = Math.min(num, item);
        return num;
    }
}
```

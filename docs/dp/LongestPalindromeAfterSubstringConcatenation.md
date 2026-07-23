# LongestPalindromeAfterSubstringConcatenation

**Topic:** `dp` | **File:** `com/problems/dp/LongestPalindromeAfterSubstringConcatenation.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-palindrome-after-substring-concatenation-i/description/)
- [📄 LeetCode](https://leetcode.com/problems/longest-palindrome-after-substring-concatenation-ii/description/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Little optimized from the previous approach in the last approach, we were recalculating the length of the palindrome to last from (i) everytime but here we have calculated and stored while we are calculating the longest palindrome now we will use that while we are calculating the longest common substring

```java
private static void type3() {
        String s = "axchh";
        String t = "semjc";
        int result = longestPalindrome3(s, t);
        System.out.println(result);
    }
    private static int longestPalindrome3(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = reverse(t.toCharArray());

        Object[] result1 = longestPalindromeToLast(arr1);
        Object[] result2 = longestPalindromeToLast(arr2);

        int[] palToLast1Arr = (int[]) result1[1];
        int[] palToLast2Arr = (int[]) result2[1];

        int max = Math.max((int) result1[0], (int) result2[0]);
        int n1 = arr1.length, n2 = arr2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    // we will check from string(i+1) what is maximum palindrome can be possible
                    int palToLast1 = (i != n1) ? palToLast1Arr[i] : 0;
                    int palToLast2 = (j != n2) ? palToLast2Arr[j] : 0;
                    int palToLast = Math.max(palToLast1, palToLast2);
                    // max(2 * substring length + max palindrome string from the remaining string1 or string2)
                    max = Math.max(max, 2 * dp[i][j] + palToLast);
                }
            }
        }
        return max;
    }
```

### Approach 2

It will return the longest palindrome length and the last index of the palindrome this is dp array to store the max length of the palindrome possible from (i) all the elements are initialized to 1 as a single length palindrome is possible palindrome is from (l+1) to (r-1), so the length is ((r-1) - (l+1) + 1) => r - l - 1; if l is the last element, then we can ignore it, else we will recompute the max length of the palindrome possible from (i) todo optimized approach from the previous collecting all the learnings from the previous problems so the concatenation 2 strings need to be palindrome which means if we reverse the 2nd string the problem will become somewhat like (Longest common substring) + (Longest palindrome starting from end1 or end2) so we can create a dp array for both the strings and can find if (i, j) is palindrome or not we will have the dp array for both the strings then we will calculate the longest common substring between the 2 strings once we find the common substring we will check from string(i+1) what is maximum palindrome can be possible similarly for the other string we will compute and take the max so the ans would be max(2 * substring length + max palindrome string from the remaining string1 or string2)

```java
private static void type2() {
        String s = "abcde";
        String t = "ecdba";
        int result = longestPalindrome2(s, t);
        System.out.println(result);
    }
    public static int longestPalindrome2(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = reverse(t.toCharArray());

        Object[] result1 = longestPalindrome(arr1);
        Object[] result2 = longestPalindrome(arr2);
        int[][] pal1 = (int[][]) result1[1];
        int[][] pal2 = (int[][]) result2[1];

        int max = Math.max((int) result1[0], (int) result2[0]);
        int n1 = arr1.length, n2 = arr2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    // we will check from string(i+1) what is maximum palindrome can be possible
                    int palToLast1 = palindromeFromRemainingString(i, pal1);
                    int palToLast2 = palindromeFromRemainingString(j, pal2);
                    int palToLast = Math.max(palToLast1, palToLast2);
                    // max(2 * substring length + max palindrome string from the remaining string1 or string2)
                    max = Math.max(max, 2 * dp[i][j] + palToLast);
                }
            }
        }
        return max;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```

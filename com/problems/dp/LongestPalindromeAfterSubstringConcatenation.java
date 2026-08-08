package com.problems.dp;

import java.util.Arrays;
/*
 * Problem link :
 * https://leetcode.com/problems/longest-palindrome-after-substring-concatenation-i/description/
 * https://leetcode.com/problems/longest-palindrome-after-substring-concatenation-ii/description/
 *
 * Solution link :
 *
 */


public class LongestPalindromeAfterSubstringConcatenation {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // todo little optimized from the previous approach
    //  in the last approach, we were recalculating the length of the palindrome to last from (i) everytime
    //  but here we have calculated and stored while we are calculating the longest palindrome
    //  now we will use that while we are calculating the longest common substring
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

    // it will return the longest palindrome length and the last index of the palindrome
    static Object[] longestPalindromeToLast(char[] arr) {
        int n = arr.length;
        // this is dp array to store the max length of the palindrome possible from (i)
        int[] palToLast = new int[n];
        // all the elements are initialized to 1 as a single length palindrome is possible
        Arrays.fill(palToLast, 1);
        int max = 1;
        for (int i = n - 1; i >= 0; i--) {
            int len1 = expand(i, i, arr, palToLast);
            int len2 = expand(i, i + 1, arr, palToLast);
            max = Math.max(max, Math.max(len1, len2));
        }
        return new Object[]{max, palToLast};
    }

    static int expand(int l, int r, char[] arr, int[] palToLast) {
        int n = arr.length;
        while (l >= 0 && r < n && arr[l] == arr[r]) {
            l--;
            r++;
        }
        // palindrome is from (l+1) to (r-1), so the length is ((r-1) - (l+1) + 1) => r - l - 1;
        int len = r - l - 1;
        // if l is the last element, then we can ignore it,
        // else we will recompute the max length of the palindrome possible from (i)
        if (l != n - 1)
            palToLast[l + 1] = Math.max(palToLast[l + 1], len);
        return len;
    }

    // todo optimized approach from the previous
    //  collecting all the learnings from the previous problems
    //  so the concatenation 2 strings need to be palindrome which means if we reverse the 2nd string
    //  the problem will become somewhat like (Longest common substring) + (Longest palindrome starting from end1 or end2)
    //  so we can create a dp array for both the strings and can find if (i, j) is palindrome or not
    //  we will have the dp array for both the strings
    //  then we will calculate the longest common substring between the 2 strings
    //  once we find the common substring we will check from string(i+1) what is maximum palindrome can be possible
    //  similarly for the other string we will compute and take the max
    //  so the ans would be max(2 * substring length + max palindrome string from the remaining string1 or string2)
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


    static int palindromeFromRemainingString(int start, int[][] pal) {
        int n = pal.length;
        if (start == n) return 0;
        for (int i = n - 1; i > start; i--) {
            if (pal[start][i] != 0) return pal[start][i];
        }
        return 1;
    }

    static Object[] longestPalindrome(char[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int max = 1;
        for (int i = 0; i < n; i++) dp[i][i] = 1;
        for (int i = 0; i + 1 < n; i++) {
            dp[i][i + 1] = (arr[i] == arr[i + 1]) ? 2 : 0;
            max = Math.max(max, dp[i][i + 1]);
        }
        for (int d = 3; d <= n; d++) {
            for (int i = 0; i + d <= n; i++) {
                int end = i + d - 1;
                if (arr[i] == arr[end] && dp[i + 1][end - 1] != 0) {
                    dp[i][end] = 2 + dp[i + 1][end - 1];
                    max = Math.max(max, dp[i][end]);
                }
            }
        }
        return new Object[]{max, dp};
    }


    static char[] reverse(char[] arr) {
        int n = arr.length;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            char c1 = arr[i], c2 = arr[j];
            arr[i] = c2;
            arr[j] = c1;
        }
        return arr;
    }

    // brute force approach
    private static void type1() {

    }
}
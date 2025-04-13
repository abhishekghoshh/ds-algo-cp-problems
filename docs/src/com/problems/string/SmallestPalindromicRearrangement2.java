package com.problems.string;

/*
 * Problem link :
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-ii
 *
 * Solution link :
 *
 */
public class SmallestPalindromicRearrangement2 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
    }

    private static void type1() {
        String s = "bacab";
        int k = 1;
        String ans = smallestPalindrome1(s, k);
        System.out.println(ans);
    }

    public static String smallestPalindrome1(String s, int k) {
        long f = 1;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for (char ch : arr) {
            freq[ch - 'a']++;
        }

        return null;
    }
}

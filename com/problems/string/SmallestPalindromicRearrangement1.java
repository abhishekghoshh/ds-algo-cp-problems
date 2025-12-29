package com.problems.string;

/*
 * Problem link :
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-i
 * Solution link :
 *
 */
public class SmallestPalindromicRearrangement1 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
    }

    private static void type1() {
        String s = "daccad";
        String ans = smallestPalindrome1(s);
        System.out.println(ans);
    }

    public static String smallestPalindrome1(String s) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        for (char ch : arr) {
            freq[ch - 'a']++;
        }
        StringBuilder front = new StringBuilder();
        char mid = '-';
        for (int p = 0; p < 26; p++) {
            int f = freq[p];
            char ch = (char) ('a' + p);
            if (f == 0) continue;
            int h = f / 2;
            for (int i = 0; i < h; i++) {
                front.append(ch);
            }
            if (f % 2 == 1) mid = ch;
        }
        String rev = new StringBuilder(front).reverse().toString();
        if (mid != '-') front.append(mid);
        front.append(rev);
        return front.toString();
    }
}

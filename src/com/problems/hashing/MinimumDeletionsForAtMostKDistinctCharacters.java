package com.problems.hashing;

/*
 * Problem links:
 * https://leetcode.com/problems/minimum-deletions-for-at-most-k-distinct-characters/description/
 *
 * Solution link
 *
 * */

import java.util.Arrays;

public class MinimumDeletionsForAtMostKDistinctCharacters {
    public static void main(String[] args) {
        type1();
    }

    // very simple hashing problem
    private static void type1() {
        String s = "yyyzz";
        int k = 1;
        int ans = minDeletion1(s, k);
        System.out.println(ans);
    }

    public static int minDeletion1(String s, int k) {
        int[] freq = new int[26];
        int f = 0;
        for (char ch : s.toCharArray()) {
            if (freq[ch - 'a'] == 0) f++;
            freq[ch - 'a']++;
        }
        if (f <= k) return 0;
        Arrays.sort(freq);
        int count = 0;
        for (int fc : freq) {
            if (fc == 0) continue;
            count += fc;
            f--;
            if (f == k) return count;
        }
        return count;
    }

}

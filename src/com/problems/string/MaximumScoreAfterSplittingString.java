package com.problems.string;

/*
 *
 * problem links :
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=mc_eSStDrWw
 *
 * https://neetcode.io/solutions/maximum-score-after-splitting-a-string
 * */
public class MaximumScoreAfterSplittingString {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // optimized approach
    // we will calculate the ones in one iteration
    private static void type2() {
        String s = "011101";
        int ans = maxScore2(s);
        System.out.println(ans);
    }

    public static int maxScore2(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int max = 0;
        int ones = 0;
        for (char ch : arr) {
            if (ch == '1') ones++;
        }
        int left = 0, right = ones;
        for (int i = 0; i < n - 1; i++) {
            int bit = arr[i] - '0';
            if (bit == 0) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, (left + right));
        }
        return max;
    }

    // brute force approach
    // we will use a pointer and calculate left 0s and right 1s individually
    private static void type1() {
        String s = "011101";
        int ans = maxScore1(s);
        System.out.println(ans);
    }

    public static int maxScore1(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int max = 0;

        return max;
    }
}

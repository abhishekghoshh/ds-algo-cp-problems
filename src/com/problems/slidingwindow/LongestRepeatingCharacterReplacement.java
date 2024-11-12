package com.problems.slidingwindow;

/*
 *
 * problem links :
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * https://neetcode.io/problems/longest-repeating-substring-with-replacement
 * https://www.naukri.com/code360/problems/longest-repeating-substring_980523
 *
 * Solution link :
 * https://www.youtube.com/watch?v=_eNhaDCr6P0
 *
 *
 *
 * Tags :
 * Sliding-Window
 * */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // todo check again
    private static void type3() {
        String s = "BAAAB";
        int k = 2;
        int max = characterReplacement3(s, k);
        System.out.println(max);

    }

    private static int characterReplacement3(String s, int k) {
        int max = 0;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        int left = 0, right = 0;
        int n = arr.length;
        int curentMaxFrequency = 0;
        while (right < n) {
            int rightCh = arr[right++] - 'A';
            freq[rightCh]++;
            // Get the largest count of a single, unique character in the current window...
            curentMaxFrequency = Math.max(curentMaxFrequency, freq[rightCh]);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k characters. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            while ((right - left + 1) - curentMaxFrequency > k) {
                int leftCh = arr[left++] - 'A';
                freq[leftCh]--;
            }
            // Get the maximum length of repeating character..
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    private static void type2() {
    }

    private static void type1() {
    }
}

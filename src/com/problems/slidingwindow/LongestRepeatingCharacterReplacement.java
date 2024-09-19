package com.problems.slidingwindow;

/*
 *
 * problem links :
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 * https://www.codingninjas.com/studio/problems/longest-repeating-substring_980523
 *
 * Solution link :
 * https://www.youtube.com/watch?v=_eNhaDCr6P0
 *
 * */
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        String s = "BAAAB";
        int k = 2;
        int max = 0;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        int left = 0;
        int curentMaxFrequency = 1;
        for (int right = 0; right < arr.length; right++) {
            freq[arr[right] - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            curentMaxFrequency = Math.max(curentMaxFrequency, freq[arr[right] - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k characters. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            while ((right - left + 1) - curentMaxFrequency > k) {
                freq[arr[left] - 'A']--;
                left++;
            }
            // Get the maximum length of repeating character..
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);

    }

    private static void type2() {
    }

    private static void type1() {
    }
}

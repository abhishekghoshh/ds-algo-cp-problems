package com.ds.extra;

/*
 *
 * problem links :
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * Solution link :
 *
 * Tags :
 * Hash Table, String, Sliding Window, Array
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
        int answer = characterReplacement(s, k);
        System.out.println(answer);

    }

    public static int characterReplacement(String s, int k) {
        int maxLength = 0;
        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        int left = 0;
        int maxFrequency = 1;
        for (int right = 0; right < arr.length; right++) {
            freq[arr[right] - 'A']++;
            // Get the largest count of a single, unique character in the current window...
            maxFrequency = Math.max(maxFrequency, freq[arr[right] - 'A']);
            // We are allowed to have at most k replacements in the window...
            // So, if max character frequency + distance between beg and end is greater than k...
            // this means we have considered changing more than k characters. So time to shrink window...
            // Then there are more characters in the window than we can replace, and we need to shrink the window...
            while ((right - left + 1) - maxFrequency > k) {
                freq[arr[left] - 'A']--;
                left++;
            }
            // Get the maximum length of repeating character..
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


    private static void type2() {
    }

    private static void type1() {
    }
}

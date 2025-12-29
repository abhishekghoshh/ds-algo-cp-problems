package com.problems.string;
/*
 * Problem links:
 * https://leetcode.com/problems/resulting-string-after-adjacent-removals/description/
 *
 * Solution link
 *
 * */

// Tags: String, Stack, Greedy
public class ResultingStringAfterAdjacentRemovals {
    public static void main(String[] args) {
        type1();
    }


    // this is a very optimized approach using stack,
    // but here we are using string builder as stack and return the final string
    private static void type1() {
        String s = "bcda";
        String ans = resultingString(s);
        System.out.println(ans);
    }

    public static String resultingString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (sb.isEmpty()) {
                sb.append(ch);
                continue;
            }
            if (isConsecutive(sb.charAt(sb.length() - 1), ch)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    static boolean isConsecutive(char x, char y) {
        if (x == 'a' && y == 'z') return true;
        if (x == 'z' && y == 'a') return true;
        int x1 = x - 'a';
        int y1 = y - 'a';
        return (x1 - y1 == 1) || (y1 - x1 == 1);
    }
}
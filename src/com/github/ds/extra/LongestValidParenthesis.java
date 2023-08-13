package com.github.ds.extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *
 * problem links :
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Solution link :
 *
 *
 *
 * */
public class LongestValidParenthesis {
    public static void main(String[] args) {
        type1();
        type2();
    }


    private static void type2() {
        String s = ")(((((()())()()))()(()))(";
        char[] chArr = s.toCharArray();
        int n = chArr.length;
        int left = 0, right = 1;
        int[] leftMemo = new int[n];
        Arrays.fill(leftMemo, -1);
        int maxLen = 0;
        while (right < n) {
            if (chArr[left] == '(' && chArr[right] == ')') {
                while (left >= 0 && right < n) {
                    if (left > 0 && leftMemo[left - 1] != -1) {
                        left = leftMemo[left - 1];
                    } else if (right + 2 < n && chArr[right + 1] == '(' && chArr[right + 2] == ')') {
                        right += 2;
                    } else if (left >= 1 && right + 1 < n && chArr[left - 1] == '(' && chArr[right + 1] == ')') {
                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
                leftMemo[right] = left;
                maxLen = Math.max(maxLen, right - left + 1);
                left = right + 1;
                right = right + 2;
            } else {
                left++;
                right++;
            }
        }
        System.out.println(maxLen);
    }

    // Using recursion
    private static void type1() {

    }
}

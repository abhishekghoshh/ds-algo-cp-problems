package com.problems.stack;

import java.util.Stack;
/*
 *
 * problem links :
 * https://leetcode.com/problems/make-the-string-great/description/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=10tBWNjzvtw
 *
 * https://neetcode.io/solutions/make-the-string-great
 * */

// Tags : Array, Stack
public class MakeTheStringGreat {
    public static void main(String[] args) {
        type1();
        type2();
    }

    static int diff = 'a' - 'A';

    private static void type2() {
    }

    // brute force using stack
    // we could use an array as stack
    private static void type1() {
        String s = "leEeetcode";
        String ans = makeGood1(s);
        System.out.println(ans);
    }


    public static String makeGood1(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (char ch : arr) {
            if (!st.isEmpty() && Math.abs(st.peek() - ch) == diff)
                st.pop();
            else
                st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());
        sb.reverse();
        return sb.toString();
    }
}

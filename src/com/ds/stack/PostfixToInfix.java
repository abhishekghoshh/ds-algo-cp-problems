package com.ds.stack;

import java.util.Stack;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/prefix-to-infix_1215000
 *
 * Solution link :
 * https://www.youtube.com/watch?v=m7SGekhd1mQ
 *
 * https://takeuforward.org/data-structure/infix-to-postfix/
 * */
public class PostfixToInfix {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        String postfix = "ab+c+";
        char[] arr = postfix.toCharArray();
        Stack<StringBuilder> stack = new Stack<>();
        for (char ch : arr) {
            if (Character.isLetterOrDigit(ch)) {
                stack.push(new StringBuilder().append(ch));
            } else {
                StringBuilder second = stack.pop();
                StringBuilder first = stack.pop();
                StringBuilder res = new StringBuilder()
                        .append('(')
                        .append(first)
                        .append(ch)
                        .append(second)
                        .append(')');
                stack.push(res);
            }
        }
        StringBuilder answer = stack.pop();
        System.out.println(answer);
    }
}

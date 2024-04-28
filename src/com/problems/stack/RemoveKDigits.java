package com.problems.stack;

import java.util.Stack;
/*
 * Problem link :
 * https://leetcode.com/problems/remove-k-digits/
 * https://www.codingninjas.com/studio/problems/remove-k-digits_1461221
 *
 * Solution link :
 * https://www.youtube.com/watch?v=cFabMOnJaq0
 * https://www.youtube.com/watch?v=3QJzHqNAEXs
 *
 * */
public class RemoveKDigits {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // same as type2
    // just optimized
    private static void type3() {
        String num = "1432219";
        int k = 3;
        char[] arr = num.toCharArray();
        int n = arr.length;
//        if (n <= k) return "0";
        int count = n - k;
        char[] stack = new char[n];
        int top = -1;
        for (char ch : arr) {
            while (k > 0 && top != -1 && stack[top] > ch) {
                k--;
                top--;
            }
            stack[++top] = ch;
        }
        int start = 0;
        // skip the leading 0
        while (start < count && stack[start] == '0') start++;
        // as the stack is now basically a char array
        // so we can create the String directly from that array
        String answer = String.valueOf(stack, start, count - start);
        answer = answer.isEmpty() ? "0" : answer;
        System.out.println(answer);
    }

    // optimized solution using stack
    // we certainly know one thing
    // if the integers are 2 5 4 5 9 1
    // then the lowest number can be possible with these
    // integers, is 123559
    // the lowest number will be monotonically increasing,
    // so we go from left to right and try to
    // maintain stack of monotonic increasing
    // if the number is 254591
    // and we need to choose between first 5 or first 4
    // then we will certainly choose the 5 to exclude
    // because no matter what will be the remaining number
    // if we exclude 5 it will be 24 and if we exclude 4 it will be 25
    // we go from left to right and maintain a monotonic stack
    private static void type2() {
        String num = "1432219";
        int k = 3;
        char[] arr = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : arr) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > ch) {
                k--;
                stack.pop();
            }
            stack.push(ch);
        }
        // if there is any remaining k then we will remove from the last
        // because we know that it is a monotonic increasing array
        // and the highest item will be in the end
        while (k > 0 && !stack.isEmpty()) {
            k--;
            stack.pop();
        }
        // now our work is to build the number from stack
        // either we can create an array and then convert that into string or
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        while (!sb.isEmpty() && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);
        String answer = sb.isEmpty() ? "0" : sb.reverse().toString();
        System.out.println(answer);
    }

    // brute force approach
    // find all the combinations possibles for the string
    // excluding k characters
    private static void type1() {

    }
}

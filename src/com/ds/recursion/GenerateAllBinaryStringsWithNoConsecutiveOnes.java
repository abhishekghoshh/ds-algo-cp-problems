package com.ds.recursion;

import java.util.LinkedList;
import java.util.List;

/*
 * Problem link :
 * https://www.codingninjas.com/studio/problems/-binary-strings-with-no-consecutive-1s._893001
 *
 * Solution link :
 *
 * */
public class GenerateAllBinaryStringsWithNoConsecutiveOnes {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        int n = 3;
        List<String> answer = new LinkedList<>();
        generateString3(n, new StringBuilder(), answer, '-');
        System.out.println(answer);
    }

    public static void generateString3(int n, StringBuilder sb, List<String> answer, char last) {
        if (n == 0) {
            answer.add(sb.toString());
            return;
        }
        sb.append('0');
        generateString3(n - 1, sb, answer, '0');
        sb.deleteCharAt(sb.length() - 1);

        if (last != '1') {
            sb.append('1');
            generateString3(n - 1, sb, answer, '1');
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void type2() {
        int n = 3;
        List<String> answer = new LinkedList<>();
        generateString2(n, new StringBuilder(), answer);
        System.out.println(answer);
    }

    public static void generateString2(int n, StringBuilder sb, List<String> answer) {
        if (n == 0) {
            answer.add(sb.toString());
            return;
        }
        sb.append('0');
        generateString2(n - 1, sb, answer);
        sb.deleteCharAt(sb.length() - 1);

        if (sb.isEmpty() || sb.charAt(sb.length() - 1) == '0') {
            sb.append('1');
            generateString2(n - 1, sb, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    // using recursion
    private static void type1() {
        int n = 3;
        List<String> answer = new LinkedList<>();
        generateString1(n, new StringBuilder(), answer);
        System.out.println(answer);
    }

    public static void generateString1(int n, StringBuilder sb, List<String> answer) {
        if (n == 0) {
            answer.add(sb.toString());
            return;
        }
        if (sb.isEmpty() || sb.charAt(sb.length() - 1) == '0') {
            sb.append('0');
            generateString1(n - 1, sb, answer);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('1');
            generateString1(n - 1, sb, answer);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append('0');
            generateString1(n - 1, sb, answer);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

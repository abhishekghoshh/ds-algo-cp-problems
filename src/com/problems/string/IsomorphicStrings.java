package com.problems.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/isomorphic-strings
 * https://www.codingninjas.com/studio/problems/isomorphic-strings-_1117636
 *
 * Solution link:
 *
 *
 *
 * */
public class IsomorphicStrings {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
        type5();
    }


    // best solution in the leetcode
    private static void type5() {
        String s = "paper", t = "title";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = sArr.length;
        boolean isIsomorphic = true;
        char[] map = new char[128];
        boolean[] assigned = new boolean[128];
        for (int i = 0; i < sArr.length; i++) {
            if (map[sArr[i]] == 0 && (!assigned[tArr[i]])) {
                map[sArr[i]] = tArr[i];
                assigned[tArr[i]] = true;
            } else if (map[sArr[i]] != tArr[i]) {
                isIsomorphic = false;
                break;
            }
        }
        System.out.println(isIsomorphic);
    }

    // TODO best approach, tell it in the interview
    private static void type4() {
        String s = "paper", t = "title";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = sArr.length;
        boolean isIsomorphic = true;
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        int c1, c2;
        for (int i = 0; i < n; i++) {
            c1 = sArr[i];
            c2 = tArr[i];
            if (map1[c1] == 0) {
                map1[c1] = c2;
            } else if (map1[c1] != c2) {
                isIsomorphic = false;
                break;
            }
            if (map2[c2] == 0) {
                map2[c2] = c1;
            } else if (map2[c2] != c1) {
                isIsomorphic = false;
                break;
            }
        }
        System.out.println(isIsomorphic);
    }

    private static void type3() {
        String s = "paper", t = "title";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = sArr.length;
        boolean isIsomorphic = true;
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        int c1, c2;
        for (int i = 0; i < n; i++) {
            c1 = sArr[i];
            c2 = tArr[i];
            if (map1[c1] == 0 && map2[c2] == 0) {
                map1[c1] = c2;
                map2[c2] = c1;
            } else if (map1[c1] != 0 && map2[c2] == 0) {
                isIsomorphic = false;
                break;
            } else if (map1[c1] == 0 && map2[c2] != 0) {
                isIsomorphic = false;
                break;
            } else if (map1[c1] != c2 || map2[c2] != c1) {
                isIsomorphic = false;
                break;
            }
        }
        System.out.println(isIsomorphic);
    }

    private static void type2() {
        String s = "paper", t = "title";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = sArr.length;
        boolean isIsomorphic = true;
        int[] map1 = new int[128];
        int[] map2 = new int[128];
        for (int i = 0; i < 128; i++) map1[i] = map2[i] = -1;
        int c1, c2;
        for (int i = 0; i < n; i++) {
            c1 = sArr[i];
            c2 = tArr[i];
            if (map1[c1] == -1 && map2[c2] == -1) {
                map1[c1] = c2;
                map2[c2] = c1;
            } else if (map1[c1] != -1 && map2[c2] == -1) {
                isIsomorphic = false;
                break;
            } else if (map1[c1] == -1 && map2[c2] != -1) {
                isIsomorphic = false;
                break;
            } else if (map1[c1] != c2 || map2[c2] != c1) {
                isIsomorphic = false;
                break;
            }
        }
        System.out.println(isIsomorphic);
    }


    private static void type1() {
        String s = "paper", t = "title";
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int n = sArr.length;
        boolean isIsomorphic = true;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map1.containsKey(sArr[i]) && !map2.containsKey(tArr[i])) {
                map1.put(sArr[i], tArr[i]);
                map2.put(tArr[i], sArr[i]);
            } else if ((!map1.containsKey(sArr[i]) && map2.containsKey(tArr[i]))) {
                isIsomorphic = false;
                break;
            } else if (map1.containsKey(sArr[i]) && !map2.containsKey(tArr[i])) {
                isIsomorphic = false;
                break;
            } else if (map1.get(sArr[i]) != tArr[i] || map2.get(tArr[i]) != sArr[i]) {
                isIsomorphic = false;
                break;
            }
        }
        System.out.println(isIsomorphic);
    }
}

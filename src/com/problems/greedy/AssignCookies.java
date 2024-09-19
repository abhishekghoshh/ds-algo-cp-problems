package com.problems.greedy;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/assign-cookies/description/
 * https://www.codingninjas.com/studio/problems/assign-cookies_8390826
 *
 * Solution link :
 * https://www.youtube.com/watch?v=DIX2p7vb9co
 *
 * */
public class AssignCookies {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // same as type2
    private static void type3() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (j >= 0 && s[j] >= g[i]) {
                count++;
                j--;
            }
        }
        System.out.println(count);
    }

    // optimized approach
    // first we will sort the entire array
    // we have to assign the cookies such that the greed factor is less than the rank of the cookie
    // g[i1] <= s[i2] if the condition does not satisfy then we will go to the next rank cookie,
    // but we will stick to the same greed
    // as both of the array are in sorted order
    // if we will find greater rank cookie afterward
    private static void type2() {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int i1 = 0, i2 = 0;
        int n1 = g.length, n2 = s.length;
        int count = 0;
        Arrays.sort(s);
        Arrays.sort(g);
        while (i1 < n1 && i2 < n2) {
            if (g[i1] <= s[i2]) {
                count++;
                i1++;
            }
            i2++;
        }
        System.out.println(count);
    }

    // brute force approach
    private static void type1() {

    }
}

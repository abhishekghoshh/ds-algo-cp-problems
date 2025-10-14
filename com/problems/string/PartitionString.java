package com.problems.string;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem link:
 * https://leetcode.com/problems/partition-string/description/
 *
 * Solution link:
 *
 */
// Tags: Array, String
public class PartitionString {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
    }

    // brute force solution using set
    private static void type1() {
        String s = "abbccccd";
        List<String> ans = partitionString1(s);
        System.out.println(ans);
    }

    public static List<String> partitionString1(String s) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < n; i++) {
            String sub = s.substring(start, i + 1);
            if (!seen.contains(sub)) {
                seen.add(sub);
                ans.add(sub);
                start = i + 1;
            }
        }
        return ans;
    }
}
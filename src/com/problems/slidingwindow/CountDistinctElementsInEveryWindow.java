package com.problems.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem link :
 * https://www.naukri.com/code360/problems/count-distinct-element-in-every-k-size-window_920336
 * https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
 * https://www.interviewbit.com/problems/distinct-numbers-in-window/
 *
 * Solution link :
 *
 * https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
 * https://takeuforward.org/data-structure/count-distinct-elements-in-every-window/
 */
public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
    }

    public static ArrayList<Integer> countDistinctElements3(List<Integer> arr, int k) {
        int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int offset = -min;
        int N = max - min + 1;
        Map<Integer, Integer> freq = new HashMap<>();
        int f = 0;
        for (int i = 0; i < k; i++) {
            int num = arr.get(i) + offset;
            int c = freq.getOrDefault(num, 0);
            if (c == 0) f++;
            freq.put(num, c + 1);
        }
        ans.add(f);
        for (int i = k; i < n; i++) {
            int rightNum = arr.get(i) + offset;
            int leftNum = arr.get(i - k) + offset;
            int leftC = freq.getOrDefault(leftNum, 0), rightC = freq.getOrDefault(rightNum, 0);
            if (leftC == 1) f--;
            freq.put(leftNum, leftC - 1);
            if (rightC == 0) f++;
            freq.put(rightNum, rightC + 1);
            ans.add(f);
        }
        return ans;
    }

    // sliding window approach
    // todo this is a right solution but as the max can be 10^5 to 10^9 so the freq array will cause memory overflow error
    private static void type2() {
        List<Integer> arr = List.of(1, 2, 1, 3, 4, 3);
        int k = 3;
        List<Integer> ans = countDistinctElements2(arr, k);
        System.out.println(ans);
    }

    public static ArrayList<Integer> countDistinctElements2(List<Integer> arr, int k) {
        int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int offset = -min;
        int N = max - min + 1;
        int[] freq = new int[N];
        int f = 0;
        for (int i = 0; i < k; i++) {
            int num = arr.get(i) + offset;
            if (freq[num] == 0) f++;
            freq[num]++;
        }
        ans.add(f);
        for (int i = k; i < n; i++) {
            int rightNum = arr.get(i) + offset;
            int leftNum = arr.get(i - k) + offset;
            if (freq[leftNum] == 1) f--;
            freq[leftNum]--;
            if (freq[rightNum] == 0) f++;
            freq[rightNum]++;
            ans.add(f);
        }
        return ans;
    }

    private static void type1() {

    }
}

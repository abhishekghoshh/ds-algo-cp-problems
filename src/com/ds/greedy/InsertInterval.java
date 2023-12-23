package com.ds.greedy;

import com.util.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * problem links :
 * https://leetcode.com/problems/insert-interval/description/
 * https://www.codingninjas.com/studio/problems/-insert-interval_285893
 *
 * Solution video :
 *
 *
 * https://takeuforward.org/data-structure/insert-new-interval/
 * */
public class InsertInterval {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {

    }

    // brute force approach
    // using a linked list
    private static void type1() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int n = intervals.length;
        int[] interval;
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0])
            list.add(intervals[i++]);
        if (i != n) {
            interval = intervals[i++];
            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
        while (i < n) {
            interval = intervals[i++];
            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
        list.add(newInterval);
        while (i < n) list.add(intervals[i++]);
        int n1 = list.size();
        int[][] mergedList = new int[n1][];
        for (i = 0; i < n1; i++) mergedList[i] = list.get(i);
        ArrayUtil.print2D(mergedList);
    }
}

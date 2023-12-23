package com.ds.greedy;

import java.util.Arrays;

/*
 *
 * problem links :
 * https://leetcode.com/problems/non-overlapping-intervals/description/
 * https://www.codingninjas.com/studio/problems/non-overlapping-intervals_3169341
 *
 * Solution video :
 * https://www.youtube.com/watch?v=nONCGxWoUfM
 *
 * */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        // intervals are sorted by their starting time and then to the ending time
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1[0] != i2[0]) return Integer.compare(i1[0], i2[0]);
            return Integer.compare(i1[1], i2[1]);
        });
        int n = intervals.length;
        int previousEnd = intervals[0][1];
        int count = 0;
        int start, end;
        for (int i = 1; i < n; i++) {
            start = intervals[i][0];
            end = intervals[i][1];
            if (previousEnd <= start) {
                previousEnd = end;
            } else {
                count++;
                previousEnd = Math.min(previousEnd, end);
            }
        }
        System.out.println(count);
    }
}

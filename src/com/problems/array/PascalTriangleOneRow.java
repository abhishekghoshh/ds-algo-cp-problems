package com.problems.array;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * problem links:
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * Solution link:
 * https://www.youtube.com/watch?v=k1DNTyal77I
 *
 * https://neetcode.io/solutions/pascals-triangle-ii
 * */
public class PascalTriangleOneRow {
    public static void main(String[] args) {
        type1();
    }

    // print the specific row
    // one specific row
    private static void type1() {
        int numRow = 5;
        List<Integer> row = getRow(numRow);
        System.out.println("5th row is " + row);
    }

    private static List<Integer> getRow(int row) {
        List<Integer> ans = new ArrayList<>();
        int denominator = 1;
        ans.add(1);
        while (row != 1) {
            row--;
            int last = ans.get(ans.size() - 1);
            ans.add(last * row / denominator);
            denominator++;
        }
        return ans;
    }
}

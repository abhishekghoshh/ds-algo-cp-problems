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
    private static void type1() {
        int numRow = 3;
        List<Integer> row = getRow(numRow);
        System.out.println("5th row is " + row);
    }

    private static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        int denominator = 1;
        row.add(1);
        while (rowIndex != 1) {
            rowIndex--;
            row.add(row.get(row.size() - 1) * rowIndex / denominator);
            denominator++;
        }
        return row;
    }
}

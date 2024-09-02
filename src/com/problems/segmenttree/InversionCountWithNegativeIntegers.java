package com.problems.segmenttree;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * https://www.spoj.com/problems/INVCNT/
 *
 * Solution link :
 * https://www.geeksforgeeks.org/inversion-count-in-array-using-merge-sort/
 * https://www.interviewbit.com/blog/count-inversions-of-an-array/
 * https://www.javatpoint.com/inversion-count
 *
 */
public class InversionCountWithNegativeIntegers {
    // see the last 30 minutes of codebeyond channel segment tree masterclass part 1
    // this problem can also be solved using the merge sort approach.
    // but here we will use the segment tree to solve, but the time complexity will be a little higher.
    // we can also use fenwick tree to solve this
    // we have already solved this problem for the positive numbers, but here we will expand it to the negative integers
    public static void main(String[] args) {
        type1();
        type2();
    }

    // we will use only one segment tree here
    // we will take the max and min, where min will be in negative,
    // so we will use - min as offset and shift all the number by offset
    private static void type2() {

    }


    // we will use two segment trees,
    // one for holding the negative numbers, one for holding the positive numbers
    private static void type1() {

    }
}

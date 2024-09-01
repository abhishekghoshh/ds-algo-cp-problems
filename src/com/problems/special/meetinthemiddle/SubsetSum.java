package com.problems.special.meetinthemiddle;

/*
 * Problem link :
 *
 * Solution link :
 *
 *
 */
public class SubsetSum {
    // we have already solved the subset sum using power set, recursion and dynamic programming approach,
    // but here the constraints are quite different
    // if the size of the array is too large then we cannot perform power set approach
    // if n <= 32
    // then power set approach will take 2^n which will be 2^32
    // generally 2^27 gives tle so if we use power set on array of size 32 then it will give us TLE
    // in this scenario meet in the middle will be used
    // if we can split the array, compute the sums and then check it using a set then we will not hit TLE
    public static void main(String[] args) {
        type1();
    }

    // we will split the array and use the power set approach to compute all the subsets
    private static void type1() {
        int[] arr = {1, 2, 1, 3, 2, 4, 5};

    }
}

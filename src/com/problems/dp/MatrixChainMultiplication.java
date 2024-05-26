package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=D7AFvtnDeMU&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=32
 * https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33
 * https://www.youtube.com/watch?v=9uUVFNOT3_Y&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34
 * 
 */
public class MatrixChainMultiplication {

	// Given a sequence of matrices, find the most efficient way to multiply these
	// matrices together. The efficient way is the one that involves the least
	// number of multiplications.
	// The dimensions of the matrices are given in an array arr[] of size N (such
	// that N = number of matrices + 1) where the ith matrix has the dimensions
	// (arr[i-1] x arr[i]).
	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int[] matrices = {40, 20, 30, 10, 30, 25};
		int n = matrices.length;
		int[][] memo = new int[n + 1][n + 1];
		// initializing the array
		for (int[] row : memo) Arrays.fill(row, -1);

		int minCost = mcm(matrices, 1, n - 1, memo);
		System.out.println(minCost);
	}

	private static int mcm(int[] matrices, int i, int j, int[][] memo) {
		// returning from the cache
		if (memo[i][j] != -1) return memo[i][j];
		// out of boundary
		if (i >= j) return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			// total cost of doing matrix multiplication in each i to k and k+1 tro j
			int cost = mcm(matrices, i, k, memo) + mcm(matrices, k + 1, j, memo);
			// this is for i * k * j
			cost += matrices[i - 1] * matrices[k] * matrices[j];
			// updating the min
			if (min > cost) min = cost;

		}
		// saving the answer before returning
		return memo[i][j] = min;
	}

	// brute force approach
	// lets say the input array is 40, 20, 30, 10, 30, 25
	// that means we have matrices with (40x20), (20x30), (30x10), (10,30), (30,25)
	// and we have to multiply all the matrices and produce single resultant matrix.
	// it can be done in multiple ways, but we have to do it in a way that has the minimal multiplication cost.
	// the cost of multiplying 2 matrices would be => (AxB)x(BxC)=> A*B*C
	private static void type1() {
		int[] matrices = {40, 20, 30, 10, 30, 25};
		int n = matrices.length;
		int minCost = mcm(matrices, 1, n - 1);
		System.out.println(minCost);
	}

	// we are starting from 1 as we are multiplying i-1
	private static int mcm(int[] matrices, int i, int j) {
		// out of boundary
		if (i >= j) return 0;

		int min = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			// total cost of doing matrix multiplication in each i to k and k+1 tro j
			// this i,k and k+1,j cam be saved into cache
			int cost = mcm(matrices, i, k) + mcm(matrices, k + 1, j);
			// this is for i * k * j
			cost += matrices[i - 1] * matrices[k] * matrices[j];
			// updating the min
			if (min > cost) min = cost;

		}
		return min;
	}
}

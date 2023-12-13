package com.ds.binarysearch;

/*
 * Problem link :
 * https://leetcode.com/problems/powx-n/
 * https://www.codingninjas.com/codestudio/problems/1082146
 *
 * Solution link :
 * https://www.youtube.com/watch?v=l0YC3876qxg&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=16
 * 
 * */
public class PowerOfXtoN {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// binary search approach
	// we are dividing the power by 2 if its even and multiplying the number by
	// itself at the same time, given that 3^6 is 9^3
	// if the power is 15
	// we will divide the power by 2 everytime
	// we get even power
	// else we will make it even by subtracting 1
	// 15 will be 14
	// see the solution and you will find it very easy
	private static void type2() {
		double x = 2;
		int n = 15;
		double answer = pow(x, n);
		System.out.printf("pow(%f,%d) is %f%n", x, n, answer);
	}

	private static double pow(double x, int n) {
		if (x == 1) return 1;
		else if (x == 0) return 0;
		else if (n == 0) return 1;
		else if (n == 1) return x;
		else {
			double answer = 1.0;
			long mn = n < 0 ? -n : n;
			while (mn > 0) {
				if (mn % 2 == 0) {
					mn = mn / 2;
					x = x * x;
				} else {
					answer = answer * x;
					mn--;
				}
			}
			return n > 0 ? answer : (1.0 / answer);
		}
	}

	// brute force approach
	// multiplies x to itself n times
	private static void type1() {
		double x = 2;
		int n = 10;
		double answer = 1;
		for (int i = 0; i < n; i++) answer = answer * x;
		System.out.printf("pow(%f,%d) is %f%n", x, n, answer);
	}

}

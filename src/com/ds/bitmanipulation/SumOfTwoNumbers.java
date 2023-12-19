package com.ds.bitmanipulation;

/*
 * Problem link :
 * https://leetcode.com/problems/sum-of-two-integers
 * 
 * Solution link :
 * 
 * 
 * */
public class SumOfTwoNumbers {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int a = 17;
		int b = 19;
		while (b != 0) {
			int carry = (a & b) << 1;
			a = a ^ b;
			b = carry;
		}
		System.out.println();
	}

}

package com.problems.bitmanipulation;

/*
 * Problem link :
 * https://leetcode.com/problems/sum-of-two-integers/description/
 * https://neetcode.io/problems/sum-of-two-integers
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=qq64FrA2UXQ
 * https://www.youtube.com/watch?v=N3dtzMKJMn8
 *
 *
 * https://www.youtube.com/watch?v=gVUrDV4tZfY
 * https://neetcode.io/solutions/sum-of-two-integers
 */
public class AdditionWithoutPlusOperator {

	public static void main(String[] args) {
		type1();
	}

	// todo if we try to use only bitwise operators then it is the only option
	//  lets go with a single bit, x and y
	//  lets see all the possibility
	//  0 + 0 => 0, 0 + 1 => 1, 1 + 0 => 1, 1 + 1 => 10
	//  so for one bit sum we can have 2 bits, one for sum and one for carry
	//  it is very brightly visible that, sum = x ^ y, carry = x & y
	//  if we represent the carry where it will be placed then it will be carry << 1
	//  so again if we perform sum operation with sum and carry then we will get the result
	//  we can do the same for a large number of bits
	//  lets say the numbers are 01010 and 01011 => sum(01010, 01011) => 10101
	//  the sum will be xor of this two numbers => 00001
	//  the carry will be and of this two numbers => 01010, but the actual position of carry is left shifted by 1
	//  which is 10100
	//  if we again perform the sum operation with sum and carry then
	//  we will be sum as 10101 and carry is 00000
	//  so we will keep performing this until the carry is 0
	private static void type1() {
		int a = 5;
		int b = 6;
		int sum = getSum(a, b);
		System.out.println(sum);
	}

	public static int getSum(int a, int b) {
		// while the carry is not equal to 0
		while (b != 0) {
			int sum = a ^ b; // doing sum operation
			// doing carry operation
			// and left shifting it	because it will be placed in the next position
			int carry = (a & b) << 1;
			// updating the value of a and b
			a = sum;
			b = carry;
		}
		return a;
	}
}

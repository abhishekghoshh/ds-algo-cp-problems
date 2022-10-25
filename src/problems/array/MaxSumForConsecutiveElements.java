package problems.array;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/maximum-subarray/
 * https://www.codingninjas.com/codestudio/problems/630526?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link : https://www.youtube.com/watch?v=w_KEocd__20&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=5
 * 
 * */
//Maximum sub array problem
//Kadane's Algorithm
public class MaxSumForConsecutiveElements {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// Kadane's algorithm of o(n)
	// we carry a sub array if its sum is positive else we'll initialize it to 0
	private static void type2() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// on each step we will add the element to the sum
			// but if the item + previous sum is lesser than the item
			// then we initialize the sum to current item
			sum = Math.max(nums[i], sum + nums[i]);
			// we will again check the current sum is max sum or not
			maxSum = Math.max(maxSum, sum);
		}
		System.out.println("Maximum subarray value is " + maxSum);
	}

	// brute force approach for o(n'2)
	private static void type1() {
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			int sum = 0;
			for (int j = i; j < array.length; j++) {
				sum = sum + array[j];
				if (sum > maxSum) {
					maxSum = sum;
				}
			}
		}
		System.out.println("Maximum subarray value is " + maxSum);
	}

}

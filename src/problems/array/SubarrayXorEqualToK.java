package problems.array;

/*
 * Problem link:
 * https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://www.interviewbit.com/problems/subarray-with-given-xor/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=lO9R5CaGRPY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=26
 * */
public class SubarrayXorEqualToK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		
	}

	// brute force approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 4, 2, 2, 6, 4 };
		int k = 6;
		int xor = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			xor = 0;
			for (int j = i; j < nums.length; j++) {
				xor = xor ^ nums[j];
				if (xor == k) {
					count++;
				}
			}
		}
		System.out.println("count is " + count);
	}

}

package problems.trie;


/*
 * Problem link :
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * https://www.codingninjas.com/codestudio/problems/maximum-xor_3119012?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=EIhAwfHubE8&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=6
 * 
 * 
 * https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/
 * 
 */
public class MaximumXorOfTwoNumbersInArray {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using trie approach
	private static void type2() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
	}

	// brute force approach
	// time complexity O(n^2)
	private static void type1() {
		int[] nums = { 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70 };
		int xor = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					xor = Math.max((nums[i] ^ nums[j]), xor);
				}
			}
		}
		System.out.println(xor);
	}

}

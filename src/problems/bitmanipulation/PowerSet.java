package problems.bitmanipulation;

import java.util.ArrayList;
import java.util.List;
/*
 * Problem link :
 * https://leetcode.com/problems/subsets/
 * https://practice.geeksforgeeks.org/problems/power-set4302/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=b7AYbpM5YrE
 * 
 */
public class PowerSet {

	public static void main(String[] args) {
		type1();
	}

	// let's say our array is 1,2,3, n=3
	// so we will run a loop from 0 to 2^n -1
	// find the binary of the number i
	// suppose i => 101
	// so we will add the arr[index] such that binary[index]=1
	// 101 means we will add 1 and 3
	// time complexity O(n*2^n)
	// space complexity O(n)
	private static void type1() {
		int[] arr = { 1, 2, 3 };
		int n = arr.length;
		// size of power is 2^n
		// so we will run a loop 0 to 2^n -1
		int bound = 1 << n;
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> bucket = null;
		int index, num;
		for (int i = 0; i < bound; i++) {
			bucket = new ArrayList<>(2 * n);
			index = 0;
			num = i;
			while (num != 0) {
				if ((num & 1) == 1) {
					bucket.add(arr[index]);
				}
				index++;
				num = num >> 1;
			}
			answer.add(bucket);
		}
		System.out.println(answer);
	}

}

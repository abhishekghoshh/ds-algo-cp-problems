package problems.bitmanipulation;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1
 * https://leetcode.com/problems/counting-bits/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=ZzZcFXDcbJw
 * https://www.youtube.com/watch?v=kU5G5-6xEF4
 * 
 */
public class CountTotalSetBits {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// count total set bits from 1 to n inclusive
	private static void type4() {
		int n = 9;
		int count = 0;
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i >> 1] + (i & 1);
			count = count + arr[i];
		}
		System.out.println(count);
	}

	// it is same as type2
	// i/2 and i>>1 is same
	// i%2 and i&1 is same
	// be cautious while working with bitwise operator
	private static void type3() {
		int n = 3;
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i >> 1] + (i & 1);
		}
		print(arr);
	}

	// Intuition
	// for a number like 6 has the same bit count as 6/2=>3
	// for 3 and 6 has the same bit count
	// now lets think reverse
	// if the number is 3 then 3*2 and 3*2+1 can be derived from 3
	// 3*2 has the same bit count as 3 and 7 has just exactly one bit more than 3
	// so for a number n the count of bit is the same as n/2 if n is positive and
	// count(n/2)+1 if n is negative
	// so we can store the previous results in array
	private static void type2() {
		int n = 10;
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i / 2] + i % 2;
		}
		print(arr);
	}

	// for each number we are counting the bits
	// for each number the average complexity is O(log(n/2))
	// there are n numbers
	// so total time complexity is O(n*log(n))
	// but we can do better
	private static void type1() {
		int n = 10;
		int[] arr = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			arr[i] = count(i);
		}
		print(arr);
	}

	private static int count(int i) {
		int ones = 0;
		while (i != 0) {
			ones = ones + (i & 1);
			i = i >>> 1;
		}
		return ones;
	}

	private static void print(int[] ans) {
		for (int num : ans) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}

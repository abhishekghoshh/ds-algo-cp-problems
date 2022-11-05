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
		type5();
		type6();
	}

	// 0 0 0 0 0
	// 0 0 0 0 1
	// 0 0 0 1 0
	// 0 0 0 1 1
	// 0 0 1 0 0
	// 0 0 1 0 1
	// 0 0 1 1 0
	// 0 0 1 1 1
	// 0 1 0 0 0
	// 0 1 0 0 1
	// 0 1 0 1 0
	// 0 1 0 1 1
	// 0 1 1 0 0
	// 0 1 1 0 1
	// 0 1 1 1 0
	// 0 1 1 1 1
	// 1 0 0 0 0
	private static void type6() {
		int n = 7;
		int count = 0;
		int index = 3;
		int mask = 1 << index;
		while (index >= 0) {
			if ((n & mask) != 0) {
				int temp = (1 << index) * (index + 1);
				count = count + 1 + temp;
//				n = n & (~(1 << index));
			}
			mask = mask >> 1;
			index--;
		}
		System.out.println(count);
	}

	// 0 0 0 0 0
	// 0 0 0 0 1
	// 0 0 0 1 0
	// 0 0 0 1 1
	// 0 0 1 0 0
	// 0 0 1 0 1
	// 0 0 1 1 0
	// 0 0 1 1 1
	// 0 1 0 0 0
	// 0 1 0 0 1
	// 0 1 0 1 0
	// 0 1 0 1 1
	// 0 1 1 0 0
	// 0 1 1 0 1
	// 0 1 1 1 0
	// 0 1 1 1 1
	// 1 0 0 0 0
	// count total set bits from 1 to n inclusive
	private static void type4() {
		int n = 7;
		int count = 0;
		int arr[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = arr[i >> 1] + (i & 1);
			count = count + arr[i];
		}
		System.out.println(count);
	}

	private static void type5() {
		int n = 7;
		int count = countSetBits(n);
		System.out.println(count);
	}

	// Function to return sum of count of set bits in the integers from 1 to n.
	public static int countSetBits(int n) {
		if (n == 0)
			return 0;
		int x = largestPowerOf2(n);
		int a = x * (1 << (x - 1));
		int b = n - (1 << x) + 1;
		int c = n - (1 << x);
		int ans = a + b + countSetBits(c);
		return ans;
	}

	public static int largestPowerOf2(int n) {
		int x = 0;
		while ((1 << x) <= n) {
			x++;
		}
		return x - 1;
	}

	// it is same as type2
	// i/2 and i>>1 is same
	// i%2 and i&1 is same
	// be cautious while working with bitwise operator
	private static void type3() {
		int n = 7;
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
		int n = 7;
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
		int n = 7;
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

package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 * Problem link :
 * https://leetcode.com/problems/permutation-sequence/
 * https://www.codingninjas.com/codestudio/problems/1112626
 * Solution link :
 * https://www.youtube.com/watch?v=wT7gcXLYoao&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=56
 *
 * https://takeuforward.org/data-structure/find-k-th-permutation-sequence/
 */
public class KthPermutationSequence {
	public static int n = 4;
	public static int k = 21;

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// TODO study later
	private static void type5() {
		int n = 4;
		int k = 21;
		char[] res = new char[n];
		// We want the permutation sequence to be zero-indexed
		k = k - 1;
		// The set bits indicate the available digits
		int a = (1 << n) - 1;
		int m = 1;
		for (int i = 2; i < n; i++) {
			// m = (n - 1)!
			m *= i;
		}
		for (int i = 0; i < n; i++) {
			int b = a;
			for (int j = 0; j < k / m; j++) {
				b &= b - 1;
			}
			// b is the bit corresponding to the digit we want
			b &= ~b + 1;
			res[i] = (char) ('1' + Integer.bitCount(b - 1));
			// Remove b from the set of available digits
			a &= ~b;
			k %= m;
			m /= Math.max(1, n - i - 1);
		}
		System.out.println(String.valueOf(res));
	}

	// iterative way
	private static void type4() {
		int n = 4;
		int k = 1;
		List<Integer> number = new ArrayList<>();
		int fact = 1;
		for (int i = 1; i < n; i++) {
			fact = fact * i;
			number.add(i);
		}
		number.add(n);
		StringBuilder ans = new StringBuilder();
		k = k - 1;
		while (true) {
			ans.append(number.get(k / fact));
			number.remove(k / fact);
			if (number.size() == 0) {
				break;
			}
			k = k % fact;
			fact = fact / number.size();
		}
		System.out.println(ans);
	}

	// iterative way
	private static void type3() {
		int n = 4;
		int k = 1;
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		// 0 to n - 1 factorial
		int[] factorial = new int[n];
		factorial[0] = 1;

		for (int i = 1; i < n; i++) {
			nums.add(i + 1);
			factorial[i] = factorial[i - 1] * i;
		}

		StringBuilder result = new StringBuilder();
		int selectedIndex;
		for (int i = n - 1; i >= 0; i--) {
			selectedIndex = (k - 1) / factorial[i];
			result.append(nums.get(selectedIndex));
			k = k - (selectedIndex * factorial[i]);
			nums.remove(selectedIndex);
		}
		System.out.println(result);
	}

	// suppose we have a number 1234
	// this number will have 24 permutations
	// out of which 1st 6 numbers will be starting with 1, second 6 numbers will be
	// starting from 2 and so on
	// so if we take 10 th number
	// we know one thing that it will start from 2
	// so first item 2 is fixed remaining number is 134
	// now we know we have 6 numbers and out of which 1st 2 numbers starts with 1,
	// second 2 numbers starts with 3 and last 2 numbers starts with 4
	// and out of 6 our word rank is 4 so we know it will fall in 2nd 2 numbers
	// so the first number is 3
	// this we can find the remaining
	private static void type2() {
		int n = 4;
		int k = 1;
		List<Integer> numbers = new ArrayList<>();
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
			factorial = factorial * i;
		}
		StringBuilder answer = new StringBuilder();
		// as the group will be formed in 0 indexing formats
		// like 0 to n-1 so subtracting k to 1
		computeKthPermutation(numbers, factorial, answer, k - 1);
		System.out.println(answer);
	}

	private static void computeKthPermutation(List<Integer> numbers, int factorial, StringBuilder answer, int k) {
		if (numbers.isEmpty()) return;
		// currently factorial is n! where n is the size of numbers
		// so there will be n groups of (n-1)! numbers
		// if we divide it by numbers.size() then we will find (n-1)!
		factorial = factorial / numbers.size();
		// now we will find in which group it will fall
		int position = k / factorial;
		answer.append(numbers.get(position));
		// once we get that number, we will remove that from numbers
		// let our number is 1234 and the position is 2, so we will take 3 and remove it,
		// so we will have 124
		numbers.remove(position);
		// now we will find our next group
		k = k % factorial;
		computeKthPermutation(numbers, factorial, answer, k);
	}

	// brute force will be to find all the permutation and then store it in list
	// then then return n-1
	private static void type1() {
		int n = 4;
		int k = 19;
		// create the array
		char[] arr = new char[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = (char) ('0' + i);
		}
		// find all the permutations
		List<String> answer = new ArrayList<>();
		computePermutations(arr, 0, answer);
		// get the kth permutation
		Collections.sort(answer);
		System.out.println(answer);
		System.out.println(answer.get(k - 1));
	}

	private static void computePermutations(char[] array, int index, List<String> answer) {
		if (index == array.length) {
			answer.add(new String(array));
			return;
		}
		for (int i = index; i < array.length; i++) {
			swap(array, i, index);
			computePermutations(array, index + 1, answer);
			swap(array, i, index);
		}
	}

	private static void swap(char[] array, int left, int right) {
		char ch = array[left];
		array[left] = array[right];
		array[right] = ch;
	}
}

package com.problems.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem links:
 * https://leetcode.com/problems/permutations/
 * https://www.naukri.com/code360/problems/758958
 * 
 * Solution link
 * https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51
 * https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=52
 *
 * https://www.youtube.com/watch?v=zC4D7cuaYzo&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=7
 * https://www.youtube.com/watch?v=XZQKgcjbogo&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=7
 * https://www.youtube.com/watch?v=EnRciMd08_g&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=8
 *
 * https://takeuforward.org/data-structure/print-all-permutations-of-a-string-array/
 * */
public class Permutations1 {
	// TODO check the videos once again
	//  When we pass the new string object everytime we intentionally using the recursion, because the every
	//  recursion stack will have its own object, we do not need to think twice, but when we pass by the array
	//  reference and manipulating that and then after the recursion call we are again changing the array to its
	//  initial form, then essentially we are using the backtracking
	//  pass by value -> recursion
	//  pass by reference -> backtracking
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
		type6();
	}

	// using backtracking in place array
	// with 2 optimization
	private static void type6() {
		String string = "abac";
		List<String> ans = new ArrayList<>();
		permutations6(0, string.toCharArray(), ans);
		System.out.println(ans);
	}

	private static void permutations6(int start, char[] arr, List<String> ans) {
		int n = arr.length;
		if (start == n) {
			ans.add(new String(arr));
			return;
		}
		boolean[] visited = new boolean[26];
		for (int i = start; i < n; i++) {
			if (!visited[arr[i] - 'a']) {
				swap(arr, start, i);
				permutations6(start + 1, arr, ans);
				swap(arr, start, i);
				visited[arr[i] - 'a'] = true;
			}
		}
	}


	// assuming there are some duplicates,
	// we will be creating a boolean map to so that don't encounter any duplicate
	// element similar to a type1 solution
	private static void type5() {
		String string = "abac";
		List<String> ans = new ArrayList<>();
		StringBuilder prev = new StringBuilder();
		permutations5(string, prev, ans);
		System.out.println(ans);
	}

	private static void permutations5(String curr, StringBuilder prev, List<String> ans) {
		if (null == curr || curr.isEmpty()) {
			ans.add(prev.toString());
			return;
		}
		// we could have used a boolean array instead of hashset
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < curr.length(); i++) {
			char ch = curr.charAt(i);
			// we will only consider one element at a label if it is not used previously
			// that's why we are using a set to keep track of the characters which we have, already used in this label
			// lets say the string is abac, we are now 0th index,
			if (!set.contains(ch)) {
				String remaining = curr.substring(0, i) + curr.substring(i + 1);
				prev.append(ch);
				permutations5(remaining, prev, ans);
				prev.deleteCharAt(prev.length() - 1);
				set.add(ch);
			}
		}
	}

	// same as type previous type3
	// in place of a char array here it is an int array
	// this is using backtracking as we are doing it in place
	private static void type4() {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> answer = new ArrayList<>();
		permutations4(nums, 0, answer);
		System.out.println(answer);
	}

	private static void permutations4(int[] arr, int start, List<List<Integer>> answer) {
		if (start == arr.length) {
			List<Integer> bucket = new ArrayList<>();
			for (int num : arr) bucket.add(num);
			answer.add(bucket);
			return;
		}
		for (int i = start; i < arr.length; i++) {
			swap(arr, i, start);
			permutations4(arr, start + 1, answer);
			swap(arr, i, start);
		}
	}

	private static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	// assuming all characters are distinct,
	// choosing one character or element to be the first
	// compatible with both string and array
	// string array needs to convert in to array.
	// if it's a int array then we can take the List of Integers for bucket
	// this is using backtracking as we are doing it in place
	private static void type3() {
		String string = "abc";
		List<String> answer = new ArrayList<>();
		permutations3(string.toCharArray(), 0, answer);
		System.out.println(answer);
	}

	private static void permutations3(char[] array, int start, List<String> answer) {
		if (start == array.length) {
			answer.add(new String(array));
			return;
		}
		// Let say the string is abcd.
		// Index is 0
		// now we are choosing c to be the first
		// so we swap it with index so string will be cbad
		// now again we will start recursion from index+1
		// gain after all the computation we will replace it back
		for (int i = start; i < array.length; i++) {
			swap(array, i, start);
			permutations3(array, start + 1, answer);
			swap(array, i, start);
		}
	}

	private static void swap(char[] array, int left, int right) {
		char ch = array[left];
		array[left] = array[right];
		array[right] = ch;
	}

	// all elements are distinct
	// compatible with both string and array
	private static void type2() {
		String string = "abc";
		List<String> answer = new ArrayList<>();
		Set<Character> set = new HashSet<>();
		permutations2(new StringBuilder(), string, set, answer);
		System.out.println(answer);
	}

	private static void permutations2(StringBuilder prev, String curr, Set<Character> set, List<String> answer) {
		if (set.size() == curr.length()) {
			answer.add(prev.toString());
		}
		// at every point we recursion we will add one unique element
		for (int i = 0; i < curr.length(); i++) {
			char ch = curr.charAt(i);
			if (!set.contains(ch)) {
				prev.append(ch);
				set.add(ch);
				permutations2(prev, curr, set, answer);
				prev.deleteCharAt(prev.length() - 1);
				set.remove(ch);
			}
		}
	}

	// assuming All elements are distinct, only compatible with string as we can perform
	// string.substring(0, i) + string.substring(i + 1) with string only
	private static void type1() {
		String string = "abc";
		List<String> answer = new ArrayList<>();
		permutations1(new StringBuilder(), string, answer);
		System.out.println(answer);
	}

	private static void permutations1(StringBuilder prev, String curr, List<String> answer) {
		if (curr.isEmpty()) answer.add(prev.toString());
		// suppose the string is 'abcd' and previous is empty.
		// so we will first consider 'a', bcd then b,acd then c,abd then
		// now for 'a','bcd' , previous is a and current string is 'bcd'
		// we will follow the same 'ab','cd' then ac,bd then ad,bc
		for (int i = 0; i < curr.length(); i++) {
			String remaining = curr.substring(0, i) + curr.substring(i + 1);
			prev.append(curr.charAt(i));
			permutations1(prev, remaining, answer);
			prev.deleteCharAt(prev.length() - 1);
		}
	}

}

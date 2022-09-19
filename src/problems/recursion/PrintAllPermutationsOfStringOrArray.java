package problems.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem links:
 * https://leetcode.com/problems/permutations/
 * https://www.codingninjas.com/codestudio/problems/758958?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link
 * https://www.youtube.com/watch?v=YK78FU5Ffjw&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51
 * https://www.youtube.com/watch?v=f2ic2Rsc9pU&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=52
 * 
 * */
public class PrintAllPermutationsOfStringOrArray {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	// assuming there are some duplicates
	// we will be creating boolean map to so that don't encounter any duplicate
	// element
	// similar to type1 solution
	private static void type5() {
		String string = "abac";
		List<String> permutations = new ArrayList<>();
		StringBuilder previous = new StringBuilder();
		computePermutationsWithDuplicateItems(string, previous, permutations);
		System.out.println(permutations);
	}

	private static void computePermutationsWithDuplicateItems(String string, StringBuilder previous,
			List<String> permutations) {
		if (null == string || string.isEmpty()) {
			permutations.add(previous.toString());
			return;
		}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			// we will only consider one element at a label if it is not used previously
			// that's why we are using set to keep track of the characters which we have
			// already used in this label
			if (!set.contains(ch)) {
				String remainingString = string.substring(0, i) + string.substring(i + 1);
				previous.append(ch);
				computePermutationsWithDuplicateItems(remainingString, previous, permutations);
				previous.deleteCharAt(previous.length() - 1);
				set.add(ch);
			}
		}
	}

	// same as type previous type3
	// in place of char array here it is int array
	private static void type4() {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> answer = new ArrayList<>();
		computePermutations4(nums, 0, answer);
		System.out.println(answer);
	}

	private static void computePermutations4(int[] array, int index, List<List<Integer>> answer) {
		if (index == array.length) {
			List<Integer> bucket = new ArrayList<>();
			for (int num : array) {
				bucket.add(num);
			}
			answer.add(bucket);
			return;
		}
		for (int i = index; i < array.length; i++) {
			swap(array, i, index);
			computePermutations4(array, index + 1, answer);
			swap(array, i, index);
		}
	}

	private static void swap(int[] array, int left, int right) {
		int object = array[left];
		array[left] = array[right];
		array[right] = object;
	}

	// assuming all characters are distinct
	// choosing one character or element to be the first
	// compatible with both string and array
	// string array needs to convert in to array
	// if its a int array then we can take List of Integer for bucket
	private static void type3() {
		String string = "abc";
		List<String> answer = new ArrayList<>();
		computePermutations3(string.toCharArray(), 0, answer);
		System.out.println(answer);
	}

	private static void computePermutations3(char[] array, int index, List<String> answer) {
		if (index == array.length) {
			answer.add(new String(array));
			return;
		}
		// let say the string is abcd, and index is 0
		// now we are choosing c to be the first
		// so we swap it with index so string will be cbad
		// now again we will start recursion from index+1
		// gain after all the computation we will replace it back
		for (int i = index; i < array.length; i++) {
			swap(array, i, index);
			computePermutations3(array, index + 1, answer);
			swap(array, i, index);
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
		StringBuilder previous = new StringBuilder();
		List<String> answer = new ArrayList<>();
		Set<Character> set = new HashSet<>();
		computePermutations2(previous, string, set, answer);
		System.out.println(answer);
	}

	private static void computePermutations2(StringBuilder previous, String string, Set<Character> set,
			List<String> answer) {
		if (set.size() == string.length()) {
			answer.add(previous.toString());
		}
		// at every point we recursion we will add one unique element
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (!set.contains(ch)) {
				previous.append(ch);
				set.add(ch);
				computePermutations2(previous, string, set, answer);
				previous.deleteCharAt(previous.length() - 1);
				set.remove(ch);
			}
		}
	}

	// assuming All elements are distinct
	// only compatible with string as we can perform
	// string.substring(0, i) + string.substring(i + 1) with string only
	private static void type1() {
		String string = "abc";
		StringBuilder previous = new StringBuilder();
		List<String> answer = new ArrayList<>();
		computePermutations1(previous, string, answer);
		System.out.println(answer);
	}

	private static void computePermutations1(StringBuilder previous, String string, List<String> answer) {
		if (null == string || string.isEmpty()) {
			answer.add(previous.toString());
		}
		// suppose string is abcd and previous is empty
		// so we will first consider a, bcd then b,acd then c,abd then
		// now for a,bcd , previous is a and current string is bcd
		// we will follow the same ab,cd then ac,bd then ad,bc
		for (int i = 0; i < string.length(); i++) {
			String remainingString = string.substring(0, i) + string.substring(i + 1);
			previous.append(string.charAt(i));
			computePermutations1(previous, remainingString, answer);
			previous.deleteCharAt(previous.length() - 1);
		}
	}

}

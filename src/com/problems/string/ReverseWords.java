package com.problems.string;
/*
 * Problem link :
 * 
 * 
 * Solution link :
 * 
 * 
 */
public class ReverseWords {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		String s = "the sky is   blue";
		//eht yks si blue
		char[] arr = s.trim().toCharArray();
		int left = 0, right = 0;
		while (right < arr.length) {
			if (arr[right] == ' ') {
				swap(arr, left, right - 1);
				left = right + 1;
			}
			right++;
		}
		String reverseString = new String(arr);
		System.out.println(reverseString);
	}

	private static void swap(char[] arr, int left, int right) {
		while (left < right) {
			char ch = arr[left];
			arr[left] = arr[right];
			arr[right] = ch;
			left++;
			right--;
		}
	}

}

package com.util;

public class ArrayBuilder {
	public static int[] buildArrayFromTestString(String str) {
		String[] arr = str.trim().split(" ");
		int[] nums = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nums[i] = Integer.parseInt(arr[i]);
		}
		System.gc();
//		Runtime.getRuntime().gc();
		return nums;
	}
}

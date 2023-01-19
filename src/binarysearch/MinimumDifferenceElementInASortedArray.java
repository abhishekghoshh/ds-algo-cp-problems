package binarysearch;
/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=3RhGdmoF_ac&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=15
 * 
 * */

public class MinimumDifferenceElementInASortedArray {

	public static void main(String[] args) {
		type2();
	}

	// This is a trick question
	// in the last iteration if the value is not in the array then low and high
	// index represents the ceiling and floor of the key
	private static void type2() {
		int[] arr = { 10, 20, 30, 50, 60, 80, 110, 130, 140, 170 };
		int key = 60;
		boolean isPresent = false;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == key) {
				isPresent = true;
				break;
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (isPresent) {
			System.out.println("The value of minimum difference is 0");
		} else {
			// at this point low>high
			// that's why the loop got terminated
			// where high element is the floor
			// and low element is the ceiling
			int minDifference = Math.min(arr[low] - key, key - arr[high]);
			System.out.println("The value of minimum difference is " + minDifference);
		}
	}

}

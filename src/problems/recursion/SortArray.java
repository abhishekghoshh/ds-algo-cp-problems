package problems.recursion;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/sort-the-array0055/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=AZ4jEY_JAVc&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=6
 * 
 * */
public class SortArray {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] arr = { 5, 2, 7, 1, 6, 9, 8, 3, 4 };
		int n = arr.length;
		sort(arr, n);
		print(arr);
	}

	private static void sort(int[] arr, int n) {
		// Base case
		// When size of array is 1
		if (n == 1) {
			return;
		}
		// sort n-1 elements
		sort(arr, n - 1);
		// now pick the last element that was remaining
		// and place it it's appropriate place
		int lastElement = arr[n - 1], right = n - 2;
		while (right >= 0 && lastElement < arr[right]) {
			arr[right + 1] = arr[right];
			right--;
		}
		// as lastElement < arr[right] will hold no more
		// so right+1 is the place for that element
		arr[right + 1] = lastElement;
	}

	private static void print(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}

package problems.binarysearch;

//This is a trick question
//in the last iteration if the value is not in the array then low and high index represents the ceiling and floor of the key
public class MinimumDifferenceElementInASortedArray {

	public static void main(String[] args) {
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
			int differenceFromCeiling = arr[low] - key;
			int differenceFromFloor = key - arr[high];
			System.out.println(
					"The value of minimum difference is " + Math.min(differenceFromCeiling, differenceFromFloor));
		}
	}

}

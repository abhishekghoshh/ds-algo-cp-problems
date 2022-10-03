package problems.binarysearch;

public class NoOfTimesSortedArrayRotated {
	public static void main(String args[]) {
		type1();
		type2();
	}

	// binary search method
	private static void type2() {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0 };
		int n = nums.length;
		int low = 0, high = n - 1;
		int next, prev;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			next = next(mid, n);
			prev = prev(mid, n);
			// if the mid is less than its next and prev that means it is the starting
			// element
			if (nums[prev] > nums[mid] && nums[mid] < nums[next]) {
				low = mid;
				break;
			} else if (nums[low] <= nums[mid]) {
				// it is in the left side
				// low to mid elements are sorted
				low = mid + 1;
			} else {
				// it is in the right side
				// mid to high elements are sorted
				high = mid - 1;
			}
		}
		System.out.println(low);
	}

	// brute force
	private static void type1() {
		int[] nums = { 7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6 };
		int n = nums.length, next, prev, index = -1;
		for (int i = 0; i < n; i++) {
			next = next(i, n);
			prev = prev(i, n);
			if (nums[i] < nums[next] && nums[i] < nums[prev]) {
				index = i;
			}
		}
		System.out.println(index);
	}

	private static int prev(int i, int n) {
		return (i - 1 + n) % n;
	}

	private static int next(int i, int n) {
		return (i + 1) % n;
	}
}

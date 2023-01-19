package array;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/1112652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/reverse-pairs/
 * 
 * Solution link : https://www.youtube.com/watch?v=S6rsAlj_iB4&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=20
 * 
 * 
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 * */
public class ReversePairs {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimal approach
	// using merge sort approach
	// in the merge function we will compute
	// we will have two sorted array left and right
	// we will use two pointer , we will move the right pointer
	// till the point we get nums1[left] > 2 * nums2[right]
	// suppose our two array is 5,7,9 and 3,4
	// for 3 it will go to 7 and we now both array are sorted
	// anything after 7 will also satisfy the upper condition
	// once we find for 3 then we search for 4
	// thus we will find the answer for all sub arrays in total
	private static void type2() {
		int[] nums = { 1, 3, 2, 3, 1 };
		int n = nums.length;
		int[] numsCopy = new int[n];
		Value value = new Value();
		mergeSortAndCompute(nums, 0, n - 1, numsCopy, value);
		System.out.println("count is " + value.data);
	}

	private static void mergeSortAndCompute(int[] nums, int i, int j, int[] numsCopy, Value value) {
		if (i < j) {
			int mid = (i + j) / 2;
			mergeSortAndCompute(nums, i, mid, numsCopy, value);
			mergeSortAndCompute(nums, mid + 1, j, numsCopy, value);
			mergeAndCompute(nums, i, mid, j, numsCopy, value);
		}
	}

	private static void mergeAndCompute(int[] nums, int i, int mid, int j, int[] numsCopy, Value value) {
		int left = i, right = mid + 1;
		long holderValue;
		// first pointer on right side array
		// total complexity of this loops will go O(leftSize+rightSize) => O(n)
		while (right <= j) {
			// holding to long in case it overflows while multiplying by 2
			holderValue = nums[right];
			holderValue = 2 * holderValue;
			// incrementing left until we find nums[left] > 2 * nums[right].
			while (left <= mid && nums[left] <= holderValue) {
				left++;
			}
			if (left <= mid) {
				value.data = value.data + (mid - left + 1);
				right++;
			} else {
				break;
			}
		}
		left = i;
		right = mid + 1;
		int length = j - i + 1;
		int index = 0;
		while (left <= mid && right <= j) {
			if (nums[left] <= nums[right]) {
				numsCopy[index++] = nums[left++];
			} else {
				numsCopy[index++] = nums[right++];
			}
		}
		while (left <= mid) {
			numsCopy[index++] = nums[left++];
		}
		while (right <= j) {
			numsCopy[index++] = nums[right++];
		}
		for (index = 0; index < length; index++) {
			nums[index + i] = numsCopy[index];
		}
	}

	private static class Value {
		int data = 0;
	}

	// brute force approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 1, 3, 2, 3, 1 };
		int n = nums.length;
		int count = 0;
		long value;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				value = nums[j];
				value = 2 * value;
				if (nums[i] > value) {
					count++;
				}
			}
		}
		System.out.println("count is " + count);
	}

}

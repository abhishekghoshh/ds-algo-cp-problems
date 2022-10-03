package problems.binarysearch;

/*
 * Problem link : 
 * https://www.codingninjas.com/codestudio/problems/1112654?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 
 * 
 * Solution is :
 * https://www.youtube.com/watch?v=PzszoiY5XMQ&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=65
 * https://takeuforward.org/data-structure/search-single-element-in-a-sorted-array/
 * 
 * */
public class SingleElementInSortedArray {

	public static void main(String[] args) {
		type1();
		type2();
	}


	private static void type2() {
		int[] nums = { 1, 1, 2, 2, 3, 4, 4, 8, 8, 9, 9 };
		int n = nums.length;
		// we know that the array has 2m+1 elements
		// where m elements appears twice and a single element is present
		// we have to find that single element
		// if we see closely we can see one pattern
		// before the single element
		// first element is in even index second element in odd index
		// like 2 is in 2 and 3 index
		// after the single element
		// first element is in odd index second element in even index
		// like 8 is in 9 and 10th index
		// so now we have a logic to shrink the size
		// so we will take low as 0 and high as n-2
		// that means the first index for first and last couple
		// if middle index is even

		int low = 0, high = n - 2, mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			// mid is even
			if (mid % 2 == 0) {
				if (nums[mid] == nums[mid + 1]) {
					// it means it is in left half and mid and mid+1 is same
					low = mid + 1; // omiting the left half
				} else {
					// it means we are in the right portion
					high = mid - 1;// omiting the right half
				}
			} else {
				// mid is odd
				if (nums[mid] == nums[mid + 1]) {
					// it means we are in right half mid and mid+1 same
					high = mid - 1;// omiting the right half
				} else {
					// we are in left portion
					low = mid + 1;
				}
			}
		}
		System.out.println(nums[low]);

	}

	// time complexity is O(n)
	// space complexity is O(1)
	private static void type1() {
		int[] nums = { 1, 1, 2, 2, 3, 4, 4, 7, 7, 8, 8, 9, 9 };
		// we know that the array has 2m+1 elements
		// where m elements appears twice and a single element is present
		// we have to find that single element
		// we also know that if we xor an element with itself then it become 0
		// and we xor anything with 0 then we will get the same element
		// so identity = 0 and x ^ x = identity
		// we can use this
		int xor = 0;
		for (int num : nums) {
			xor = xor ^ num;
		}
		System.out.println(xor);
	}

}

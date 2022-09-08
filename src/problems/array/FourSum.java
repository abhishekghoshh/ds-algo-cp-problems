package problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/983605?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/4sum/
 * 
 * Solution link
 * https://www.youtube.com/watch?v=4ggF3tXIAp0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=22
 * 
 * 
 * */
public class FourSum {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// 2 pointer approach
	// time complexity O(n^3) + O(n*log(n))
	// space complexity O(1)
	private static void type2() {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		Arrays.sort(nums);
		int left, right, n = nums.length, leftItem, rightItem, sum;
		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 0; i <= n - 4; i++) {

			//if there is a series of duplicates then it will just take the first time when i==0
			//when i> 0 then for all duplicate value will be skipped
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			// in a series left most elements are the smallest
			// if sum of i to i+3 elements are less than target then there is not point to check
			if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
			// if left plus last 3 numbers are less than target 
			// than means left most element is useless as last 3 numbers are the highest
			// we have to skip this nums[i]
			if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;

			for (int j = i + 1; j <= n - 3; j++) {

				//if there is a series of duplicates then it will just take the first time when j==i+1
				//when j>i+1 then for all duplicate value will be skipped
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;
				// in a series left most elements are the smallest
				// if sum of i and j to j+2 elements are less than target then there is not point to check
				if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target ) break;
				// if nums[i] plus nums[j] and last 2 numbers are less than target 
				// than means nums[j] is useless as last 2 numbers are the highest
				// we have to skip this nums[j]
				if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target ) continue;
				left = j + 1;
				right = n - 1;
				while (left < right) {
					leftItem = nums[left];
					rightItem = nums[right];
					sum = nums[i] + nums[j] + leftItem + rightItem;
					if (sum == target) {
						answer.add(List.of(nums[i], nums[j], leftItem, rightItem));
						//increasing left and skipping duplicates from the left
						while (left < n && nums[left] == leftItem) {
							left++;
						}
						//decreasing right and skipping duplicates from the right
						while (right > j && nums[right] == rightItem) {
							right--;
						}
					} else if (sum < target) {
						//increasing left and skipping duplicates from the left
						while (left < n && nums[left] == leftItem) {
							left++;
						}
					} else {
						//decreasing right and skipping duplicates from the right
						while (right > j && nums[right] == rightItem) {
							right--;
						}
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static void type1() {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		int n = nums.length, low, high, mid;
		long target_;
		HashSet<FourPoint> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					target_ = (long) target - (long) nums[i] - (long) nums[j] - (long) nums[k];
					low = k + 1;
					high = n - 1;
					while (low <= high) {
						mid = low + (high - low) / 2;
						if (nums[mid] == target_) {
							set.add(new FourPoint(nums[i], nums[j], nums[k], nums[mid]));
							break;
						} else if (nums[mid] < target_) {
							low = mid + 1;
						} else {
							high = mid - 1;
						}
					}
				}
			}
		}
		List<List<Integer>> answer = set.parallelStream().map(FourPoint::list).collect(Collectors.toList());
		System.out.println(answer);
	}

	private static class FourPoint {
		private int x1;
		private int x2;
		private int x3;
		private int x4;

		public FourPoint(int x1, int x2, int x3, int x4) {
			this.x1 = x1;
			this.x2 = x2;
			this.x3 = x3;
			this.x4 = x4;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x1;
			result = prime * result + x2;
			result = prime * result + x3;
			result = prime * result + x4;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FourPoint other = (FourPoint) obj;
			if (x1 != other.x1)
				return false;
			if (x2 != other.x2)
				return false;
			if (x3 != other.x3)
				return false;
			if (x4 != other.x4)
				return false;
			return true;
		}

		public List<Integer> list() {
			return List.of(x1, x2, x3, x4);
		}
	}

}

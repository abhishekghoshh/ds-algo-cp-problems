package com.ds.array;

import com.util.ArrayUtil;

import java.util.*;

/*
 * Problem link :
 * https://leetcode.com/problems/3sum/
 * https://www.codingninjas.com/studio/problems/three-sum_6922132
 * https://www.codingninjas.com/codestudio/problems/893028
 *
 * Solution link :
 * https://www.youtube.com/watch?v=DhFh8Kw7ymk
 * https://www.youtube.com/watch?v=onLoX6Nhvmg&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=42
 *
 * https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
 * */
public class ThreeSum {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	private static void type4() {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> answer = getCustomList(nums);
		System.out.println(answer);
	}

	public static List<List<Integer>> getCustomList(int[] nums) {
		return new AbstractList<>() {
			private List<List<Integer>> ans;

			@Override
			public List<Integer> get(int index) {
				init();
				return ans.get(index);
			}

			@Override
			public int size() {
				init();
				return ans.size();
			}

			private void init() {
				if (ans != null) return;
				ans = new ArrayList<>();
				if (nums == null || nums.length < 3) return;
				Arrays.sort(nums);
				int n = nums.length;
				for (int i = n - 1; i > 1; i--) {
					int t = nums[i];
					if (i != n - 1 && t == nums[i + 1]) continue;
					int l = 0;
					int r = i - 1;
					while (l < r) {
						int f = nums[l];
						if (l != 0 && nums[l - 1] == f) {
							l++;
							continue;
						}
						int s = nums[r];
						if (r != i - 1 && s == nums[r + 1]) {
							r--;
							continue;
						}
						int sum = f + s + t;
						if (sum == 0) {
							ans.add(Arrays.asList(f, s, t));
							l++;
							r--;
						} else if (sum < 0) {
							l++;
						} else {
							r--;
						}
					}
				}
			}
		};
	}

	public static void type3() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> answer = new LinkedList<>();
		// If nums.length < 3, directly return
		if (nums.length < 3) return;
		// Count all positive, negative, zeroes, maximum, and minimum O(n)
		int positiveCount = 0, negativeCount = 0, zeroCount = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num > 0) positiveCount++;
			else if (num < 0) negativeCount++;
			else zeroCount++;
			if (min > num) min = num;
			if (max < num) max = num;
		}
		// Zero solution added
		if (zeroCount > 2) answer.add(Arrays.asList(0, 0, 0));
		// return if all positives or all negatives
		if (positiveCount == 0 || negativeCount == 0) return;
		if (max + 2 * min > 0)
			max = -2 * min; // Upper-bound
		if (min + 2 * max < 0)
			min = -2 * max; // Lower-bound
		// Bucket set
		int[] counts = new int[max - min + 1];
		// Negative set
		int[] negative = new int[negativeCount];
		// Positive set
		int[] positive = new int[positiveCount];
		negativeCount = positiveCount = 0;
		for (int n : nums) {
			if (n < min || n > max)
				continue;
			if (counts[n - min]++ == 0) // HashMap(index, numberOfTimesExists)
				if (n > 0)
					positive[positiveCount++] = n; // HashSet(IndexOfPositiveIndex)
				else if (n < 0)
					negative[negativeCount++] = n; // HashSet(IndexOfNegativeIndex)
		}
		// Sort positive & negative set
		Arrays.sort(positive, 0, positiveCount--);
		Arrays.sort(negative, 0, negativeCount--);
		int positivePosition = 0;
		for (; negativeCount >= 0 && positiveCount >= 0; negativeCount--) {
			// current a lower int from the negative set
			int left = negative[negativeCount];
			// Bound of higher int
			int from = Arrays.binarySearch(positive, positivePosition, positiveCount, (-left) >> 1); // lower bound of
			// higher int
			int to = Arrays.binarySearch(positive, positivePosition, positiveCount, (-left) << 1); // higher bound of
			// higher int
			if (from < 0)
				from = Math.max(0, -from - 1); // Get where the lower-bound of higher int WOULD be if not found
			if (to < 0)
				to = Math.min(positiveCount, -to - 1); // Get where the higher-bound of higher int WOULD be if not found
			// Update lower-bound of higher int
			// Since negative one is sorted in the ascending-order
			positivePosition = from;
			for (int j = to; j >= from; j--) {
				// Get mid and max from the positive from 'from' to 'to'
				int right = positive[j];
				int mid = -left - right;
				if (mid > right)
					break;
				if ((mid >= left && counts[mid - min] > 0) && // when (mid is on the left-side of left) and (mid exists)
						(left != mid || counts[left - min] >= 2) && // when (left is not mid) or (there exists 2+ values of left)
						(right != mid || counts[right - min] >= 2)) // when (right is not mid) or (there exists 2+ values of right)
					// Add the triplets
					answer.add(Arrays.asList(left, mid, right));
			}
		}
		System.out.println(answer);
	}

	// two pointer approach
	// time complexity O(n*log(n)) + O(n^2)
	// space complexity O(1)
	private static void type2() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int n = nums.length, left, right, leftItem, rightItem;
		long sum;
		List<List<Integer>> answer = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < n - 2; i++) {
			// ignore duplicates
			if (i > 0 && nums[i - 1] == nums[i])
				continue;
			// ignore i because num[i] is too small as num[n-2] and num[n-1]
			// are the highest number in that array
			// and num[i] is not capable to generate 0 even with the highest of numbers on that array
			if (nums[i] + nums[n - 2] + nums[n - 1] < 0)
				continue;
			// breaks the loop because there will be no answer after this i
			if (nums[i] + nums[i + 1] + nums[i + 2] > 0)
				break;
			left = i + 1;
			right = n - 1;
			while (left < right) {
				leftItem = nums[left];
				rightItem = nums[right];
				sum = (long) nums[i] + leftItem + rightItem;
				if (sum == 0) {
					answer.add(List.of(nums[i], leftItem, rightItem));
					// finding the next start and skipping the duplicates
					while (left < n && nums[left] == leftItem)
						left++;
					// find the next end skipping duplicates
					while (right > i && nums[right] == rightItem)
						right--;
				} else if (sum < 0) {
					// finding the next start and skipping the duplicates
					while (left < n && nums[left] == leftItem)
						left++;
				} else {
					// find the next end skipping duplicates
					while (right > i && nums[right] == rightItem)
						right--;
				}
			}
		}
		System.out.println(answer);
	}

	// brute force approach
	// answer will contain duplicate
	// to remove duplicates again we have to use a set
	// time complexity O(n^3)
	private static void type1() {
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		int n = nums.length;
		List<List<Integer>> answer = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if ((long) nums[i] + nums[j] + nums[k] == 0) {
						int lowest = ArrayUtil.minN(nums[i], nums[j], nums[k]);
						int highest = ArrayUtil.maxN(nums[i], nums[j], nums[k]);
						int middle = -highest - lowest;
						String id = lowest + "-" + middle + "-" + highest;
						if (!set.contains(id)) {
							set.add(id);
							answer.add(List.of(lowest, middle, highest));
						}

					}
				}
			}
		}
		System.out.println(answer);
	}

}

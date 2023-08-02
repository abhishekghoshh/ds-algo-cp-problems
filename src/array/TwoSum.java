package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/pair-sum_697295?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/two-sum/
 * 
 * Solution link : https://www.youtube.com/watch?v=dRUpbt8vHpo&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=3
 * 
 * 
 * A reverse pair is a pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
 * */

/*
 * Given an array of integers nums and an integer target, return indices of the
 * two numbers such that they add up to target. You may assume that each input
 * would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	private static void type5() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] answer = { -1, -1 };
		
		Set<Integer> set = new HashSet<>();
        int i=0;
        while(i<nums.length && !set.contains(target-nums[i])){
            set.add(nums[i++]);
        }
        System.out.println(set);
        System.out.println(i);
        for(int j=0;j<nums.length;j++){
            if(nums[i]+nums[j]==target) {
            	answer[0]=j;
            	answer[1]=i;
            }
        }
		System.out.println(String.format("indexes are %d,%d", answer[0], answer[1]));
	}

	// two pointer technique
	// time complexity O(n*log(n)) + O(n)
	// space complexity O(1)
	private static void type4() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		Arrays.sort(nums);
		int[] answer = { -1, -1 };
		int low = 0, high = nums.length - 1;
		while (low < high) {
			if (nums[low] + nums[high] == target) {
				answer[0] = low;
				answer[1] = high;
				break;
			} else if (nums[low] + nums[high] < target) {
				low++;
			} else {
				high--;
			}
		}
		System.out.println(String.format("indexes are %d,%d", answer[0], answer[1]));
	}

	// binary search approach
	// time complexity O(n*log(n)) + O(n*log(n))
	// space complexity O(1)
	private static void type3() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9, target_, n = nums.length, low, high, mid;
		Arrays.sort(nums);
		int[] answer = null;
		for (int i = 0; i < n; i++) {
			target_ = target - nums[i];
			low = i + 1;
			high = n - 1;
			while (low <= high) {
				mid = low + (high - low) / 2;
				if (nums[mid] == target_) {
					answer = new int[] { i, mid };
					break;
				} else if (nums[mid] < target_) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			if (null != answer) {
				break;
			}
		}
		System.out.println(String.format("indexes are %d,%d", answer[0], answer[1]));
	}

	// hashmap reminder approach
	// Time complexity O(n)
	// space complexity O(n)
	private static void type2() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int length = nums.length, diff;
		int[] answer = { -1, -1 };
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			diff = target - nums[i];
			if (map.containsKey(diff)) {
				answer[0] = map.get(diff);
				answer[1] = i;
			} else {
				map.put(nums[i], i);
			}
		}
		System.out.println(String.format("indexes are %d,%d", answer[0], answer[1]));
	}

	// Time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int length = nums.length;
		int[] answer = { -1, -1 };
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] + nums[j] == target) {
					answer[0] = i;
					answer[1] = j;
					break;
				}
			}
			if (answer[0] != -1) {
				break;
			}
		}
		System.out.println(String.format("indexes are %d,%d", answer[0], answer[1]));
	}
}

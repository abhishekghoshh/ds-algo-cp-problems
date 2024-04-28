package com.problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://leetcode.com/problems/fruit-into-baskets/
 * https://www.codingninjas.com/studio/problems/fruits-and-baskets_985356
 * 
 * Solution:
 * Aditya Verma : https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
 * 
 */

public class FruitIntoBaskets {
	// You are visiting a farm that has a single row of fruit trees arranged from
	// left to right. The trees are represented by an integer array fruits where
	// fruits[i] is the type of fruit the ith tree produces.
	// You want to collect as much fruit as possible. However, the owner has some
	// strict rules that you must follow:
	// You only have two baskets, and each basket can only hold a single type of
	// fruit. There is no limit on the amount of fruit each basket can hold.
	// Starting from any tree of your choice, you must pick exactly one fruit from
	// every tree (including the start tree) while moving to the right. The picked
	// fruits must fit in one of your baskets.
	// Once you reach a tree with fruit that cannot fit in your baskets, you must
	// stop.
	// Given the integer array fruits, return the maximum number of fruits you can
	// pick.
	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
		type6();
	}

	// TODO best possible solution, same as type5 just it is less complicated to understand
	// easy to understand and implement
	// we have 3 cases
	// current fruit is exactly prev type of fruit
	// current fruit is previous to previous type of fruit
	// current fruit is a completely new fruit
	// we will take two pointer
	// one for previous another for previous to previous fruit
	// also we will store the previous fruit count
	// if there is a new type of fruit then we will set that count to 1
	// because the current fruit will become my new prev fruit
	// we will change the pointers accordingly
	private static void type6() {
		int[] fruits = {6, 2, 1, 1, 3, 6, 6};
		int max = 0;
		int curMax = 0;
		int prev = -1;
		int prev2 = -1;
		int prevContinuousCount = 0;
		for (int fruit : fruits) {
			if (fruit == prev) {
				curMax++;
				prevContinuousCount++;
			} else {
				if (fruit == prev2) curMax++;
				else curMax = prevContinuousCount + 1;
				prevContinuousCount = 1;
				prev2 = prev;
				prev = fruit;
			}
			max = Math.max(max, curMax);
		}
		System.out.println(max);
	}

	// TODO best possible solution in leetcode
	private static void type5() {
		int[] fruits = {6, 2, 1, 1, 3, 6, 6};
		int max = 0;
		int curMax = 0;
		int prev = -1;
		int prev2 = -1;
		int prevCount = 0;
		for (int fruit : fruits) {
			if (fruit == prev || fruit == prev2) {
				curMax++;
			} else {
				max = Math.max(max, curMax);
				curMax = prevCount + 1;
			}
			if (fruit == prev) {
				prevCount++;
			} else {
				prevCount = 1;
				prev2 = prev;
				prev = fruit;
			}
		}
		max = Math.max(max, curMax);
		System.out.println(max);
	}

	// TODO best possible solution I came up with
	private static void type4() {
		int[] fruits = {6, 2, 1, 1, 3, 6, 6};
		int k = 2;
		int n = fruits.length;
		int left = 0, max = 0;
		int types = 0;
		int[] freq = new int[100001];
		for (int right = 0; right < n; right++) {
			int fruit = fruits[right];
			if (freq[fruit] == 0) types++;
			freq[fruit]++;
			while (left < n && types > k) {
				int fruitToBeRemoved = fruits[left++];
				freq[fruitToBeRemoved]--;
				if (freq[fruitToBeRemoved] == 0) types--;
			}
			max = Math.max(max, right - left + 1);
		}
		System.out.println(max);
	}

	private static void type3() {
		int[] fruits = {6, 2, 1, 1, 3, 6, 6};
		int k = 2;
		int n = fruits.length;
		int left = 0, max = 0;
		int types = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int right = 0; right < n; right++) {
			int fruit = fruits[right];
			if (!map.containsKey(fruit) || map.get(fruit) == 0) {
				map.put(fruit, 1);
				types++;
			} else map.put(fruit, map.get(fruit) + 1);
			while (left < n && types > k) {
				int fruitToBeRemoved = fruits[left++];
				int fruitToBeRemovedCount = map.get(fruitToBeRemoved);
				map.put(fruitToBeRemoved, fruitToBeRemovedCount - 1);
				if (fruitToBeRemovedCount == 1) types--;
			}
			max = Math.max(max, right - left + 1);
		}
		System.out.println(max);
	}

	// sliding window
	private static void type2() {
		int[] fruits = { 1, 2, 3, 2, 2 };
		int k = 2;
		int n = fruits.length;
		int left = 0, right = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int types = 0;
		int fruitsSize = 0;
		while (right < n && types < k) {
			int fruit = fruits[right++];
			if (!map.containsKey(fruit)) {
				map.put(fruit, 1);
				types++;
			} else map.put(fruit, map.get(fruit) + 1);
		}
//		if (right == n) return n;
		max = right;
		while (right < n) {
			int fruit = fruits[right++];
			if (!map.containsKey(fruit)) {
				map.put(fruit, 0);
			}
			map.put(fruit, map.get(fruit) + 1);
			while (map.keySet().size() != k) {
				int prev = fruits[left];
				int c = map.get(prev);
				if (c == 1) {
					map.remove(prev);
				} else {
					map.put(prev, c - 1);
				}
				left++;
			}
			max = Math.max((right - left), max);
		}
		System.out.println(max);
	}

	// sliding window
	private static void type1() {
		char[] toys = { 'a', 'b', 'a', 'a', 'c', 'c', 'a', 'b' };
		int k = 2;
		int n = toys.length;
		int left = 0, right = 0, max = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (right < n && map.keySet().size() < k) {
			char toy = toys[right++];
			if (!map.containsKey(toy)) {
				map.put(toy, 0);
			}
			map.put(toy, map.get(toy) + 1);
		}
		if (right == n)
			return;
		max = right;
		while (right < n) {
			char toy = toys[right++];
			if (!map.containsKey(toy)) {
				map.put(toy, 0);
			}
			map.put(toy, map.get(toy) + 1);
			while (map.keySet().size() != k) {
				char prev = toys[left];
				int c = map.get(prev);
				if (c == 1) {
					map.remove(prev);
				} else {
					map.put(prev, c - 1);
				}
				left++;
			}
			max = Math.max((right - left), max);
		}
		System.out.println(max);
	}

}

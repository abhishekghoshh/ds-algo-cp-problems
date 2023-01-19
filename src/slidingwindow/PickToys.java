package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://leetcode.com/problems/fruit-into-baskets/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
 * 
 */

public class PickToys {
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
	}

	// sliding window
	private static void type2() {
		int[] fruits = { 1, 2, 3, 2, 2 };
		int k = 2;
		int n = fruits.length;
		int left = 0, right = 0, max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		while (right < n && map.keySet().size() < k) {
			int fruit = fruits[right++];
			if (!map.containsKey(fruit)) {
				map.put(fruit, 0);
			}
			map.put(fruit, map.get(fruit) + 1);
		}
		if (right == n)
			return;
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
			max = (right - left) > max ? (right - left) : max;
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
			max = (right - left) > max ? (right - left) : max;
		}
		System.out.println(max);
	}

}

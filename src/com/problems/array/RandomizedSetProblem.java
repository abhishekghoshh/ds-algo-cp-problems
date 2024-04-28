package com.problems.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/*
 * Problem link :
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 * 
 * Solution link :
 *
 *
 */
public class RandomizedSetProblem {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		RandomizedSet randomizedSet = new RandomizedSet();
		randomizedSet.insert(1);
		randomizedSet.insert(10);
		randomizedSet.insert(20);
		randomizedSet.insert(30);
		for (int i = 0; i < 10; i++) System.out.println(randomizedSet.getRandom());
	}

	static class RandomizedSet {
		Map<Integer, Integer> cache;
		int[] arr;
		int size = 0;
		Random random;

		public RandomizedSet() {
			arr = new int[100001];
			cache = new HashMap<>();
			random = new Random();
		}

		public boolean insert(int val) {
			if (isPresent(val)) return false;
			cache.put(val, size);
			arr[size++] = val;
			return true;
		}

		private boolean isPresent(int val) {
			return cache.containsKey(val) && (-1 != cache.get(val));
		}

		public boolean remove(int val) {
			if (!isPresent(val)) return false;
			int index = cache.get(val);
			cache.put(arr[size - 1], index);
			swap(arr, size - 1, index);
			cache.put(val, -1);
			size--;
			return true;
		}

		private void swap(int[] arr, int i, int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		public int getRandom() {
			return arr[random.nextInt(size)];
		}
	}
}

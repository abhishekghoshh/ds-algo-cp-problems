package com.ds.string;

import java.util.*;

/*
 * Problem link :
 * https://leetcode.com/problems/group-anagrams/
 * 
 * 
 * Solution link
 * 
 * 
 * */
public class GroupAnagrams {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static final int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

	private static void type3() {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Map<Long, List<String>> map = new HashMap<>();
		Long hash;
		for (String str : strs) {
			hash = hashGen(str.toCharArray());
			if (!map.containsKey(hash)) map.put(hash, new ArrayList<>());
			map.get(hash).add(str);
		}
		List<List<String>> groupAnagrams = new ArrayList<>(map.values());
		System.out.println(groupAnagrams);
	}

	private static long hashGen(char[] arr) {
		long answer = 1L;
		for (char ch : arr) answer = (answer * primes[ch - 'a']) % 10000000000L;
		return answer;
	}
	private static void type2() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int[] hash = new int[26];
			char[] arr = str.toCharArray();
			for (char ch : arr) hash[ch - 'a']++;
			String key = Arrays.toString(hash);
			if (!map.containsKey(key)) map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		System.out.println(new ArrayList<>(map.values()));
	}

	private static void type1() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String sortedStr = new String(chs);
			if (!map.containsKey(sortedStr)) map.put(sortedStr, new ArrayList<>());
			map.get(sortedStr).add(str);
		}
		System.out.println(new ArrayList<>(map.values()));
	}

}

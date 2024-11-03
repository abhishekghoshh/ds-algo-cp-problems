package com.problems.string;

import java.util.*;

/*
 * Problem link :
 * https://leetcode.com/problems/group-anagrams/
 * https://neetcode.io/problems/anagram-groups
 * 
 * Solution link
 * 
 * 
 * */

/*
 * Tags:
 * Array, Hashing
 * */
public class GroupAnagrams {


	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}


	private static final int[] primes = new int[]{
			2, 3, 5, 7, 11,
			13, 17, 19, 23, 29,
			31, 37, 41, 43, 47,
			53, 59, 61, 67, 71,
			73, 79, 83, 89, 97, 101
	};
	public static final long MOD = 10000000000L;

	// we will create a hash function from the characters of the array
	// we will map the characters to the first 26 prime numbers
	private static void type3() {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> groupAnagrams = groupAnagrams3(strs);
		System.out.println(groupAnagrams);
	}

	private static List<List<String>> groupAnagrams3(String[] strs) {
		Map<Long, List<String>> map = new HashMap<>();
		for (String str : strs) {
			long hash = createHash(str);
			if (!map.containsKey(hash))
				map.put(hash, new ArrayList<>());
			map.get(hash).add(str);
		}
		return new ArrayList<>(map.values());
	}

	private static long createHash(String s) {
		long answer = 1L;
		for (char ch : s.toCharArray())
			answer = (answer * primes[ch - 'a']) % MOD;
		return answer;
	}

	// we will create a custom hash function from the frequency of the characters
	private static void type2() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> ans = groupAnagrams2(strs);
		System.out.println(ans);
	}

	private static List<List<String>> groupAnagrams2(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			int[] freq = new int[26];
			for (char ch : str.toCharArray()) freq[ch - 'a']++;
			String key = createKey(freq);
			if (!map.containsKey(key))
				map.put(key, new ArrayList<>());
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

	private static String createKey(int[] freq) {
		StringBuilder sb = new StringBuilder();
		for (int f : freq) sb.append(f);
		return sb.toString();
	}

	// brute force approach
	private static void type1() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> ans = groupAnagrams1(strs);
		System.out.println(ans);
	}

	private static List<List<String>> groupAnagrams1(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String sortedStr = new String(chs);
			if (!map.containsKey(sortedStr))
				map.put(sortedStr, new ArrayList<>());
			map.get(sortedStr).add(str);
		}
		return new ArrayList<>(map.values());
	}

}

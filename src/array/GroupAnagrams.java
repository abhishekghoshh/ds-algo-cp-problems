package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem link :
 * https://leetcode.com/problems/group-anagrams/
 * 
 * Solution link
 * 
 * 
 * */
public class GroupAnagrams {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {

	}

	private static void type1() {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chs = str.toCharArray();
			Arrays.sort(chs);
			String sortedStr = new String(chs);
			if (!map.containsKey(sortedStr))
				map.put(sortedStr, new ArrayList<>());
			map.get(sortedStr).add(str);
		}
		List<List<String>> answer = new ArrayList<>(map.values());
		System.out.println(answer);
	}

}

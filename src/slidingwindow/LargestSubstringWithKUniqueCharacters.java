package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:
 * https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 
 * Solution:
 * https://www.youtube.com/watch?v=Lav6St0W_pQ&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=10
 * */
public class LargestSubstringWithKUniqueCharacters {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// sliding window
	private static void type2() {
		String s = "aabacbebebe";
		int k = 2;
		int left = 0, right = 0, n = s.length();
		String max = "";
		Map<Character, Integer> map = new HashMap<>();
		// we are going while we find our find window of k
		while (right < n && map.keySet().size() < k) {
			char ch = s.charAt(right++);
			if (!map.containsKey(ch)) {
				map.put(ch, 0);
			}
			map.put(ch, map.get(ch) + 1);
		}
		if (right == n && map.keySet().size() < k) {
			return;
		}
		// calculating answer for the first window
		max = (right - left) > max.length() ? s.substring(left, right) : max;
		while (right < n) {
			char ch = s.charAt(right++);
			if (!map.containsKey(ch)) {
				map.put(ch, 0); 
			}
			map.put(ch, map.get(ch) + 1);
			
			if (map.keySet().size() > k) {
				while (map.keySet().size() != k) {
					char leftChar = s.charAt(left);
					int leftCharCount = map.get(leftChar);
					if (leftCharCount > 1) {
						map.put(leftChar, leftCharCount - 1);
					} else {
						map.remove(leftChar);
					}
					left = left + 1;
				}
			}
			// calculating answer for the current window
			max = (right - left) > max.length() ? s.substring(left, right) : max;
		}
		System.out.println(max);
	}

	// brute force
	private static void type1() {

	}

}

package problems.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link:

 * 
 * Solution:
 * https://www.youtube.com/watch?v=seOKHXB_w74&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=12
 * */

public class PickToys {

	public static void main(String[] args) {
		type1();
	}

	//
	private static void type1() {
		char[] toys = { 'a', 'b', 'a', 'a', 'c', 'c', 'a', 'b' };
		int k = 2;
		int n = toys.length;
		int left = 0, right = 0, max = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (map.keySet().size() < k) {
			char toy = toys[right++];
			if (!map.containsKey(toy)) {
				map.put(toy, 0);
			}
			map.put(toy, map.get(toy) + 1);
		}
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

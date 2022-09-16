package problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		String string = "ab";
		List<String> permutations = new ArrayList<>();
		computePermutations(string, "", permutations);
		System.out.println(permutations);
	}

	private static void computePermutations(String string, String pivot, List<String> permutations) {
		if (null == string || string.isEmpty()) {
			permutations.add(pivot);
			return;
		}
		boolean[] map = new boolean[26];
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (!map[ch - 'a']) {
				String remainingString = string.substring(0, i) + string.substring(i + 1);
				computePermutations(remainingString, pivot + ch, permutations);
			}
			map[string.charAt(i) - 'a'] = true;
		}
	}
}

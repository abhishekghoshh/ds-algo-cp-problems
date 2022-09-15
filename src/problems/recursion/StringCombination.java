package problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringCombination {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		String str = "abc";
		List<String> answer = new ArrayList<>();
		computeCombinations(new StringBuilder(""), 0, str, answer);
		System.out.println(answer);
	}

	private static void computeCombinations(StringBuilder previous, int start, String string, List<String> answer) {
		if (start == string.length()) {
			answer.add(previous.toString());
			return;
		}
		computeCombinations(previous, start + 1, string, answer);
		computeCombinations(previous.append(string.charAt(start)), start + 1, string, answer);
		previous.deleteCharAt(previous.length() - 1);
	}

}

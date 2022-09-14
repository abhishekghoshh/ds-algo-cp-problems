package problems.recursion;

import java.util.ArrayList;
import java.util.List;

public class StringCombination {
	public static void main(String[] args) {
		String str = "abcdefghieklmnopqr";

		/*
		 * List<String> stringCombinations1 = computeCombinations(0,str);
		 * System.out.println(stringCombinations1);
		 * 
		 * List<String> stringCombinations2 = new ArrayList<>();
		 * computeCombinations("",0,str,stringCombinations2);
		 * System.out.println(stringCombinations2);
		 */

		System.out.println(TimeCheck.timeTook(() -> {
			computeCombinations(0, str);
			;
		}));
		System.out.println(TimeCheck.timeTook(() -> {
			List<String> answer = new ArrayList<>();
			computeCombinations("", 0, str, answer);
		}));
	}

	private static List<String> computeCombinations(int start, String str) {
		List<String> newStringCombinations = new ArrayList<>();
		if (null == str || str.isEmpty() || start == str.length()) {
			newStringCombinations.add("");
			return newStringCombinations;
		}
		List<String> computedCombinations = computeCombinations(start + 1, str);
		for (String computedStr : computedCombinations) {
			newStringCombinations.add(computedStr);
			newStringCombinations.add(str.charAt(start) + computedStr);
		}
		return newStringCombinations;
	}

	// effcient
	private static void computeCombinations(String prev, int start, String str, List<String> answer) {
		if (start == str.length()) {
			answer.add(prev);
			return;
		}
		computeCombinations(prev, start + 1, str, answer);
		computeCombinations(prev + str.charAt(start), start + 1, str, answer);
	}

}

package problems.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerSetOfString {

	// Note
	// Substring is where all the elements are in order and continuous
	// subsequence is where all the elements are in order but not continuous
	// subset is where all the elements are not in order and not continuous
	public static void main(String[] args) {
		type1();
		type2();
	}

	// non unique elements with set
	// extra computation needed
	private static void type2() {
		String str = "aaa";
		Set<String> answer = new HashSet<>();
		powersetWithSet(new StringBuilder(""), 0, str, answer);
		System.out.println(answer);
	}

	private static void powersetWithSet(StringBuilder previous, int current, String actualString, Set<String> answer) {
		if (current == actualString.length()) {
			answer.add(previous.toString());
			return;
		}
		// here we are not choosing it to be a part of the answer
		powersetWithSet(previous, current + 1, actualString, answer);
		// here we are choosing the element to a part of the answer
		powersetWithSet(previous.append(actualString.charAt(current)), current + 1, actualString, answer);
		// as previous is a StringBuilder so we are changing the actual object so we
		// need to delete the last character which we have added previously
		previous.deleteCharAt(previous.length() - 1);
	}

	// only unique characters
	private static void type1() {
		String str = "abc";
		List<String> answer = new ArrayList<>();
		powerset(new StringBuilder(""), 0, str, answer);
		System.out.println(answer);
	}

	// we have two option either to choose it or not
	private static void powerset(StringBuilder previous, int current, String actualString, List<String> answer) {
		if (current == actualString.length()) {
			answer.add(previous.toString());
			return;
		}
		// here we are not choosing it to be a part of the answer
		powerset(previous, current + 1, actualString, answer);
		// here we are choosing the element to a part of the answer
		powerset(previous.append(actualString.charAt(current)), current + 1, actualString, answer);
		// as previous is a StringBuilder so we are changing the actual object so we
		// need to delete the last character which we have added previously
		previous.deleteCharAt(previous.length() - 1);
	}

}

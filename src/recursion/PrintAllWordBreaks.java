package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/983635
 *
 * Solution link:
 * 
 * */
public class PrintAllWordBreaks {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// type2 and type3 is same
	// just that we have used string builder here
	private static void type3() {
		String s = "godisnowherenowhere";
		List<String> dictionary = List.of("god", "is", "now", "no", "where", "here");
		Set<String> dictionarySet = new HashSet<>(dictionary);
		List<String> answer = new ArrayList<>();
		compute(s, 0, dictionarySet, answer, new StringBuilder());
		System.out.println(answer);
	}

	private static void compute(String s, int start, Set<String> dictionarySet, List<String> answer, StringBuilder prev) {
		int right = start + 1;
		while (right <= s.length()) {
			String word = s.substring(start, right);
			if (dictionarySet.contains(word)) {
				if (right == s.length()) {
					answer.add(prev.append(word).toString());
					prev.delete(prev.length() - word.length(), prev.length());
				} else {
					compute(s, right, dictionarySet, answer, prev.append(word).append(" "));
					prev.deleteCharAt(prev.length() - 1);
					prev.delete(prev.length() - word.length(), prev.length());
				}
			}
			right++;
		}
	}

	private static void type2() {
		String s = "godisnowherenowhere";
		List<String> dictionary = List.of("god", "is", "now", "no", "where", "here");
		Set<String> dictionarySet = new HashSet<>(dictionary);
		List<String> answer = new ArrayList<>();
		compute(s, 0, dictionarySet, answer, "");
		System.out.println(answer);
	}

	private static void compute(String s, int start, Set<String> dictionarySet, List<String> answer, String prev) {
		// we are using two pointers
		int right = start + 1;
		while (right <= s.length()) {
			String word = s.substring(start, right);
			// if the word is in the dictionary, then we have two options
			// either to include that word and check words in remaining part else we can
			// wait for a bigger word
			if (dictionarySet.contains(word)) {
				if (right == s.length()) {
					answer.add(prev + word);
				} else {
					compute(s, right, dictionarySet, answer, prev + word + " ");
				}
			}
			right++;
		}
	}

	// TODO study later
	private static void type1() {
		String s = "godisnowherenowhere";
		List<String> dictionary = List.of("god", "is", "now", "no", "where", "here");
		Set<String> dictSet = new HashSet<>(dictionary);
		List<String> answer = wordBreakHelper(s, 0, dictSet, s.length());
		System.out.println(answer);
	}

	public static ArrayList<String> wordBreakHelper(String s, int idx, Set<String> dictSet, int size) {
		// Base Condition
		if (idx == size) {
			ArrayList<String> temp = new ArrayList<>();
			temp.add("");
			return temp;
		}
		ArrayList<String> subPart;
		ArrayList<String> completePart = new ArrayList<>();
		String word = "";
		// Start exploring the sentence from the index until we wouldn't find 'j' such
		// that substring [index,j] exists in the dictionary as a word
		for (int j = idx; j < size; j++) {
			word += s.charAt(j);
			if (!dictSet.contains(word)) continue;
			// Get the answer for rest of sentence from 'j' to s.size()
			subPart = wordBreakHelper(s, j + 1, dictSet, size);
			// Append "word" with all the answer that we got
			for (int i = 0; i < subPart.size(); i++) {
				if (!subPart.get(i).isEmpty()) {
					String temp = word;
					temp += " ";
					temp += subPart.get(i);
					subPart.set(i, temp);
				} else {
					subPart.set(i, word);
				}
			}
			completePart.addAll(subPart);
		}
		return completePart;
	}

}

package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * Problem link :
 * https://leetcode.com/problems/word-ladder-ii/
 * https://practice.geeksforgeeks.org/problems/word-ladder-ii/1
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=DREutrv2XD0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=30
 * https://www.youtube.com/watch?v=AD4SFl7tu7I&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=31
 * 
 * 
 * https://takeuforward.org/graph/g-30-word-ladder-ii/
 * https://takeuforward.org/graph/word-ladder-ii-optimised-approach-g-31/
 */
public class WordLadder2 {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String beginWord = "hit";
		String endWord = "cog";
//		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
//		Set<String> wordSet = Arrays.stream(wordList).collect(Collectors.toSet());
		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

		Map<String, List<String>> map = new HashMap<>();

		// this helper method will group all the similar words
		// like dog cog bog and the key will be #og
		for (String word : wordList)
			groupWords(word, map);

		int ways = 0;
		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		int level = 1;
		while (!q.isEmpty()) {
			level++;
			int size = q.size();
			List<String> toBeVisitedWords = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				String word = q.poll();
				char[] arr = word.toCharArray();
				for (int j = 0; j < word.length(); j++) {
					char ch = arr[j];
					arr[j] = '#';
					List<String> group = map.get(new String(arr));
					arr[j] = ch;
					if (null == group)
						continue;
					for (String transformedWord : group) {
						if (!visited.contains(transformedWord)) {
							if (transformedWord.equalsIgnoreCase(endWord))
								ways++;
							q.add(transformedWord);
							toBeVisitedWords.add(transformedWord);
						}
					}
				}
			}
			for (String word : toBeVisitedWords)
				visited.add(word);
			if (ways > 0)
				break;
		}
		System.out.println(level + " " + ways);

	}

	public static void groupWords(String word, Map<String, List<String>> map) {
		char[] arr = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			char ch = arr[i];
			arr[i] = '#';
			String currKey = new String(arr);
			arr[i] = ch;
			if (!map.containsKey(currKey)) {
				map.put(currKey, new ArrayList<>());
			}
			map.get(currKey).add(word);
		}
	}

	// we will use same technique as the wordladder1 type2
	// but rather than storing the string only to queue
	// we will store the list of string or the sequence
	// but this answer will only be accepted in geekforgeeks not leetcode
	private static void type1() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

		List<List<String>> answer = new ArrayList<>();

		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.remove(beginWord);

		Queue<List<String>> queue = new LinkedList<>();
		queue.offer(List.of(beginWord));

		while (!queue.isEmpty()) {
			// we will check how many words are in the same level
			int size = queue.size();
			List<String> toBeDeletedWords = new ArrayList<>();
			// then we will loop on that words of same level in queue
			for (int j = 0; j < size; j++) {
				List<String> words = queue.poll();
				String word = words.get(words.size() - 1);
				for (int i = 0; i < word.length(); i++) {
					for (char ch = 'a'; ch <= 'z'; ch++) {
						char replacedCharArray[] = word.toCharArray();
						replacedCharArray[i] = ch;
						String replacedWord = new String(replacedCharArray);
						// check if it exists in the set and push it in the queue.
						if (wordSet.contains(replacedWord)) {
							toBeDeletedWords.add(replacedWord);
							List<String> currentSequence = new ArrayList<>(words);
							currentSequence.add(replacedWord);
							queue.offer(currentSequence);
							if (replacedWord.equalsIgnoreCase(endWord)) {
								answer.add(currentSequence);
							}
						}
					}
				}
			}
			// and at last we may loop through the transformed words which is to be deleted
			for (String word : toBeDeletedWords)
				wordSet.remove(word);
			// if the answer array is not empty that means there is atleast one answer exist
			// so we can stop the loop here
			if (!answer.isEmpty())
				break;
		}

		System.out.println(answer);
	}

}

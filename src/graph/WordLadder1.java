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
 * https://leetcode.com/problems/word-ladder/
 * https://practice.geeksforgeeks.org/problems/word-ladder/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=tRPda0rcf8E&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=29
 * 
 * https://takeuforward.org/graph/word-ladder-i-g-29/
 */
public class WordLadder1 {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// here also we will do bfs
	// but here we use some sort of caching
	// we will one letter different word in the same group
	private static void type3() {
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

		Set<String> visited = new HashSet<>();
		visited.add(beginWord);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String word = queue.poll();
				if (word.equals(endWord)) {
					System.out.println(level);
					return;
				}
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
							queue.add(transformedWord);
							visited.add(transformedWord);
						}
					}
				}
			}
			level++;
		}
		System.out.println(0);
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

	// we will do bfs
	// but here we will do level wise
	// we don't have to store the level here
	// we will pop all the words on each level
	// and after that we will check what are the words can be made from the current
	// words which is on the same level
	// so in while loop if we do the level++ that will be suffice
	private static void type2() {
		String beginWord = "hit";
		String endWord = "cog";
//		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
//		Set<String> wordSet = Arrays.stream(wordList).collect(Collectors.toSet());
		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.remove(beginWord);

		// we will store current string and steps to the queue
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		int level = 1;

		while (!queue.isEmpty()) {
			level++;
			// we will check how many words are in the same level
			int size = queue.size();

//			List<String> toBeDeletedWords = new ArrayList<>();

			// then we will loop on that words of same level in queue
			for (int j = 0; j < size; j++) {
				String word = queue.poll();
				for (int i = 0; i < word.length(); i++) {
					for (char ch = 'a'; ch <= 'z'; ch++) {
						char replacedCharArray[] = word.toCharArray();
						replacedCharArray[i] = ch;
						String replacedWord = new String(replacedCharArray);
						// check if it exists in the set and push it in the queue.
						if (wordSet.contains(replacedWord)) {
							if (replacedWord.equalsIgnoreCase(endWord)) {
								System.out.println(level);
								return;
							}
							// we may not directly delete from the words set
							// because two different word can be transformed into same word
							// like got and not can be changed into hot
							// but if we delete the word hot at the first time when we find it from got
							// then the at the time of changing from hot to not
							// it will not find the hot word in the set
							// but as we are just finding the level not all the possible series
							// so we can directly delete it from the step
							// as we are doing breadth wise, and 2 words at same level transforming into
							// same word, so for both of the word it will be only level+1
							wordSet.remove(replacedWord);
//							toBeDeletedWords.add(replacedWord);
							queue.offer(replacedWord);
						}
					}
				}
			}
			// and at last we may loop through the transformed words which is to be deleted
//			for (String word : toBeDeletedWords)
//				wordSet.remove(word);
		}
		System.out.println(0);
	}

	// we will use bfs
	// we can change a letter of word at a time
	// "hit" -> "hot" -> "dot" -> "dog" -> cog"
	// and the transformed word must be in the word list
	// to search any word in list we will transform the list to set
	// so on each level we will derive all the words that is in the set
	// one we get our final word
	private static void type1() {
		String beginWord = "hit";
		String endWord = "cog";
//		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
//		Set<String> wordSet = Arrays.stream(wordList).collect(Collectors.toSet());
		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.remove(beginWord);

		// we will store current string and steps to the queue
		Queue<Object[]> queue = new LinkedList<>();
		queue.offer(new Object[] { beginWord, 1 });
		int ans = 0;

		while (!queue.isEmpty()) {
			Object[] pair = queue.poll();
			String word = (String) pair[0];
			int steps = (int) pair[1];
			// we return the steps as soon as
			// the first occurrence of targetWord is found.
			if (word.equals(endWord)) {
				ans = steps;
				break;
			}
			// Now, replace each character of ‘word’ with char
			// from a-z then check if ‘word’ exists in wordList.
			for (int i = 0; i < word.length(); i++) {
				for (char ch = 'a'; ch <= 'z'; ch++) {
					char replacedCharArray[] = word.toCharArray();
					replacedCharArray[i] = ch;
					String replacedWord = new String(replacedCharArray);
					// check if it exists in the set and push it in the queue.
					if (wordSet.contains(replacedWord)) {
						wordSet.remove(replacedWord);
						queue.offer(new Object[] { replacedWord, steps + 1 });
					}
				}
			}
		}
		System.out.println(ans);
	}

}

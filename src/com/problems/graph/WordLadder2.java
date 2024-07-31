package com.problems.graph;

import java.util.*;

/*
 * Problem link :
 * https://leetcode.com/problems/word-ladder-ii/
 * https://practice.geeksforgeeks.org/problems/word-ladder-ii/1
 * https://www.naukri.com/code360/problems/shortest-transition-paths_8391015
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=DREutrv2XD0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=30
 * https://takeuforward.org/graph/g-30-word-ladder-ii/
 *
 * https://www.youtube.com/watch?v=AD4SFl7tu7I&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=31
 * https://takeuforward.org/graph/word-ladder-ii-optimised-approach-g-31/
 */
public class WordLadder2 {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	private static void type4() {
	}

	// TODO check the leetcode solution section to fin the best solution
	private static void type3() {
		String beginWord = "a";
		String endWord = "c";
		List<String> wordList = new ArrayList<>(List.of("a", "b", "c"));

		List<List<String>> answer = findLadders3(wordList, beginWord, endWord);
		System.out.println(answer);

	}

	private static List<List<String>> findLadders3(List<String> wordList, String beginWord, String endWord) {
		Map<String, Boolean> visited = new HashMap<>();

		for (String word : wordList) visited.put(word, false);
		if (!visited.containsKey(endWord)) return new ArrayList<>();

		Map<String, List<String>> neighbors = new HashMap<>();

		int len = beginWord.length(), size = wordList.size();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == j) continue;
				addNeighbors(len, wordList.get(i), wordList.get(j), neighbors);
			}
		}
		if (!visited.containsKey(beginWord))
			for (String word : wordList)
				addNeighbors(len, beginWord, word, neighbors);

		Map<String, Integer> levels = new HashMap<>();

		visited.put(beginWord, true);
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		Set<String> currentLevelVisitedWords = new HashSet<>();

		int level = 1;
		levels.put(beginWord, level);

		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			int i = 0;
			while (i < levelSize) {
				i++;
				String word = queue.poll();
				if (!neighbors.containsKey(word)) continue;
				for (String next : neighbors.get(word)) {
					if (visited.get(next)) continue;
					currentLevelVisitedWords.add(next);
					levels.put(next, level + 1);
				}
			}
			for (String word : currentLevelVisitedWords) {
				queue.offer(word);
				visited.put(word, true);
			}
			currentLevelVisitedWords.clear();
			level++;
			if (levels.containsKey(endWord)) break;
		}
		System.out.println(neighbors);
		System.out.println(levels);
		List<List<String>> answer = new ArrayList<>();
		addToAnswer(beginWord, endWord, 1, levels, neighbors, new LinkedList<>(), answer);
		return answer;
	}

	private static void addToAnswer(String word, String endWord, int level, Map<String, Integer> levels,
									Map<String, List<String>> neighbors, LinkedList<String> bucket, List<List<String>> answer) {
		bucket.addLast(word);
		if (word.equals(endWord)) {
			answer.add(new ArrayList<>(bucket));
		} else {
			if (neighbors.containsKey(word))
				for (String next : neighbors.get(word))
					if (levels.containsKey(next) && levels.get(next) == (level + 1))
						addToAnswer(next, endWord, level + 1, levels, neighbors, bucket, answer);
		}
		bucket.removeLast();
	}

	private static void addNeighbors(int len, String w1, String w2, Map<String, List<String>> neighbors) {
		int c1 = 0, c2 = 0;
		for (int k = 0; k < len; k++) {
			char ch1 = w1.charAt(k), ch2 = w2.charAt(k);
			if (ch1 != ch2) c1++;
			if (ch1 == ch2) c2++;
		}
		if (c1 == 1 && c2 == len - 1) {
			if (!neighbors.containsKey(w1)) neighbors.put(w1, new ArrayList<>());
			neighbors.get(w1).add(w2);
		}
	}

	private static void findNeighbors(String word, Map<String, Boolean> visited, Map<String, List<String>> neighbors) {
		char[] arr = word.toCharArray();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			char prev = arr[i];
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch == prev) continue;
				arr[i] = ch;
				String newWord = new String(arr);
				if (visited.containsKey(newWord)) {
					if (!neighbors.containsKey(word)) neighbors.put(word, new ArrayList<>());
					neighbors.get(word).add(newWord);
				}
			}
			arr[i] = prev;
		}
	}


	// todo this will also get TLE in leetcode
	private static void type2() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

		List<List<String>> answer = findLadders2(wordList, beginWord, endWord);
		System.out.println(answer);
	}

	private static List<List<String>> findLadders2(List<String> wordList, String beginWord, String endWord) {
		List<List<String>> answer = new LinkedList<>();
		// rather than maintaining a visited set, we will maintain a set
		// and everytime we encounter any word we will remove that from set
		Set<String> wordSet = new HashSet<>(wordList);
		// if end word is not present, then will return the empty list directly
		if (!wordSet.contains(endWord)) return answer;
		// as we are starting from the beginning word, so we will remove that
		wordSet.remove(beginWord);
		// this helper method will group all the similar words
		// like dog cog bog and the key will be #og
		Map<String, LinkedList<String>> wordsKeyMap = new HashMap<>();
		for (String word : wordList) groupWords(word, wordsKeyMap);

		// we are using a linked list specifically for the fast operation
		Queue<LinkedList<String>> queue = new LinkedList<>();

		LinkedList<String> seq = new LinkedList<>();
		seq.add(beginWord);
		queue.offer(seq);

		LinkedList<String> toBeDeletedWords = new LinkedList<>();

		while (!queue.isEmpty()) {
			// we will go level wise, so we need the current size of the queue
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				seq = queue.poll();
				// we have to change it from the last word of the sequence
				String word = seq.getLast();
				char[] copy = word.toCharArray();
				for (int j = 0; j < copy.length; j++) {
					char oldChar = copy[j];
					copy[j] = '#';
					List<String> wordKeyPair = wordsKeyMap.get(new String(copy));
					copy[j] = oldChar;
					if (null == wordKeyPair) continue;
					for (String newWord : wordKeyPair) {
						// if the end word is not present, then we will skip
						if (!wordSet.contains(newWord)) continue;
						// creating a new seq from the old seq and new word
						LinkedList<String> newSeq = new LinkedList<>(seq);
						newSeq.add(newWord);
						// also adding it to the queue
						queue.offer(newSeq);
						// we are adding these words in the toBeDeleted list, to delete in future
						toBeDeletedWords.add(newWord);
						// if at any level we find the end-word, then we will add that to the answer
						// we know it is the lowest level possible because we are going to the level wise
						if (newWord.equals(endWord)) answer.add(newSeq);
					}
				}
			}
			// and at last we may loop through the transformed words that are to be deleted
			for (String word : toBeDeletedWords) wordSet.remove(word);
			// if the answer array is not empty, that means there is least one answer exist,
			// so we can stop the loop here
			if (!answer.isEmpty()) return answer;
			// again we are clearing the toBeDeletedWords list
			toBeDeletedWords.clear();
		}
		return answer;
	}

	public static void groupWords(String word, Map<String, LinkedList<String>> wordsKeyMap) {
		char[] copy = word.toCharArray();
		for (int i = 0; i < copy.length; i++) {
			char oldChar = copy[i];
			copy[i] = '#';
			String key = new String(copy);
			copy[i] = oldChar;
			if (!wordsKeyMap.containsKey(key)) wordsKeyMap.put(key, new LinkedList<>());
			wordsKeyMap.get(key).add(word);
		}
	}

	// not the most optimized approach,
	// we will use the same technique as the WordLadder1 type2 problem.
	// but rather than storing the string only to queue,
	// we will store the list of string or the sequence,
	// but this answer will only be accepted in geekforgeeks not leetcode
	private static void type1() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
		List<List<String>> answer = findLadders1(wordList, beginWord, endWord);
		System.out.println(answer);
	}

	private static List<List<String>> findLadders1(List<String> wordList, String beginWord, String endWord) {
		// rather than maintaining a visited set, we will maintain a set
		// and everytime we encounter any word we will remove that from set
		Set<String> wordSet = new HashSet<>(wordList);
		// if end word is not present, then will return the empty list directly
		if (!wordSet.contains(endWord)) return new ArrayList<>();

		List<List<String>> answer = new ArrayList<>();
		// as we are starting from the beginning word, so we will remove that
		wordSet.remove(beginWord);

		// we are using a linked list specifically for the fast operation
		Queue<LinkedList<String>> queue = new LinkedList<>();

		LinkedList<String> seq = new LinkedList<>();
		seq.add(beginWord);
		queue.offer(seq);

		LinkedList<String> toBeDeletedWords = new LinkedList<>();

		while (!queue.isEmpty()) {
			// we will check how many words are in the same level
			int size = queue.size();
			// then we will loop on that words of same level in queue
			for (int j = 0; j < size; j++) {
				seq = queue.poll();
				String word = seq.getLast();
				char[] copy = word.toCharArray();
				for (int i = 0; i < copy.length; i++) {
					// saving the current char for future usage
					char oldChar = copy[i];
					for (char ch = 'a'; ch <= 'z'; ch++) {
						copy[i] = ch;
						String newWord = new String(copy);
						// again replacing with the old char
						copy[i] = oldChar;
						// check if it exists in the set and push it in the queue.
						if (!wordSet.contains(newWord)) continue;
						// creating a new seq from the old seq and new word
						LinkedList<String> newSeq = new LinkedList<>(seq);
						newSeq.add(newWord);
						// also adding it to the queue
						queue.offer(newSeq);
						// we are adding these words in the toBeDeleted list, to delete in future
						toBeDeletedWords.add(newWord);
						// if at any level we find the end-word, then we will add that to the answer
						// we know it is the lowest level possible because we are going to the level wise
						if (newWord.equalsIgnoreCase(endWord)) answer.add(newSeq);
					}
				}
			}
			// and at last we may loop through the transformed words that are to be deleted
			for (String word : toBeDeletedWords) wordSet.remove(word);
			// if the answer array is not empty, that means there is least one answer exist
			// so we can stop the loop here
			if (!answer.isEmpty()) return answer;
			// again we are clearing the toBeDeletedWords list
			toBeDeletedWords.clear();
		}
		return answer;
	}

}

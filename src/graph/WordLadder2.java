package graph;

import java.util.ArrayList;
import java.util.Deque;
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
		// please check other leetcode solution
		// type 3 is best leetcode solution till now
		type3();

	}

	private static void type3() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));

		List<List<String>> answer = new Solution().findLadders(beginWord, endWord, wordList);
		System.out.println(answer);
	}

	static class Solution {
		List<List<String>> ans = new ArrayList<>();
		Map<String, Integer> wordToId = new HashMap<>();
		Map<Integer, String> idToWord = new HashMap<>();
		Map<Integer, List<Integer>> path = new HashMap<Integer, List<Integer>>();
		Deque<String> list = new LinkedList<>();
		int[] ne, e, h;
		boolean[] vis;
		int len, idx, start, end;

		void add(int u, int v) {
			e[++len] = v;
			ne[len] = h[u];
			h[u] = len;
		}

		public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
			int n = wordList.size();
			ne = new int[20 * n];
			e = new int[20 * n];
			h = new int[20 * n];
			vis = new boolean[10 * n];
			if (!wordList.contains(beginWord))
				wordList.add(beginWord);
			if (!wordList.contains(endWord))
				return ans;
			for (int i = 0; i < wordList.size(); i++)
				addEdge(wordList.get(i));
			Queue<Integer> q = new LinkedList<>();
			start = wordToId.get(beginWord);
			end = wordToId.get(endWord);
			q.add(start);
			while (!q.isEmpty()) {
				int u = q.poll();
				if (u == end)
					break;
				if (vis[u])
					continue;
				vis[u] = true;
				for (int j = h[u]; j != 0; j = ne[j]) {
					int v = e[j];
					if (vis[v])
						continue;
					if (!path.containsKey(v))
						path.put(v, new ArrayList<>());
					path.get(v).add(u);
					q.add(v);
				}
			}
			// Search out the path from the end point dfs
			list.add(endWord);
			dfs(end, 0);
			return ans;
		}

		void dfs(int u, int level) {
			if (u == start) {
				// reach the starting point
				ans.add(new ArrayList<>(list));
				return;
			}
			List<Integer> p = path.get(u);
			if (p == null)
				return;
			for (int i = 0; i < p.size(); i++) {
				int v = p.get(i);
				if (level % 2 == 1)
					list.addFirst(idToWord.get(v));
				dfs(v, level + 1);
				if (level % 2 == 1)
					list.pollFirst();
			}
		}

		void addEdge(String word) {
			int u = idx;
			char[] arr = word.toCharArray();
			wordToId.put(word, idx);
			idToWord.put(idx++, word);
			for (int i = 0; i < arr.length; i++) {
				char t = arr[i];
				arr[i] = '*';
				String vstr = new String(arr);
				if (!wordToId.containsKey(vstr)) {
					wordToId.put(vstr, idx);
					idToWord.put(idx++, vstr);
				}
				int v = wordToId.get(vstr);
				add(u, v);
				add(v, u);
				arr[i] = t;
			}
		}
	}

	// this will also get TLE in leetcode
	private static void type2() {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");

		List<List<String>> answer = new ArrayList<>();
		Map<String, List<String>> groupMap = new HashMap<>();

		// this helper method will group all the similar words
		// like dog cog bog and the key will be #og
		for (String word : wordList)
			groupWords(word, groupMap);

		Set<String> wordSet = new HashSet<>(wordList);
		wordSet.remove(beginWord);

		if (!wordSet.contains(endWord))
			return;

		Queue<List<String>> queue = new LinkedList<>();
		queue.offer(List.of(beginWord));

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<String> toBeVisitedWords = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				List<String> seq = queue.poll();
				String word = seq.get(seq.size() - 1);
				char[] arr = word.toCharArray();
				for (int j = 0; j < word.length(); j++) {
					char ch = arr[j];
					arr[j] = '#';
					List<String> group = groupMap.get(new String(arr));
					arr[j] = ch;
					if (null == group)
						continue;
					for (String transformedWord : group) {
						if (wordSet.contains(transformedWord)) {
							List<String> currentSeq = new ArrayList<>(seq);
							currentSeq.add(transformedWord);
							if (transformedWord.equals(endWord)) {
								answer.add(currentSeq);
							}
							queue.add(currentSeq);
							toBeVisitedWords.add(transformedWord);
						}
					}
				}
			}
			for (String word : toBeVisitedWords)
				wordSet.remove(word);
			if (!answer.isEmpty())
				break;
		}
		System.out.println(answer);
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

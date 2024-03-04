package com.ds.graph;

import java.util.*;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/alien-dictionary/1
 * https://www.codingninjas.com/studio/problems/alien-dictionary_630423
 * https://leetcode.com/problems/alien-dictionary/solutions/562919/official-solution/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=U3N_je7tWAs&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=26
 * 
 * https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
 */
public class AlienDictionary {

	// This a classic problem of topological sort.
	// We just have to create a graph of letters and for that, we need to know
	// which letter is bigger than which letter.We can derive from the given words
	// then after that we can create a graph our last work will be to know the topo sort of the graph
	public static void main(String[] args) {
		type1();
		type2();
	}

	// using dfs and topological sort
	private static void type2() {
		String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
		int n = 5;
		int k = 4;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < k; i++) adjList.add(new ArrayList<>());

		// all the strings are in lexicographic order,
		// so the first string has lower value than the second,
		// so we need to find the characters for which the difference arises
		for (int i = 0; i < n - 1; i++) {
			char[] first = dict[i].toCharArray();
			char[] second = dict[i + 1].toCharArray();
			int j = 0, n2 = second.length, n1 = first.length;
			// we will increment the j till there is a different character to draw edge between first[j] to second[j]
			while (j < n1 && j < n2 && first[j] == second[j]) j++;
			// we will convert the character to a zero-index integer
			if (j < n1 && j < n2) adjList.get(first[j] - 'a').add(second[j] - 'a');
		}
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[k];
		for (int i = 0; i < k; i++)
			if (!visited[i])
				dfs(i, visited, adjList, stack);
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(((char) (stack.pop() + 'a')));

		System.out.println(sb);
	}

	private static void dfs(int start, boolean[] visited, List<List<Integer>> adjList, Stack<Integer> stack) {
		visited[start] = true;
		for (int node : adjList.get(start))
			if (!visited[node])
				dfs(node, visited, adjList, stack);
		stack.push(start);
	}

	// using bfs and kahn algorithm
	private static void type1() {
		String[] dict = {
				"baa",
				"abcd",
				"abca",
				"cab",
				"cad"
		};
		int n = 5;
		int k = 4;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < k; i++) adjList.add(new ArrayList<>());

		// all the strings are in lexicographic order,
		// so the first string has lower value than the second,
		// so we need to find the characters for which the difference arises
		for (int i = 0; i < n - 1; i++) {
			char[] first = dict[i].toCharArray();
			char[] second = dict[i + 1].toCharArray();
			int j = 0, n2 = second.length, n1 = first.length;
			// we will increment the j till there is a different character to draw edge between first[j] to second[j]
			while (j < n1 && j < n2 && first[j] == second[j]) j++;
			// we will convert the character to a zero-index integer
			if (j < n1 && j < n2) adjList.get(first[j] - 'a').add(second[j] - 'a');
		}

		int[] indegree = new int[k];
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (List<Integer> nodes : adjList) for (int node : nodes) indegree[node]++;
		for (int i = 0; i < k; i++)
			if (indegree[i] == 0) queue.offer(i);

		while (!queue.isEmpty()) {
			int start = queue.poll();
			sb.append(((char) (start + 'a')));
			for (int end : adjList.get(start)) {
				indegree[end]--;
				if (indegree[end] == 0) queue.offer(end);
			}
		}
		System.out.println(sb);
	}

}

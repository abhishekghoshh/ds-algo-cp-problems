package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/alien-dictionary/1
 * https://leetcode.com/problems/alien-dictionary/solutions/562919/official-solution/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=U3N_je7tWAs&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=26
 * 
 * https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
 * 
 */
public class AlienDictionaryUsingTopologicalSort {

	// this a classic problem of topological sort
	// we just have to create a graph of letters
	// for that we need to know which letter is bigger than which letter
	// that we can derive from the given words
	// then after that we can create a graph
	// we our last work will be to know the topo sort of the graph
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
		for (int i = 0; i < k; i++)
			adjList.add(new ArrayList<>());
		// all the strings are in lexicographic order
		// so the first string has lower value than second
		// so we need to find the characters for which the difference arrises
		for (int i = 0; i < n - 1; i++) {
			char[] first = dict[i].toCharArray();
			char[] second = dict[i + 1].toCharArray();
			int l1 = 0, l2 = 0;
			while (l1 < first.length && l2 < second.length && first[l1] == second[l2]) {
				l1++;
				l2++;
			}
			// if both l1 and l2 is in bound
			// that means there is difference between first[l1] and second[l2]
			// so we can draw edge between first[l1] to second[l2]
			// to do so we have to find it's alphabetical position
			// so we will subtract it with 'a'
			if (l1 < first.length && l2 < second.length)
				adjList.get(first[l1] - 'a').add(second[l2] - 'a');

		}
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[k];
		for (int i = 0; i < k; i++)
			if (!visited[i])
				dfs(i, visited, adjList, stack);
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty())
			sb.append(((char) (stack.pop() + 'a')));

		System.out.println(sb.toString());
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
		String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
		int n = 5;
		int k = 4;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < k; i++)
			adjList.add(new ArrayList<>());

		// all the strings are in lexicographic order
		// so the first string has lower value than second
		// so we need to find the characters for which the difference arrises
		for (int i = 0; i < n - 1; i++) {
			char[] first = dict[i].toCharArray();
			char[] second = dict[i + 1].toCharArray();
			int l1 = 0, l2 = 0;
			while (l1 < first.length && l2 < second.length && first[l1] == second[l2]) {
				l1++;
				l2++;
			}
			// if both l1 and l2 is in bound
			// that means there is difference between first[l1] and second[l2]
			// so we can draw edge between first[l1] to second[l2]
			// to do so we have to find it's alphabetical position
			// so we will subtract it with 'a'
			if (l1 < first.length && l2 < second.length)
				adjList.get(first[l1] - 'a').add(second[l2] - 'a');
		}

		int[] indegree = new int[k];
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (List<Integer> nodes : adjList)
			for (int node : nodes)
				indegree[node]++;
		for (int i = 0; i < k; i++)
			if (indegree[i] == 0)
				queue.offer(i);

		while (!queue.isEmpty()) {
			int point = queue.poll();
			sb.append(((char) (point + 'a')));
			for (int node : adjList.get(point)) {
				indegree[node]--;
				if (indegree[node] == 0)
					queue.offer(node);
			}
		}
		System.out.println(sb.toString());
	}

}

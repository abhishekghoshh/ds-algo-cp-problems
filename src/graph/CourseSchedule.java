package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/course-schedule/
 * https://leetcode.com/problems/course-schedule-ii/
 * https://practice.geeksforgeeks.org/problems/course-schedule/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=iTBaI90lpDQ&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=23
 * https://www.youtube.com/watch?v=WAOfKpxYHR8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=24
 * 
 * https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/
 */
public class CourseSchedule {

	public static void main(String[] args) {
		type1();
		type1_();
		type2();
	}

	private static void type2() {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			adjacencyList.add(new ArrayList<>());

		for (int[] pair : prerequisites) {
			int start = pair[1];
			int end = pair[0];
			adjacencyList.get(start).add(end);
		}
		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++)
			if (visited[i] == 0 && dfs(i, visited, adjacencyList)) {
				System.out.println(false);
				return;
			}
		System.out.println(true);
	}

	private static boolean dfs(int start, int[] visited, List<List<Integer>> adjacencyList) {
		visited[start] = 2;
		for (int node : adjacencyList.get(start)) {
			if (visited[node] == 0) {
				if (dfs(node, visited, adjacencyList))
					return true;
			} else if (visited[node] == 2)
				return true;
		}
		visited[start] = 1;
		return false;
	}

	// using dfs
	private static void type1_() {
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			adjacencyList.add(new ArrayList<>());

		for (int[] pair : prerequisites) {
			int start = pair[1];
			int end = pair[0];
			adjacencyList.get(start).add(end);
		}

		int[] visited = new int[numCourses];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < numCourses; i++)
			if (visited[i] == 0 && dfs(i, visited, adjacencyList, stack))
				return;
		int[] answer = new int[numCourses];
		int size = 0;

		while (!stack.isEmpty())
			answer[size++] = stack.pop();

		print(answer);

	}

	private static boolean dfs(int start, int[] visited, List<List<Integer>> adjacencyList, Stack<Integer> stack) {
		visited[start] = 2;
		for (int node : adjacencyList.get(start)) {
			if (visited[node] == 0) {
				if (dfs(node, visited, adjacencyList, stack))
					return true;
			} else if (visited[node] == 2)
				return true;
		}
		visited[start] = 1;
		stack.push(start);
		return false;
	}

	// curse can be scheduled or not and print the sequence
	// There are a total of numCourses courses you have to take, labeled from 0 to
	// numCourses - 1. You are given an array prerequisites where prerequisites[i] =
	// [ai, bi] indicates that you must take course bi first if you want to take
	// course a
	// the pair [0, 1], indicates that to take course 0 you have to first take
	// course 1.
	private static void type1() {

		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
			adjacencyList.add(new ArrayList<>());

		// creating the adjacency list and in degree at the same place
		int[] indegree = new int[numCourses];
		for (int[] pair : prerequisites) {
			int start = pair[1];
			int end = pair[0];
			adjacencyList.get(start).add(end);
			indegree[end]++;
		}
//		System.out.println(adjacencyList);
//		print(indegree);
		int[] answer = new int[numCourses];
		int size = 0;
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < numCourses; i++)
			if (indegree[i] == 0)
				queue.offer(i);

		while (!queue.isEmpty()) {
			int point = queue.poll();
			answer[size++] = point;
			for (int node : adjacencyList.get(point)) {
				indegree[node]--;
				if (indegree[node] == 0)
					queue.offer(node);
			}
		}
		if (size != numCourses)
			answer = new int[] {};
		print(answer);

	}

	private static void print(int[] answer) {
		for (int node : answer)
			System.out.print(node + " ");
		System.out.println();
	}

}

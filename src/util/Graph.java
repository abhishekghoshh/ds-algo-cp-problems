package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

	public static int[][] undirectedGraphWithMatrix(Scanner scanner) {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		return graph;
	}

	public static int[][] directedGraphWithMatrix(Scanner scanner) {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			graph[start][end] = 1;
		}
		return graph;
	}

	public static List<Integer>[] undirectedGraphWithList(Scanner scanner) {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		List<Integer>[] graph = new List[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			graph[start].add(end);
			graph[end].add(start);
		}
		return graph;
	}

	public static List<Integer>[] directedGraphWithList(Scanner scanner) {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		List<Integer>[] graph = new List[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			graph[start].add(end);
		}
		return graph;
	}

	public static List<Integer>[] transform(int[][] graph) {
		int n = graph.length - 1;
		List<Integer>[] graphWithList = new List[n + 1];
		for (int i = 1; i <= n; i++)
			graphWithList[i] = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j : graph[i])
				graphWithList[i].add(j);
		}
		return graphWithList;
	}

	public static int[][] transform(List<Integer>[] graphWithList) {
		int n = graphWithList.length - 1;
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			if (graph[i] == null)
				continue;
			for (int j : graphWithList[i]) {
				graph[i][j] = 1;
			}
		}
		return graph;
	}

	public static ArrayList<ArrayList<Integer>> adjacencyList(int[][] list) {
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		for (int[] row : list) {
			ArrayList<Integer> vertices = new ArrayList<>();
			for (int vertex : row)
				vertices.add(vertex);
			adjacencyList.add(vertices);
		}
		return adjacencyList;
	}

	public static void print(ArrayList<ArrayList<Integer>> adjacencyList) {
		int n = adjacencyList.size();
		System.out.println("Undirected graph using adjacency list");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " -> " + adjacencyList.get(i));
		}
	}

	public static void print(int[][] graph) {
		int n = graph.length - 1;
		System.out.println("Undirected graph with matrix");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print(List<Integer>[] graph) {
		int n = graph.length;
		System.out.println("Undirected graph using adjacency list");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " -> " + graph[i]);
		}
	}
}

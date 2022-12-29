package problems.graph;

import static util.OnlineJudgeInit.scanner;
import static util.OnlineJudgeInit.set;

import java.util.ArrayList;
import java.util.List;;

public class GraphRepresentation {

	public static void main(String[] args) {
		set();
		undirectedGraphUsingMatrix();
		undirectedGraphUsingAdjacencyList();
		directedGraphUsingMatrix();
		directedGraphUsingAdjacencyList();
		weightedGraphUsingMatrix();
		weightedGraphUsingAdjacenyList();
	}

	private static void weightedGraphUsingAdjacenyList() {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		List<Pair>[] graph = new List[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int weight = scanner.nextInt();
			graph[start].add(new Pair(end, weight));
		}
		System.out.println("Weighted directed graph using adjacency list");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " -> " + graph[i]);
		}
	}

	private static void weightedGraphUsingMatrix() {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int weight = scanner.nextInt();
			graph[start][end] = weight;
		}
		System.out.println("Weighted directed graph using matrix");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void directedGraphUsingAdjacencyList() {
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
		System.out.println("Directed graph using adjacency list");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " -> " + graph[i]);
		}
	}

	private static void directedGraphUsingMatrix() {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			graph[start][end] = 1;
		}
		System.out.println("Directed graph using matrix");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void undirectedGraphUsingAdjacencyList() {
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
		System.out.println("Undirected graph using adjacency list");
		for (int i = 1; i <= n; i++) {
			System.out.println(i + " -> " + graph[i]);
		}
	}

	private static void undirectedGraphUsingMatrix() {
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] graph = new int[n + 1][n + 1];
		for (int i = 0; i < e; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		System.out.println("Undirected graph using matrix");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static class Pair {
		public int vertex;
		public int weight;

		public Pair(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + vertex;
			result = prime * result + weight;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (vertex != other.vertex)
				return false;
			if (weight != other.weight)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "[end=" + vertex + ", weight=" + weight + "]";
		}

	}
}

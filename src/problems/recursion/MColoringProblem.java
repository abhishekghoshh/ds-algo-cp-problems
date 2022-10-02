package problems.recursion;

import java.util.Arrays;

/*
 * Problem link : 
 * https://www.codingninjas.com/codestudio/problems/981273?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=wuVwUK25Rfc&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=60
 * https://takeuforward.org/data-structure/m-coloring-problem/
 * 
 * 
 * */
public class MColoringProblem {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using backtracking
	// for every point we are checking if all color is possible or not
	// if one color is possible then we are going to next point
	private static void type2() {
		int m = 3;
		boolean[][] graph = { { false, true, true, true }, { true, false, true, false }, { true, true, false, true },
				{ true, false, true, false } };
		int n = graph.length;
		int[] points = new int[n];
		boolean isPossible = isColoringPossible(graph, 0, points, m, n);
		System.out.println(isPossible);
	}

	private static boolean isColoringPossible(boolean[][] graph, int point, int[] points, int m, int n) {
		if (point == n) {
			return true;
		}
		// we are trying for m color one by one
		for (int i = 1; i <= m; i++) {
			// color available means we can allot ith color to point
			if (colorAvailable(graph, point, i, n, points)) {
				points[point] = i;
				// now we are checking possiblities for point+1 inde
				if (isColoringPossible(graph, point + 1, points, m, n)) {
					return true;
				}
				// it comes to this section mean with ith coloring the graph can not be colored
				// so we are removing the color
				points[point] = 0;
			}
		}
		return false;
	}

	private static boolean colorAvailable(boolean[][] graph, int point, int color, int n, int[] points) {
		for (int i = 0; i < n; i++) {
			if (graph[i][point] && points[i] == color) {
				return false;
			}
		}
		return true;
	}

	// TODO check it later
	// getting error in geekforgeeks
	// We can apply dfs here
	private static void type1() {
		// number of colors
		int m = 3;
		boolean[][] graph = { { false, true, true, true }, { true, false, true, false }, { true, true, false, true },
				{ true, false, true, false } };
		int n = graph.length;
		int[] points = new int[n];
		for (int i = 0; i < n; i++) {
			// we are checking on each index that it is colored or not
			// if its not colored yet then we are starting dfs from that index
			if (points[i] == 0) {
				points[i] = 1;
				traverse(i, points, graph, n);
			}
		}
		print(points);
		int pointsNeeded = Arrays.stream(points).max().getAsInt();
		System.out.println("points needed " + pointsNeeded + " color alotted " + m);
	}

	private static void traverse(int point, int[] points, boolean[][] graph, int n) {
		// we are looping through all the indexes
		for (int i = 0; i < n; i++) {
			// if there is an edge to other point and that point is not yet colored
			if (graph[point][i] && points[i] == 0) {
				points[i] = 1;
				// so out of all its neighours we are checking which color can be alloted
				for (int j = 0; j < n; j++) {
					if (graph[i][j] && points[i] == points[j]) {
						points[i]++;
					}
				}
				traverse(i, points, graph, n);
			}
		}
	}

	private static void print(int[] points) {
		for (int point : points) {
			System.out.print(point + " ");
		}
		System.out.println();
	}

	public static boolean[][] graph() {
		int m = 4;
		int n = 11;
		String s = "5 6 8 11 10 11 5 11 7 9 6 9 7 10 2 10 6 7 5 9 4 11 6 8 1 8 4 5 2 9 8 10 3 6 1 11 9 10 2 6 3 11 5 10 7 11 9 11 4 8 1 9 8 9 3 8 6 11 4 6 1 6 1 10 2 4";
		boolean[][] graph = new boolean[n][n];
		String[] array = s.split(" ");
		for (int i = 0; i < array.length; i = i + 2) {
			graph[Integer.parseInt(array[i]) - 1][Integer.parseInt(array[i + 1]) - 1] = true;
			graph[Integer.parseInt(array[i + 1]) - 1][Integer.parseInt(array[i]) - 1] = true;
		}
		return graph;
	}
}

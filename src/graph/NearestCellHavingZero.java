package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/01-matrix/
 * 
 * Solution link : 
 * https://www.youtube.com/watch?v=edXdVwkYHF8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14
 * 
 * 
 * https://takeuforward.org/graph/distance-of-nearest-cell-having-1/
 * */

public class NearestCellHavingZero {

	public static void main(String[] args) {
		type1();
		type2();

	}

	private static void type2() {
		int mat[][] = { { 0, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 0 } };
		int row = mat.length;
		int column = mat[0].length;
		int[][] distance = new int[row][column];

		// first we will set all the cell to MAX-1 not MAX
		for (int i = 0; i < row; i++)
			Arrays.fill(distance[i], Integer.MAX_VALUE - 1);

		// first we will traverse from the start
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				// if the cell is 0 then we put the distance as 0
				if (mat[r][c] == 0) {
					distance[r][c] = 0;
					continue;
				}
				// if the cell is not zero then we are trying to minimize the cell value will
				// previous cell value having 0
				if (r > 0)
					distance[r][c] = Math.min(distance[r][c], distance[r - 1][c] + 1);
				if (c > 0)
					distance[r][c] = Math.min(distance[r][c], distance[r][c - 1] + 1);
			}
		}
		// so we have already traversed from start
		// but if some of the point comes at the end then for that points the the
		// neighbours are not minimized
		// so we will now traverse from the last
		for (int r = row - 1; r >= 0; r--) {
			for (int c = column - 1; c >= 0; c--) {
				if (r != row - 1)
					distance[r][c] = Math.min(distance[r][c], distance[r + 1][c] + 1);
				if (c != column - 1)
					distance[r][c] = Math.min(distance[r][c], distance[r][c + 1] + 1);
			}
		}
		print(distance);
	}

	// nearest cell having 1
	// using BFS
	private static void type1() {
		int mat[][] = { { 0, 1, 0, 0 }, { 0, 0, 1, 1 }, { 0, 0, 1, 0 } };
		int row = mat.length;
		int column = mat[0].length;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[row][column];
		int[][] distance = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (mat[i][j] == 0) {
					// if cell is 1 we will add it to the queue
					// as the starting point
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}
		// for 4 direction we have defined 4 delta coordinates
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int d = 0;
		// currently queue only holds the points with cell value equal to 1
		// for that point nearest cell having 1 distance is 0
		// so initialize a variable d with 0
		// are we are applying BFS so we are evenly spreading out
		// so after each iteration we will increment d value
		while (!queue.isEmpty()) {
			// first it will check the size of queue
			// we will apply BFS from that many point and add to the queue
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] point = queue.poll();
				distance[point[0]][point[1]] = d;
				for (int i = 0; i < 4; i++) {
					int x = point[0] + dx[i];
					int y = point[1] + dy[i];
					if (x >= 0 && x < row && y >= 0 && y < column && !visited[x][y]) {
						visited[x][y] = true;
						queue.offer(new int[] { x, y });
					}
				}
			}
			d++;
		}
		print(distance);
	}

	public static void print(int[][] graph) {
		int row = graph.length;
		int column = graph[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}

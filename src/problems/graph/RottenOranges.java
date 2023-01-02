package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/rotting-oranges/
 * https://www.codingninjas.com/codestudio/problems/701655?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=yf3oUhkvqA0
 * 
 * https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/
 * 
 */
public class RottenOranges {

	// 2 – represents a rotten orange
	// 1 – represents a Fresh orange
	// 0 – represents an Empty Cell
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	private static void type3() {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int answer = orangesRotting(grid);
		System.out.println(answer);

	}

	public static int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return -1;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					transform(i, j, grid, 2);
				}
			}
		}

		int minutes = 2;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
				minutes = Math.max(minutes, grid[i][j]);
			}
		}

		return minutes - 2;
	}

	public static void transform(int i, int j, int[][] grid, int time) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0
				|| (1 < grid[i][j] && grid[i][j] < time)) {
			return;
		}
		grid[i][j] = time;
		transform(i - 1, j, grid, time + 1);
		transform(i + 1, j, grid, time + 1);
		transform(i, j - 1, grid, time + 1);
		transform(i, j + 1, grid, time + 1);
	}

	private static void type2() {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		if (grid == null || grid.length == 0)
			return;
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int totalOranges = 0;
		// Put the position of all rotten oranges in queue
		// count the number of fresh oranges
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[] { i, j });
				}
				if (grid[i][j] != 0) {
					totalOranges++;
				}
			}
		}
		if (totalOranges == 0)
			return;
		int time = 0, orangeCount = 0;
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };

		// bfs starting from initially rotten oranges
		while (!queue.isEmpty()) {
			// take the current size of the queue
			// because we need to check that for the current set of oranges
			// it is possible to rot new oranges or not
			int size = queue.size();
			orangeCount += size;
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();
				for (int j = 0; j < 4; j++) {
					int x = point[0] + dx[j];
					int y = point[1] + dy[j];
					if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1) {
						grid[x][y] = 2;
						queue.offer(new int[] { x, y });
					}
				}
			}
			// if the set of initial oranges are able to rot new oranges then it will add to
			// queue, queue size will not be empty
			if (queue.size() != 0) {
				time++;
			}
		}
		int answer = totalOranges == orangeCount ? time : -1;
		System.out.println(answer);
	}

	// using queue
	// we will start from the oranges which is rotten
	// we will store the point and apply bfs on them
	private static void type1() {
		int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int answer;
		int r = grid.length;
		int c = grid[0].length;
		int freshOranges = 0, maxTime = 0, x, y, time;
		Queue<Point> queue = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new Point(i, j, 0));
				}
				if (grid[i][j] == 1) {
					freshOranges++;
				}
			}
		}
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			x = point.x;
			y = point.y;
			time = point.time;
			maxTime = Math.max(maxTime, time);
			if (y > 0 && grid[x][y - 1] == 1) {
				freshOranges--;
				grid[x][y - 1] = 2;
				queue.offer(new Point(x, y - 1, time + 1));
			}
			if (x > 0 && grid[x - 1][y] == 1) {
				freshOranges--;
				grid[x - 1][y] = 2;
				queue.offer(new Point(x - 1, y, time + 1));
			}
			if (x < r - 1 && grid[x + 1][y] == 1) {
				freshOranges--;
				grid[x + 1][y] = 2;
				queue.offer(new Point(x + 1, y, time + 1));
			}
			if (y < c - 1 && grid[x][y + 1] == 1) {
				freshOranges--;
				grid[x][y + 1] = 2;
				queue.offer(new Point(x, y + 1, time + 1));
			}
		}
		answer = freshOranges == 0 ? maxTime : -1;
		System.out.println(answer);
	}

	private static class Point {
		public int x;
		public int y;
		public int time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}

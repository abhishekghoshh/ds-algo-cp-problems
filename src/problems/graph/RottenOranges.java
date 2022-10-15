package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
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

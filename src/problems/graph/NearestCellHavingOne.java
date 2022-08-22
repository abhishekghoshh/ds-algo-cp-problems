package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/01-matrix/
 * 
 * Solution link : https://www.youtube.com/watch?v=edXdVwkYHF8
 * 
 * */
class Point {
	int x;
	int y;
	int distance;

	Point(int x, int y, int distance) {
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + ", distance=" + distance + "]";
	}
	
}
public class NearestCellHavingOne {
	
	public static void main(String[] args) {
		int mat[][] = { 
				{0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 0} 
                };
		int row = mat.length;
		int column = mat[0].length;
		Queue<Point> queue = new LinkedList<>();
		boolean[][] visited = new boolean[row][column];
		int[][] distance = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (mat[i][j] == 1) {
					queue.offer(new Point(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			distance[point.x][point.y] = point.distance;
			addNeighour(point.x + 1, point.y, row, column, visited, queue, point.distance + 1);
			addNeighour(point.x - 1, point.y, row, column, visited, queue, point.distance + 1);
			addNeighour(point.x, point.y + 1, row, column, visited, queue, point.distance + 1);
			addNeighour(point.x, point.y - 1, row, column, visited, queue, point.distance + 1);
		}
		print(distance);

	}

	private static void addNeighour(int x, int y, int row, int column, boolean[][] visited, Queue<Point> queue,
			int distance) {
		if (x >= 0 && x < row && y >= 0 && y < column && !visited[x][y]) {
			visited[x][y] = true;
			queue.offer(new Point(x, y, distance));
		}
	}
	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
			for (int item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

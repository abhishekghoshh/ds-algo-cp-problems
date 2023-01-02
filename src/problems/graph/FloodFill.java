package problems.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Problem link :
 * https://leetcode.com/problems/flood-fill/
 * https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flood-fill-algorithm
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
 * 
 * https://takeuforward.org/graph/flood-fill-algorithm-graphs/
 * 
 */
public class FloodFill {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using dfs
	private static void type2() {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, color = 2;
		if (color == image[sr][sc])
			return;
		dfs(image, sr, sc, image[sr][sc], color);
		print(image);
	}

	public static void dfs(int[][] image, int x, int y, int oldColor, int color) {
		if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && image[x][y] == oldColor) {
			image[x][y] = color;
			dfs(image, x - 1, y, oldColor, color); // top call
			dfs(image, x, y + 1, oldColor, color); // right call
			dfs(image, x + 1, y, oldColor, color); // down call
			dfs(image, x, y - 1, oldColor, color); // left call
		}
	}

	// using bfs
	private static void type1() {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, color = 2;
		if (color == image[sr][sc])
			return;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int oldColor = image[sr][sc];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { sr, sc });
		image[sr][sc] = color;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = p[0] + dx[i];
				int y = p[1] + dy[i];
				if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && image[x][y] == oldColor) {
					queue.offer(new int[] { x, y });
					image[x][y] = color;
				}
			}
		}
		print(image);
	}

	private static void print(int[][] image) {
		for (int[] row : image) {
			for (int item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

}

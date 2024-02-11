package com.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

import static com.util.PrintUtl.print;

/*
 * Problem link :
 * https://leetcode.com/problems/flood-fill/
 * https://www.codingninjas.com/studio/problems/flood-fill-_1082141
 * https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=C-2_uSRli8o&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=9
 * 
 * https://takeuforward.org/graph/flood-fill-algorithm-graphs/
 */
public class FloodFill {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// using dfs
	// recursively traverse all the cell and change all the cell
	// which has the same color as the source cell previous color
	private static void type2() {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, color = 2;
		image = floodFill2(image, sr, sc, color);
		print(image);
	}

	private static int[][] floodFill2(int[][] image, int sr, int sc, int color) {
		if (color == image[sr][sc]) return image;
		traverse(image, sr, sc, image[sr][sc], color);
		return image;
	}

	public static void traverse(int[][] image, int x, int y, int prevColor, int color) {
		if (isInBounds(x, y, image) && image[x][y] == prevColor) {
			image[x][y] = color;
			traverse(image, x - 1, y, prevColor, color); // top call
			traverse(image, x, y + 1, prevColor, color); // right call
			traverse(image, x + 1, y, prevColor, color); // down call
			traverse(image, x, y - 1, prevColor, color); // left call
		}
	}

	// using bfs,
	// but here we do not need to a level wise traversal,
	// we store the indices to one queue and poll one by one
	// we could simply use any data structure
	private static void type1() {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, color = 2;
		image = floodFill1(image, sr, sc, color);
		print(image);
	}

	public static int[][] floodFill1(int[][] image, int sr, int sc, int color) {
		if (color == image[sr][sc]) return image;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};

		int prevColor = image[sr][sc];
		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[]{sr, sc});
		image[sr][sc] = color;

		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = point[0] + dx[i];
				int y = point[1] + dy[i];
				if (isInBounds(x, y, image) && image[x][y] == prevColor) {
					queue.offer(new int[]{x, y});
					image[x][y] = color;
				}
			}
		}
		return image;
	}

	private static boolean isInBounds(int x, int y, int[][] image) {
		return x >= 0 && y >= 0 && x < image.length && y < image[0].length;
	}


}

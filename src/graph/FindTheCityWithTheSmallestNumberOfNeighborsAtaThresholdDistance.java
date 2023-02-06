package graph;

/*
 * Problem link :
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 * https://practice.geeksforgeeks.org/problems/city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/0
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=PwMVNSJ5SLI&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=43
 * 
 * https://takeuforward.org/data-structure/find-the-city-with-the-smallest-number-of-neighbours-at-a-threshold-distance-g-43/
 */
public class FindTheCityWithTheSmallestNumberOfNeighborsAtaThresholdDistance {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// TODO add comments
	private static void type2() {
		int n = 5;
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int distanceThreshold = 2;

		int[][] matrix = new int[n][n];
		for (int[] edge : edges) {
			int from = edge[0];
			int to = edge[1];
			int wt = edge[2];
			matrix[from][to] = wt;
			matrix[to][from] = wt;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && matrix[i][j] == 0) {
					matrix[i][j] = (int) 1e5;
				}
			}
		}
		// floyd warshall technique
		for (int via = 0; via < n; via++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
				}
			}
		}
		int cityMax = n;
		int city = -1;
		for (int i = 0; i < n; i++) {
			int currentCityCount = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] <= distanceThreshold) {
					currentCityCount++;
				}
			}
			if (currentCityCount <= cityMax) {
				cityMax = currentCityCount;
				city = i;
			}
		}
		System.out.println(city);
	}

	// TODO add comments
	private static void type1() {
		int n = 5;
		int[][] edges = { { 0, 1, 2 }, { 0, 4, 8 }, { 1, 2, 3 }, { 1, 4, 2 }, { 2, 3, 1 }, { 3, 4, 1 } };
		int distanceThreshold = 2;

		int[][] matrix = new int[n][n];
		for (int[] edge : edges) {
			matrix[edge[0]][edge[1]] = edge[2];
			matrix[edge[1]][edge[0]] = edge[2];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (matrix[i][j] == 0)
					matrix[i][j] = -1;
			}
		}

		// floyd warshall technique
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				for (int k = 0; k < n; k++) {
					if (j == k)
						continue;
					if (i == j)
						continue;
					if (matrix[j][i] != -1 && matrix[i][k] != -1
							&& (matrix[j][k] == -1 || matrix[j][i] + matrix[i][k] < matrix[j][k])) {
						matrix[j][k] = matrix[j][i] + matrix[i][k];
					}
				}
			}
		}
		int cityMax = n, city = -1;
		// for every point we will traverse the row
		for (int i = 0; i < n; i++) {
			int cityCount = 0;
			for (int j = 0; j < n; j++) {
				if (i != j && matrix[i][j] != -1 && matrix[i][j] <= distanceThreshold) {
					cityCount++;
				}
			}
			if (cityCount <= cityMax) {
				cityMax = cityCount;
				city = i;
			}
		}
		System.out.println(city);
	}

}

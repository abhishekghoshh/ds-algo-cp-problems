package problems.array;

/*
 * problem link:
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * */
public class TrappingRainWater {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	private static void type4() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };
		int n = height.length;

	}

	// time complexity O(2n)
	// space complexity O(n)
	// exactly similar to the previous solution
	// just for we are not creating any rightMax array
	// instead on that loop we are calculating the are
	private static void type3() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };

		int n = height.length, tempMax, areaSum = 0;
		int[] leftMax = new int[n];
		leftMax[0] = tempMax = height[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = tempMax;
			tempMax = Math.max(tempMax, height[i]);
		}
		tempMax = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (height[i] < leftMax[i] && height[i] < tempMax) {
				int tempArea = (Math.min(leftMax[i], tempMax) - height[i]);
				areaSum = areaSum + tempArea;
			}
			tempMax = Math.max(tempMax, height[i]);
		}
		System.out.println(areaSum);
	}

	// time complexity O(3n)
	// space complexity O(2n)
	// on every index we are calculating it left highest wall and right highest wall
	// the water height on each block will be equal to minimum of left highest and
	// right highest wall
	// there will be no water on 0th wall and n-1th wall
	private static void type2() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };

		int n = height.length, tempMax, areaSum = 0;
		int[] leftMax = new int[n];
		int[] rightMax = new int[n];

		leftMax[0] = tempMax = height[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = tempMax;
			tempMax = Math.max(tempMax, height[i]);
		}
		rightMax[n - 1] = tempMax = height[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = tempMax;
			tempMax = Math.max(tempMax, height[i]);
		}
		for (int i = 1; i < n - 1; i++) {
			if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
				int tempArea = (Math.min(leftMax[i], rightMax[i]) - height[i]);
				areaSum = areaSum + tempArea;
			}
		}
		System.out.println(areaSum);
	}

	// brute force approach
	// for every wall we are calculating its left max height and right max height
	// O(n^2) time complexity
	// there will be no water on 0th wall and n-1th wall
	private static void type1() {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// int[] height = { 1, 2, 4, 1, 3, 2, 1, 3 };
		int n = height.length, leftMax, rightMax, areaSum;
		for (int i = 1; i < n - 1; i++) {
			leftMax = rightMax = Integer.MIN_VALUE;
			for (int j = i - 1; j >= 0; j--) {
				if (height[j] > leftMax) {
					leftMax = height[j];
				}
			}
			for (int j = i + 1; j < n; j++) {
				if (height[j] > leftMax) {
					leftMax = height[j];
				}
			}

		}
	}
}

package problems.stack;

import java.util.Arrays;

import util.Logger;

public class RainWaterTrapping {
	public static void main(String[] args) {
		Integer[] blocks = { 1, 2, 4, 1, 3, 2, 1, 3 };
		Integer[] leftMax = leftMax(blocks);
		Integer[] rightMax = rightMax(blocks);
		int area = areaSum(leftMax, rightMax, blocks);
		Logger.log(Arrays.asList(blocks));
		Logger.log(Arrays.asList(leftMax));
		Logger.log(Arrays.asList(rightMax));
		Logger.log(area);
	}

	private static int areaSum(Integer[] leftMax, Integer[] rightMax, Integer[] blocks) {
		int areaSum = 0;
		for (int i = 1; i < blocks.length - 1; i++) {
			if (blocks[i] < leftMax[i] && blocks[i] < rightMax[i]) {
				int tempArea = (Math.min(leftMax[i], rightMax[i]) - blocks[i]);
				Logger.log("The rain on build no ", i, " is with height ", blocks[i], " is ", tempArea);
				areaSum = areaSum + tempArea;
			}
		}
		return areaSum;
	}

	private static Integer[] leftMax(Integer[] blocks) {
		Integer[] leftMax = new Integer[blocks.length];
		leftMax[0] = blocks[0];
		Integer tempMax = leftMax[0];
		for (int i = 1; i < blocks.length; i++) {
			leftMax[i] = tempMax;
			tempMax = Math.max(tempMax, blocks[i]);
		}
		return leftMax;
	}

	private static Integer[] rightMax(Integer[] blocks) {
		Integer[] rightMax = new Integer[blocks.length];
		rightMax[blocks.length - 1] = blocks[blocks.length - 1];
		Integer tempMax = rightMax[blocks.length - 1];
		for (int i = blocks.length - 2; i >= 0; i--) {
			rightMax[i] = tempMax;
			tempMax = Math.max(tempMax, blocks[i]);
		}
		return rightMax;
	}
}

package problems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/983605?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/4sum/
 * 
 * Solution link
 * https://www.youtube.com/watch?v=4ggF3tXIAp0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=22
 * 
 * 
 * */
public class FourSum {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
	}

	private static void type1() {
		int[] nums = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		int n = nums.length, low, high, mid;
		long target_;
		HashSet<FourPoint> set = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					target_ = (long)target - (long)nums[i] - (long)nums[j] - (long)nums[k];
					low = k + 1;
					high = n - 1;
					while (low <= high) {
						mid = low + (high - low) / 2;
						if (nums[mid] == target_) {
							set.add(new FourPoint(nums[i], nums[j], nums[k], nums[mid]));
							break;
						} else if (nums[mid] < target_) {
							low = mid + 1;
						} else {
							high = mid - 1;
						}
					}
				}
			}
		}
		List<List<Integer>> answer = set.parallelStream().map(FourPoint::list).collect(Collectors.toList());
		System.out.println(answer);
	}

	private static class FourPoint {
		private int x1;
		private int x2;
		private int x3;
		private int x4;

		public FourPoint(int x1, int x2, int x3, int x4) {
			this.x1 = x1;
			this.x2 = x2;
			this.x3 = x3;
			this.x4 = x4;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x1;
			result = prime * result + x2;
			result = prime * result + x3;
			result = prime * result + x4;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FourPoint other = (FourPoint) obj;
			if (x1 != other.x1)
				return false;
			if (x2 != other.x2)
				return false;
			if (x3 != other.x3)
				return false;
			if (x4 != other.x4)
				return false;
			return true;
		}

		public List<Integer> list() {
			return List.of(x1, x2, x3, x4);
		}
	}

}

package problems.array;

public class CheckIfArrayIsSortedAndRotated {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int[] nums = { 1, 3, 2 };
		System.out.println(check(nums));

	}

	public static boolean check(int[] nums) {
		int n = nums.length;
		if (n == 1 || n == 2)
			return true;
		if (nums[0] < nums[n - 1]) {
			for (int i = 0; i < n - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					return false;
				}
			}
			return true;
		} else {
			int i;
			for (i = 0; i < n - 1; i++) {
				if (nums[i] > nums[i + 1]) {
					break;
				}
			}
			for (int j = i + 1; j < n - 1; j++) {
				if (nums[j] > nums[j + 1] || nums[j] > nums[0] || nums[j + 1] > nums[0]) {
					return false;
				}
			}
			return true;
		}
	}
}

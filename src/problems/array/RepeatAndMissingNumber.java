package problems.array;

public class RepeatAndMissingNumber {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// if the list is modifiable we can use swap sort
	// then we don't have to use extra space
	private static void type2() {
		int nums[] = { 3, 1, 2, 5, 3 };
		int index = 0;
		int repeat = 0;
		int missing = 0;
		while (index < nums.length) {
			if (nums[index] == index + 1 || nums[nums[index] - 1] == nums[index]) {
				index++;
			} else {
				int temp = nums[index];
				nums[index] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 != nums[i]) {
				repeat = nums[i];
				missing = i + 1;
			}
		}
		System.out.println("Repeat number is " + repeat + " Missing number is " + missing);
	}

	// if the list is non modifiable we can use swap sort
	// then we can use one extra array to store the frequency
	private static void type1() {
		final int nums[] = { 3, 1, 2, 5, 3 };
		int frequency[] = new int[nums.length];
		for (int item : nums) {
			frequency[item - 1]++;
		}
		int repeat = 0;
		int missing = 0;
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] < 1) {
				missing = i + 1;
			} else if (frequency[i] > 1) {
				repeat = i + 1;
			}
		}
		System.out.println("Repeat number is " + repeat + " Missing number is " + missing);
	}

}

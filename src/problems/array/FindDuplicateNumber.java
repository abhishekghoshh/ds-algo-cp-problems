package problems.array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();

	}

	// swap sort without using extra space
	// given array must be immutable
	private static void type4() {
		int nums[] = { 1, 3, 4, 2, 2 };
		int index = 0;
		int duplicateElement = 0;
		while (index < nums.length) {
			if (nums[index] == index + 1) {
				index++;
			} else if (nums[nums[index] - 1] == nums[index]) {
				duplicateElement = nums[index];
				break;
			} else {
				int temp = nums[index];
				nums[index] = nums[temp - 1];
				nums[temp - 1] = temp;
			}
		}
		System.out.println("Duplicate element is " + duplicateElement);
	}

	// using set with extra space on single iteration
	private static void type3() {
		int nums[] = { 1, 3, 4, 2, 2 };
		int duplicateElement = 0;
		Set<Integer> set = new HashSet<>();
		for (int item : nums) {
			if (set.contains(item)) {
				duplicateElement = item;
				break;
			}
			set.add(item);
		}
		System.out.println("Duplicate element is " + duplicateElement);
	}

	// count sort using extra space on a single iteration
	private static void type2() {
		int nums[] = { 1, 3, 4, 2, 2 };
		int length = nums.length;
		int frequency[] = new int[length];
		int duplicateElement = 0;
		for (int item : nums) {
			frequency[item - 1]++;
			if (frequency[item - 1] > 1) {
				duplicateElement = item;
				break;
			}
		}
		System.out.println("Duplicate element is " + duplicateElement);
	}

	// brute force approach o(n`2)
	private static void type1() {
		int nums[] = { 1, 3, 4, 2, 2 };
		int length = nums.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] == nums[j]) {
					System.out.println("Duplicate element is " + nums[i]);
				}
			}
		}
	}

}

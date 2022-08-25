package problems.array;

/*
 * Problem link :
 * https://www.interviewbit.com/problems/repeat-and-missing-number-array/
 * https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :https://www.youtube.com/watch?v=5nMGY4VUoRY&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=4
 * */
public class RepeatAndMissingNumber {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
	}

	// TODO use XOR approach
	private static void type4() {

	}

	// using mathematics and linear algebra
	// we know summation of n and summation of n^2 by formula
	// we have all the numbers
	// lets say a is missing and b is duplicate
	// so a-b = sum(arr) - sum(1..n)
	// and a^2 -b^2 = sum(arr^2) - sum(a^2 .. n^2)
	// from that we can find a+b
	// now we have a+b and a-b, we can easily find a and b
	private static void type3() {
		int nums[] = { 3, 1, 2, 5, 3 };
		int n = nums.length;
		int calculatedSum = 0;
		int calculatedSquaredSum = 0;
		for (int item : nums) {
			calculatedSum = calculatedSum + item;
			calculatedSquaredSum = calculatedSquaredSum + item * item;
		}
		int sum = n * (n + 1) / 2;
		int squaredSum = n * (n + 1) * (2 * n + 1) / 6;
		int difference = sum - calculatedSum;
		int addition = (squaredSum - calculatedSquaredSum) / difference;
		int missingElement = (addition + difference) / 2;
		int duplicateElement = (addition - difference) / 2;

		System.out.println("Missing element is " + missingElement);
		System.out.println("duplicate element is " + duplicateElement);

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

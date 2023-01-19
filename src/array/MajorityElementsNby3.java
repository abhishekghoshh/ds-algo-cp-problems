package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/893027?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * https://www.youtube.com/watch?v=yDbkQd9t2ig&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=18
 * 
 * */
/*
 * The majority element is the element that appears more than n / 3 times. There can only be at most 2 of such number in an array.
 * */
public class MajorityElementsNby3 {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// Extended Moore's voting algorithm
	// time complexity O(n)
	// space complexity O(1)
	private static void type2() {
		int[] nums = { 1, 2, 2, 3, 2 };
		List<Integer> answer = new ArrayList<>();
		int num1 = Integer.MIN_VALUE, count1 = 0, num2 = Integer.MIN_VALUE, count2 = 0, n = nums.length;
		for (int num : nums) {
			if (num == num1) {
				count1++;
			} else if (num == num2) {
				count2++;
			} else if (count1 == 0) {
				count1 = 1;
				num1 = num;
			} else if (count2 == 0) {
				count2 = 1;
				num2 = num;
			} else {
				count1--;
				count2--;
			}
		}
		int count1_ = 0, count2_ = 0;
		for (int num : nums) {
			if (num == num1) {
				count1_++;
			}
			if (num == num2) {
				count2_++;
			}
		}
		if (count1_ > (n / 3)) {
			answer.add(num1);
		}
		if (count2_ > (n / 3)) {
			answer.add(num2);
		}
		System.out.println(answer);
	}

	// Frequency map approach
	// time complexity O(n)
	// space complexity O(n)
	private static void type1() {
		int[] nums = { 1, 2, 2, 3, 2 };
		List<Integer> answer = new ArrayList<>();
		Map<Integer, Integer> frequency = new HashMap<>();
		int n = nums.length;
		for (int item : nums) {
			if (!frequency.containsKey(item)) {
				frequency.put(item, 1);
			} else {
				frequency.put(item, frequency.get(item) + 1);
			}
		}
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			if (entry.getValue() > (n / 3)) {
				answer.add(entry.getKey());
			}
		}
		System.out.println(answer);
	}

}

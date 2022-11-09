package problems.maths;

import java.util.ArrayList;
import java.util.List;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/number-of-factors1435/1
 * 
 * Solution link :
 * 
 * 
 */
public class FindMultiples {

	public static void main(String[] args) {
		type1();
		type2();
		type2_();
	}

	private static void type2_() {
		int n = 120;
		int count = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				count++;
				if (n / i != i) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	// it will take sqrt(n) time complexity
	private static void type2() {
		int n = 120;
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				answer.add(i);
				if (n / i != i) {
					answer.add(n / i);
				}
			}
		}
		System.out.println(answer);
	}

	// it will take O(n) time complexity
	private static void type1() {
		int n = 120;
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				answer.add(i);
			}
		}
		System.out.println(answer);
	}
}

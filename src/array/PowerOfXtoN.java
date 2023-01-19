package array;

/*
 * Problem link :
 * https://www.codingninjas.com/codestudio/problems/1082146?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://leetcode.com/problems/powx-n/
 * 
 * Solution link : https://www.youtube.com/watch?v=l0YC3876qxg&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=16
 * 
 * */
public class PowerOfXtoN {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// binary search approach
	// we are dividing the power by 2 if its even and multiplying the number by
	// itself at the same time, given that 3^6 is 9^3
	private static void type2() {
		double x = 2;
		int n = -2147483648;
		double answer = 1.0;
		long mn = n;
		double xy = x;
		if (x == 1) {
			answer = 1;
		} else if (x == 0) {
			answer = 0;
		} else if (n == 0) {
			answer = 1;
		} else if (n == 1) {
			answer = x;
		} else {
			mn = n < 0 ? ((-1) * mn) : mn;
			while (mn > 0) {
				if (mn % 2 == 0) {
					mn = mn / 2;
					x = x * x;
				} else {
					answer = answer * x;
					mn = (mn - 1);
				}
			}
			answer = n > 0 ? answer : ((double) (1.0) / answer);
		}

		System.out.println(String.format("pow(%f,%d) is %f", xy, n, answer));
	}

	// brute force approach
	// multiply x to itself n times
	private static void type1() {
		double x = 2;
		int n = 10;
		double answer = 1;
		for (int i = 0; i < n; i++) {
			answer = answer * x;
		}
		System.out.println(String.format("pow(%f,%d) is %f", x, n, answer));
	}

}

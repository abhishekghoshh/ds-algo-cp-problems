package problems.array;

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
		int n = 10;
		double answer = 1;
		while (n != 0) {
			if (n % 2 == 0) {
				n = n / 2;
				x = x * x;
			} else {
				answer = answer * x;
				n = (n - 1) / 2;
				x = x * x;
			}
		}
		System.out.println(String.format("pow(%f,%d) is %f", x, n, answer));
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

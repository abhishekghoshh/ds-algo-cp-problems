package binarysearch;

public class SquareRoot {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// newton raphson method
	// root = (X+N/X)/2
	// where X is imaginary root
	private static void type3() {
		int n = 40;
		double precision = 1e-14;
		double x = n, root;
		while (true) {
			root = (x + n / x) / 2;
			if (Math.abs(root - x) <= precision)
				break;
			x = root;
		}
		System.out.println(root);
	}

	// binary search method
	private static void type2() {
		int n = 40;
		double precision = 1e-14;
		double low = 0, high = n, answer = 0;
		while (low < high) {
			double mid = low + (high - low) / 2;
			double square = mid * mid;
			if (Math.abs(square - n) <= precision) {
				answer = mid;
				break;
			} else if (square > n) {
				high = mid;
			} else {
				low = mid;
			}
		}
		System.out.println(answer);
	}

	private static void type1() {
		int n = 40;
		System.out.println(Math.sqrt(n));
	}

}

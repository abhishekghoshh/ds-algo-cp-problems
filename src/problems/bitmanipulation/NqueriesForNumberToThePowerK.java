package problems.bitmanipulation;

public class NqueriesForNumberToThePowerK {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		// TODO Auto-generated method stub

	}

	private static void type1() {
		int n = 5;
		int[] queries = { 7, 8, 25, 12, 3 };
		double[] answer = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			answer[i] = Math.pow(n, queries[i]);
		}
		print(answer);
	}

	private static void print(double[] answer) {
		for (double num : answer) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

}

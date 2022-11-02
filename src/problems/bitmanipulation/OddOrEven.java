package problems.bitmanipulation;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/odd-or-even3618/1
 * 
 * Solution link :
 * 
 * 
 */
public class OddOrEven {
	//Given a positive integer N, determine whether it is odd or even.
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int n = 78;
		int lsb = n & 1;
		String ans = lsb == 0 ? "even" : "odd";
		System.out.println(ans);
	}

}

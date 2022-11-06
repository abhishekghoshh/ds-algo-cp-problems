package problems.bitmanipulation;
/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1
 * 
 * Solution link :
 * 
 * 
 */

public class SetTheRightMostUnsetBit {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int n = 1279;
		int N = setBit(n);
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(N));
	}

	// TODO check later
	static int setBit(int n) {
		for (int i = 0; i < 32; i++) {
			int num = (1 << i) | n;
			if ((1 << i) > n)
				return n;
			if (num != n)
				return num;
		}
		return n;
	}
}

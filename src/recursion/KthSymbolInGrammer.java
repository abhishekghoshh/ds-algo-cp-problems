package recursion;

/*
 * Problem link :
 * Problem link : https://leetcode.com/problems/k-th-symbol-in-grammar/
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=5P84A0YCo_Y&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=10
 * 
 * */
public class KthSymbolInGrammer {
	// We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
	// Now in every subsequent row, we look at the previous row and replace each
	// occurrence of 0 with 01, and each occurrence of 1 with 10.For example, for n
	// = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110. Given two
	// integer n and k, return the kth (1-indexed) symbol in the nth row of a table
	// of n rows.
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int n = 3, k = 3;
		int value = value(n, k);
		System.out.println(String.format("at %d row at %d column value is %d", n, k, value));
	}

	// we know 0 creates 01 and 1 creates 10
	// and at n=1 and k=1 the value is 0
	// the series is like 0 => 01 => 0110 => 01101001
	// if we observe carefully then we will se at k==1 the item is 1 always
	// so if we go till k==1 then from we can easily derive the next
	// for either k==1 or k==1 for n=2
	// if the current position is odd then it is the same previous value
	// if the current position is even then it toggle 0->1 and 1->0
	private static int value(int n, int k) {
		if (k == 1) {
			return 0;
		}
		int previous = value(n - 1, (k + 1) / 2);
		if (k % 2 != 0) {
			return previous;
		} else {
			return 1 - previous;
		}
	}

}

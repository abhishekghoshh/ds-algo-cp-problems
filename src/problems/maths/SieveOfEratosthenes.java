package problems.maths;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/count-primes/description/
 * 
 * Solution link :
 * 
 * 
 */
public class SieveOfEratosthenes {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {

	}

	private static void type1() {
		int n = 50;
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);
		primes[0] = false;
		primes[1] = false;
		int i = 2;
		while (i * i <= n) {
			if (primes[i]) {
				for (int j = 2; j <= (n / i); j++) {
					primes[i * j] = false;
				}
			}
			i++;
		}
		for (int j = 0; j <= n; j++) {
			System.out.println(j + " : " + primes[j]);
		}
	}

}

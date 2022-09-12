package problems.greedy;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/975277?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 *	https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=mVg9CfJvayM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=49
 * 
 * */
public class MinimumNumberOfCoins {

	public static void main(String[] args) {
		type1();

	}

	private static void type1() {
		int amount = 73;
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int count = 0, coinsNeeded;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (amount >= coins[i]) {
				coinsNeeded = amount / coins[i];
				count = count + coinsNeeded;
				amount = amount - coinsNeeded * coins[i];
			}
			if (amount == 0) {
				break;
			}
		}
		System.out.println("Coins needed " + count);
	}

}

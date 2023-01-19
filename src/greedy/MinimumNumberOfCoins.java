package greedy;

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

	// time complexity O(length(coins))
	// space complexity O(1)
	// we can only take a coin such that it is lesser than the amount
	// suppose we have to make 98
	// so we can not take 100, we have to take the coin which is just lesser than
	// amount, in our case it is 50, but we can only use 1 of 50's coin if we take 2
	// then it will exceed the amount
	// so our remaining amount is 48
	// not we will take 20 but we have a capacity to take 2 20's
	// so now we have to make 48-40 => 8
	// then we will take a 5 then 2 then 1
	private static void type1() {
		int amount = 104;
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int count = 0, coinsNeeded;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (amount >= coins[i]) {
				coinsNeeded = amount / coins[i];
				count = count + coinsNeeded;
				amount = amount - coinsNeeded * coins[i];
				System.out.println(coinsNeeded + " coins are taking of " + coins[i]);
			}
			if (amount == 0) {
				break;
			}
		}
		System.out.println("Coins needed " + count);
	}

}

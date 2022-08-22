package problems.array;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * https://www.codingninjas.com/codestudio/problems/893405?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link : https://www.youtube.com/watch?v=eMSfBgbiEjk&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=12
 * 
 * */
public class BuyAndSellStock {

	public static void main(String[] args) {
		type1();
		type2();

	}

	// we will scan from the left to right and see store the least price
	// time complexity is o(n)
	private static void type2() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = 0;
		int lowestPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > lowestPrice) {
				maxProfit = Math.max(maxProfit, prices[i] - lowestPrice);
			} else if (prices[i] < lowestPrice) {
				lowestPrice = prices[i];
			}
		}
		System.out.println("The maximum profit is " + maxProfit);
	}

	// brute force approach
	// try to check for all i,j where i<j and arr[i]<arr[j]
	// o(n`2) time complexity
	private static void type1() {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		int maxProfit = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[i] < prices[j] && maxProfit < prices[j] - prices[i]) {
					maxProfit = prices[j] - prices[i];
				}
			}
		}
		System.out.println("The maximum profit is " + maxProfit);
	}

}

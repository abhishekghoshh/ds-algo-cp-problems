package problems.greedy;

import java.util.Arrays;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/975286?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=F_DDzYnxO14&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=50
 * 
 * */
public class FractionalKnapSack {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int W = 50;
		Item arr[] = { new Item(60, 10), new Item(100, 20), new Item(120, 30) };
		int n = 3;
		double profit = 0;
		Profit[] profits = new Profit[n];
		for (int i = 0; i < n; i++) {
			profits[i] = new Profit(i, ((double) arr[i].value) / arr[i].weight);
		}
		Arrays.sort(profits, (profit1, profit2) -> Double.compare(profit2.ratio, profit1.ratio));
		for (int i = 0; i < n; i++) {
			Item item = arr[profits[i].id];
			if (W >= item.weight) {
				W = W - item.weight;
				profit = profit + item.value;
			} else {
				profit = profit + profits[i].ratio * W;
				break;
			}
		}
		System.out.println("max profit is " + profit);
	}

	public static class Item {
		int value, weight;

		Item(int x, int y) {
			this.value = x;
			this.weight = y;
		}

		@Override
		public String toString() {
			return "Item [value=" + value + ", weight=" + weight + "]";
		}
	}

	public static class Profit {
		int id;
		double ratio;

		public Profit(int id, double ratio) {
			super();
			this.id = id;
			this.ratio = ratio;
		}

		@Override
		public String toString() {
			return "Profit [id=" + id + ", ratio=" + ratio + "]";
		}
	}
}

# MinimumNumberOfCoins

**Topic:** `greedy`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/975277)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/find-minimum-number-of-coins_975277)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=mVg9CfJvayM&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=49)
- [📄 takeUforward](https://takeuforward.org/data-structure/find-minimum-number-of-coins/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/)

## 📝 Problem Statement

Given denominations of coins and a target amount, find the minimum number of coins needed to make the amount (assuming canonical coin system).

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

we can only take a coin such that it is lesser than the amount suppose we have to make 98 so we can not take 100, we have to take the coin which is just lesser than amount, in our case it is 50, but we can only use 1 of 50's coin if we take 2 then it will exceed the amount so our remaining amount is 48 not we will take 20 but we have a capacity to take 2 20's so now we have to make 48-40 => 8 then we will take a 5 then 2 then 1

**Time Complexity:** `O(length(coins)`
**Space Complexity:** `O(1)`

```java
	private static void type1() {
		int amount = 104;
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int count = 0, coinsNeeded;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (amount >= coins[i]) {
				coinsNeeded = amount / coins[i];
				count += coinsNeeded;
				amount -= coinsNeeded * coins[i];
				System.out.println(coins[i] + " coin count is " + coinsNeeded);
			}
			if (amount == 0) break;
		}
		System.out.println("Coins needed " + count);
	}

}
```

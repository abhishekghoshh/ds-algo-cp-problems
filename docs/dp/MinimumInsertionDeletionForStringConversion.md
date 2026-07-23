# MinimumInsertionDeletionForStringConversion

**Topic:** `dp`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/delete-operation-for-two-strings/)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/can-you-make_4244510)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25)
- [▶ YouTube](https://www.youtube.com/watch?v=yMnH0jrir0Q&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=31)
- [📄 takeUforward](https://takeuforward.org/data-structure/minimum-insertions-deletions-to-convert-string-dp-30/)

## 📝 Problem Statement

Given two strings, find min insertions and deletions to convert string A to B.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 4

tabulation with space optimization first, we will fill up all the cells assigning curr to the prev dp[n1][n2] is the common part from the two strings, so now our work is to delete the uncommon characters from the first string and add the uncommon part of the second string to the final string this is the total work

```java
	private static void type4() {
		String str1 = "abcdef";
		String str2 = "xbcdmn";
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[] prev = new int[n2 + 1];
		// first, we will fill up all the cells
		for (int i = 1; i <= n1; i++) {
			int[] curr = new int[n2 + 1];
			for (int j = 1; j <= n2; j++)
				if (arr1[i - 1] == arr2[j - 1])
					curr[j] = 1 + prev[j - 1];
				else
					curr[j] = Math.max(prev[j], curr[j - 1]);
			// assigning curr to the prev
			prev = curr;
		}
		// dp[n1][n2] is the common part from the two strings,
		// so now our work is to delete the uncommon characters from the first string
		// and add the uncommon part of the second string to the final string
		int needToBeDeleted = n1 - prev[n2];
		int needToBeAdded = n2 - prev[n2];
		// this is the total work
		int n = needToBeDeleted + needToBeAdded;
		System.out.println(n);
	}
```

### Approach 3

for changing one string to another if we do not touch the common parts and only change the places where it is different, then our work is done. so now our work is to delete the uncommon characters from the first string and add the uncommon part of the second string to the final string first, we will fill up all the cells dp[n1][n2] is the common part from the two strings, this is the total work

```java
	private static void type3() {
		String str1 = "abcdef";
		String str2 = "xbcdmn";
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[][] dp = new int[n1 + 1][n2 + 1];
		// first, we will fill up all the cells
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++)
				if (arr1[i - 1] == arr2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
		}
		// dp[n1][n2] is the common part from the two strings,
		// so now our work is to delete the uncommon characters from the first string
		// and add the uncommon part of the second string to the final string
		int needToBeDeleted = n1 - dp[n1][n2];
		int needToBeAdded = n2 - dp[n1][n2];
		// this is the total work
		int n = needToBeDeleted + needToBeAdded;
		System.out.println(n);
	}
}
```

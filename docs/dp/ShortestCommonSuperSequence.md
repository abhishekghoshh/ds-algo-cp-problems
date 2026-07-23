# ShortestCommonSuperSequence

**Topic:** `dp`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/shortest-common-supersequence/submissions/)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24)
- [▶ YouTube](https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28)
- [▶ YouTube](https://www.youtube.com/watch?v=xElxAuBcvsU&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=32)
- [📄 takeUforward](https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/)

## 📝 Problem Statement

Given two strings s1 and s2, find the length of the smallest string which has both s1 and s2 as its sub-sequences.Note: s1 and s2&nbsp;can have both uppercase and lowercase English letters.
Examples:
Input: s1 = &quot;geek&quot;, s2 = &quot;eke&quot;
Output: 5
Explanati

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

now we will fill up the entire dp table the length of the shortest common super sequence is n1 + n2 - dp[n1][n2]; as from string1 and string2 will have the common part and dp[n1][n2] will also give us the common part length so, we need to subtract the common string length it is similar to the printing the longest subsequence there we were not considering the uncommon characters, but as this is the super sequence, so we have to add those characters as well if the characters match, then we will decrement both n1 and n2 else we will go with n1-1 or n2-1 direction because dp[i][j] came from Math.max(dp[i - 1][j], dp[i][j - 1]); but this time we will add these characters also if one of the strings is not consumed entirely, then we will add that to the answer manually

```java
	private static void type3() {
		String s1 = "abac";
		String s2 = "cab";

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[][] dp = new int[n1 + 1][n2 + 1];

		// now we will fill up the entire dp table
		for (int i = 1; i <= n1; i++)
			for (int j = 1; j <= n2; j++)
				if (arr1[i - 1] == arr2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);


		// the length of the shortest common super sequence is n1 + n2 - dp[n1][n2];
		// as from string1 and string2 will have the common part and dp[n1][n2] will also give us the common part length
		// so, we need to subtract the common string length
		int n = n1 + n2 - dp[n1][n2];
		char[] arr = new char[n];
		// it is similar to the printing the longest subsequence
		// there we were not considering the uncommon characters, but as this is the super sequence, so we have to add
		// those characters as well
		while (n1 != 0 && n2 != 0) {
			// if the characters match, then we will decrement both n1 and n2
			if (arr1[n1 - 1] == arr2[n2 - 1]) {
				arr[--n] = arr1[n1 - 1];
				n1--;
				n2--;
			} else {
				// else we will go with n1-1 or n2-1 direction
				// because dp[i][j] came from Math.max(dp[i - 1][j], dp[i][j - 1]);
				// but this time we will add these characters also
				if (dp[n1 - 1][n2] > dp[n1][n2 - 1])
					arr[--n] = arr1[--n1];
				else
					arr[--n] = arr2[--n2];
			}
		}
		// if one of the strings is not consumed entirely, then we will add that to the answer manually
		while (n1 != 0) arr[--n] = arr1[--n1];
		while (n2 != 0) arr[--n] = arr2[--n2];

		String answer = new String(arr);
		System.out.println(n);
		System.out.println(answer);
	}
}
```

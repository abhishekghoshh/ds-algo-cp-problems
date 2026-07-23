# LongestCommonSubstring

**Topic:** `dp`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/longest-common-substring_1235207)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=HrybPYpOvz0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=22)
- [▶ YouTube](https://www.youtube.com/watch?v=_wP9mWNPL5w&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=28)
- [📄 takeUforward](https://takeuforward.org/data-structure/longest-common-substring-dp-27/)

## 📝 Problem Statement

Given two strings s1 and s2, determine the length of the longest substring that appears in both strings.
Examples:
Input: s1 = &quot;ABCDGH&quot;, s2 = &quot;ACDGHR&quot;
Output: 4
Explanation: The longest common substring is &quot;CDGH&quot; with a length of 4.

Input: s1 = &quot;abc

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 4

tabulation with space optimization, we will only create 2 arrays for storing current and prev row we do not need to do it for the else case as it will be 0, which is default value for int array it will directly be 0, as we are considering string, and we cannot just cut a letter similar to the longest common subsequence this is the extra stuff that we are doing to store the result unlike LCS the substring can be found anywhere in between the string not the end assigning curr to prev

```java
	private static void type4() {
		String str1 = "abcdefxmno";
		String str2 = "mabcxmno";
		char[] arr1 = str1.toCharArray(), arr2 = str2.toCharArray();
		int n1 = arr1.length, n2 = arr2.length;

		int[] prev = new int[n2 + 1];
		int max = 0, end = -1;
		String answer = "";
		for (int i = 1; i <= n1; i++) {
			int[] curr = new int[n2 + 1];
			for (int j = 1; j <= n2; j++) {
				// we do not need to do it for the else case as it will be 0, which is default value for int array
				// it will directly be 0, as we are considering string, and we cannot just cut a letter
				if (arr1[i - 1] == arr2[j - 1]) {
					// similar to the longest common subsequence
					curr[j] = 1 + prev[j - 1];
					// this is the extra stuff that we are doing to store the result
					// unlike LCS the substring can be found anywhere in between the string
					// not the end
					if (max < curr[j]) {
						max = curr[j];
						end = i - 1;
					}
				}
			}
			// assigning curr to prev
			prev = curr;
		}
		System.out.println(max + " " + end);
		if (end != -1) answer = str1.substring(end - max + 1, end + 1);
		System.out.println(answer);
	}
```

### Approach 3

tabulation or top-down approach this problem is almost similar to the longest common subsequence problem, but when the characters don't match at that time, we have to directly set the value to 0 similar to the longest common subsequence this is the extra stuff that we are doing to store the result unlike LCS the substring can be found anywhere in between the strings not the end

```java
	private static void type3() {
		String str1 = "abcdefxmno";
		String str2 = "mabcxmno";
		char[] arr1 = str1.toCharArray(), arr2 = str2.toCharArray();
		int n1 = arr1.length, n2 = arr2.length;
		int[][] dp = new int[n1 + 1][n2 + 1];
		int max = 0, end = -1;
		String answer = "";
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++)
				if (arr1[i - 1] == arr2[j - 1]) {
					// similar to the longest common subsequence
					dp[i][j] = 1 + dp[i - 1][j - 1];
					// this is the extra stuff that we are doing to store the result
					// unlike LCS the substring can be found anywhere in between the strings not the end
					if (max < dp[i][j]) {
						max = dp[i][j];
						end = i - 1;
					}
				} else
					dp[i][j] = 0; // it will directly be 0, as we are considering string, and we cannot just cut a letter
		}
		System.out.println(max + " " + end);
		if (end != -1) answer = str1.substring(end - max + 1, end + 1);
		System.out.println(answer);
	}
}
```

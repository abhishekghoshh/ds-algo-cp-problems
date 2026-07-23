# LongestPalindromicSubstring

**Topic:** `string`  
**Tags:** Array, String, Two Pointer, Dynamic programming, Manacher Algorithm

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/longest-palindromic-substring/description/)
- [📄 NeetCode](https://neetcode.io/problems/longest-palindromic-substring)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/longest-palindromic-substring_758900)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=XYQecbcd6_c → two pointers)
- [▶ YouTube](https://www.youtube.com/watch?v=ZJUGtWObroc → two pointers)
- [▶ YouTube](https://www.youtube.com/watch?v=UflHuQj6MVA → Dynamic Programming)
- [▶ YouTube](https://youtube.com/watch?v=fxwvVnBMN6I → Dynamic Programming)
- [▶ YouTube](https://www.youtube.com/watch?v=XYQecbcd6_c)
- [▶ YouTube](https://www.youtube.com/watch?v=06QIlUBLTz4 → Manachers algorithm)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/longest-palindromic-substring/)

## 📝 Problem Statement

and that palindrome is the largest palindrome or not

## 💡 Approaches

This problem can be solved in **5** different ways, each improving upon the previous:

### Approach 5: 🏆 Optimal Solution

check the previous type and this type one more optimized manacher algorithm, check the previous type first the intuition is, along with the brute force if we can give lps some initial value then we have less work while expanding lets say the string is pqpqpqp so it will be transformed into @ # p # q # p # q # p # q # p # & 0 0 1 0 3 0 5 0 7 ........

we have only calculated till that middle q, and its value is 7 that mean left 7 of q is same as right 7 now we are at the first p after q, can we use the left p value to give kickstart to the right p pf q it is possible. in the start, we will add @, and in the end we will add &, we will add # in between initializing the transformed array, if the actual array is "babad" then the transformed array is "@#b#a#b#a#d#&" starting and ending character is different the center mean the index of the mirror and the right means the boundary every time we will try to update the center and range or check if the current index is within the current center and its right range or not the left side reflection point of the current index based on the center if the current index is still in the range, then only we will consider for giving the kickstart.

if the lps value is greater than the distance from current index to previous center's right side range, then we will cap the lps value of the current index to the distance remaining to the right range brute force approach to expand beyond the kickstart now we will check if we can update the center and the right range or not if the current index's expansion is greater the previous center's right range, then we will make the current index as the new center

**Time Complexity:** `O(2n)`

```java
	private static void type5() {
		String s = "babab";
		String ans = longestPalindrome5(s);
		System.out.println(ans);
	}

	private static String longestPalindrome5(String s) {
		int n = 2 * s.length() + 3;
		// in the start, we will add @, and in the end we will add &, we will add # in between
		// initializing the transformed array, if the actual array is "babad"
		// then the transformed array is "@#b#a#b#a#d#&"
		char[] arr = new char[n];
		for (int i = 0; i < s.length(); i++) {
			arr[2 * i + 1] = '#';
			arr[2 * i + 2] = s.charAt(i);
		}
		arr[n - 2] = '#';
		// starting and ending character is different
		arr[0] = '@';
		arr[n - 1] = '&';

		int[] lps = new int[n];

		// the center mean the index of the mirror and the right means the boundary
		int center = 0, maxRightCalculated = 0;

		// every time we will try to update the center and range
		// or check if the current index is within the current center and its right range or not
		for (int i = 2; i < n - 2; i++) {
			// the left side reflection point of the current index based on the center
			int reflectionOnLeft = center - (i - center);
			// if the current index is still in the range, then only we will consider for giving the kickstart.
			// if the lps value is greater than the distance from current index to previous center's right side range,
			// then we will cap the lps value of the current index to the distance remaining to the right range
			if (i < maxRightCalculated) lps[i] = Math.min(lps[reflectionOnLeft], maxRightCalculated - i);
			// brute force approach to expand beyond the kickstart
			while (arr[i + 1 + lps[i]] == arr[i - 1 - lps[i]])
				lps[i]++;
			// now we will check if we can update the center and the right range or not
			// if the current index's expansion is greater the previous center's right range,
			// then we will make the current index as the new center
			if (i + lps[i] > maxRightCalculated) {
				center = i;
				maxRightCalculated = i + lps[i];
			}
		}
		int index = -1, count = -1;
		for (int i = 0; i < n; i++) {
			if (lps[i] > count) {
				count = lps[i];
				index = i;
			}
		}
		int start = (index - count - 1) / 2;
		return s.substring(start, start + count);
	}
```

### Approach 4

this is brute force of manacher algorithm this is similar to our brute force algorithm, on every point we are intuition is for every point in string we will place a mirror and try to expand we will place it on the characters as well as we will place it on the empty spaces.

it is possible theoretically, but in programming we need something to place the mirror. so we will transform the string and place # in between every character, and we will use @ as string character and & as ending character. for every point we will think it is in the center, and we will start calculating the longest palindrome string from that point for very point there are two options to calculate palindrome 1.

to take the mirror on point 2. to take the mirror next to the point aba -> if we are at point b then mirror can be at two places -> a|a or ab|a, in the start, we will add @, and in the end we will add &, we will add # in between initializing the transformed array, if the actual array is "babad" then the transformed array is "@#b#a#b#a#d#&" starting and ending character is different int array for a longest palindrome string length array we don't need to calculate for the first two and last two characters lps[i] is initially 0, and if the char matches then we will increment the ith position for this type, we can simply use a variable instead of lps array, and it will work the same.

for the next type it will make sense #x#p#x# for this substring it will expand till #p# or lps[i] will be 1 this 1 is because it is starting from p which is single digit character. if string #a#p#a# then lps[i] will be 3 for apa substring. this might be confusing to understand that we are adding p on both sides, but we are only adding +1 it is because we have already added +1 for the # now we will find the max count in lps array

```java
	private static void type4() {
		String s = "babad";
		int count = longestPalindrome4(s);
		System.out.println(count);
	}

	private static int longestPalindrome4(String s) {
		int n = 2 * s.length() + 3;
		// in the start, we will add @, and in the end we will add &, we will add # in between
		// initializing the transformed array, if the actual array is "babad"
		// then the transformed array is "@#b#a#b#a#d#&"
		char[] arr = new char[n];
		for (int i = 0; i < s.length(); i++) {
			arr[2 * i + 1] = '#';
			arr[2 * i + 2] = s.charAt(i);
		}
		arr[n - 2] = '#';
		// starting and ending character is different
		arr[0] = '@';
		arr[n - 1] = '&';
		// int array for a longest palindrome string length array
		int[] lps = new int[n];
		// we don't need to calculate for the first two and last two characters
		for (int i = 2; i < n - 2; i++) {
			// lps[i] is initially 0, and if the char matches then we will increment the ith position
			// for this type, we can simply use a variable instead of lps array, and it will work the same.
			// for the next type it will make sense
			// #x#p#x# for this substring it will expand till #p# or lps[i] will be 1
			// this 1 is because it is starting from p which is single digit character.
			// if string #a#p#a# then lps[i] will be 3 for apa substring.
			// this might be confusing to understand that we are adding p on both sides, but we are only adding +1
			// it is because we have already added +1 for the #
			while (arr[i + 1 + lps[i]] == arr[i - 1 - lps[i]])
				lps[i]++;
		}
		PrintUtl.print(arr);
		PrintUtl.print(lps);
		// now we will find the max count in lps array
		return Arrays.stream(lps).max().getAsInt();
	}
```

### Approach 3

optimal approach using two pointer if you are using java don't directly operate on string rather create one array of character as String.charAt is computationally expensive odd length palindrome, when we are considering the odd length palindrome, and the center is (i,i) even length palindrome, when we are considering the even length palindrome, and the center is (i,i+1) checking the total string length

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
	private static void type3() {
		String s = "babad";
		String ans = longestPalindrome3(s);
		System.out.println(ans);
	}

	private static String longestPalindrome3(String s) {
		char[] arr = s.toCharArray();
		int start = 0, max = 0, len;
		for (int i = 0; i < arr.length; i++) {
			// odd length palindrome, when we are considering the odd length palindrome, and the center is (i,i)
			int len1 = expand(i, i, arr);
			// even length palindrome, when we are considering the even length palindrome, and the center is (i,i+1)
			int len2 = expand(i, i + 1, arr);
			len = Math.max(len1, len2);
			// checking the total string length
			if (len > max) {
				max = len;
				start = i - (len - 1) / 2;
			}
		}
		return s.substring(start, start + max);
	}

	static int expand(int l, int r, char[] arr) {
		int n = arr.length;
		while (l >= 0 && r < n && arr[l] == arr[r]) {
			l--;
			r++;
		}
		return r - l - 1;
	}
```

### Approach 2

Using dynamic programming, check type7 from longest palindromic subsequence We could also use it same say we have done in type7, we could also use 1D array for space optimization Also the approach of longest palindromic subsequence will not work here we will have to think it like a fresh new problem let's say we have a sub string bcbb inside the string 'abbcbba' to check check bcbb is a palindrome we need to check that first char == last char if it false then no matter what is the inner string, it will not be palindrome.

or we can say dp[i][j] = if arr[i]==arr[j] and dp[i+1][j-1]!=0 then 2 + dp[i+1][j-1] else 0 it will handle all the string but 1 and 2 length string we need to manually do that. in recursion that will be essentially our base cases we could use a boolean array here also, and that would be more efficient this is to handle all single digit characters; they are by default palindrome now we will handle 2-length substring checking for the max simultaneously now we will do generalization, we will start with 3 character strings, and eventually we will check till n we will check 2 conditions, i.e., last letters are the same or not and inner substring is palindrome

```java
	private static void type2() {
		String s = "babad";
		String answer = longestPalindrome2(s);
		System.out.println(answer);
	}

	private static String longestPalindrome2(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		int[][] dp = new int[n][n];
		int max = 1, start = 0;

		// this is to handle all single digit characters; they are by default palindrome
		for (int i = 0; i < n; i++) dp[i][i] = 1;
		// now we will handle 2-length substring
		for (int i = 0; i + 1 < n; i++) {
			dp[i][i + 1] = (arr[i] == arr[i + 1]) ? 2 : 0;
			// checking for the max simultaneously
			if (dp[i][i + 1] > max) {
				max = dp[i][i + 1];
				start = i;
			}
		}
		// now we will do generalization,
		// we will start with 3 character strings, and eventually we will check till n
		for (int d = 3; d <= n; d++) {
			for (int i = 0; i + d <= n; i++) {
				int end = i + d - 1;
				// we will check 2 conditions, i.e., last letters are the same or not and inner substring is palindrome
				if (arr[i] == arr[end] && dp[i + 1][end - 1] != 0) {
					dp[i][end] = 2 + dp[i + 1][end - 1];
					// checking for the max simultaneously
					if (dp[i][end] > max) {
						max = dp[i][end];
						start = i;
					}
				}
			}
		}
		return s.substring(start, start + max);
	}
```

### Approach 1: 🔨 Brute Force

brute force approach uses a n^2 loop, and for every (i,j) we will check if the substring is palindrome or not and that palindrome is the largest palindrome or not

```java
	private static void type1() {

	}
}
```

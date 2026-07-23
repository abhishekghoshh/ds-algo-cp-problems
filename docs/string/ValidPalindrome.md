# ValidPalindrome

**Topic:** `string`  
**Tags:** String, Array, Two pointer

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/valid-palindrome/description/)
- [📄 NeetCode](https://neetcode.io/problems/is-palindrome)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=jJXJ16kPFWg)

## 📝 Problem Statement

Practice coding interviews with structured courses, AI-driven interviews, head-to-head Versus mode, and 800+ problems. Free and Pro tiers.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

we will directly check it from the array two pointer approach skipping left and right until we find any digit or letter checking both the character on left and right sides

```java
	private static void type2() {
		String s = "A man, a plan, a canal: Panama";
		boolean isPalindrome = isPalindrome2(s);
		System.out.println(isPalindrome);
	}

	private static boolean isPalindrome2(String s) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		int left = 0, right = n - 1;
		boolean isPalindrome = true;
		while (left < right) {
			// skipping left and right until we find any digit or letter
			while (left < n && !isLetterOrDigit(arr[left])) left++;
			while (right >= 0 && !isLetterOrDigit(arr[right])) right--;
			// checking both the character on left and right sides
			if (left < right && toLowerCase(arr[left]) != toLowerCase(arr[right]))
				return false;
			left++;
			right--;
		}
		return isPalindrome;
	}
```

### Approach 1: 🔨 Brute Force

if it is letter then add it if it is digit then add it

```java
	private static void type1() {
		String s = "A man, a plan, a canal: Panama";
		boolean isPalindrome = isPalindrome(s);
		System.out.println(isPalindrome);
	}

	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			// if it is letter then add it
			if (Character.isLetter(ch))
				sb.append(toLowerCase(ch));
			// if it is digit then add it
			if (Character.isDigit(ch))
				sb.append(ch);
		}
		StringBuilder reversed = new StringBuilder(sb).reverse();
		return sb.compareTo(reversed) == 0;
	}

}
```

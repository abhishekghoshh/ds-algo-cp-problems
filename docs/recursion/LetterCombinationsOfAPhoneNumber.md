# LetterCombinationsOfAPhoneNumber

**Topic:** `recursion` | **File:** `com/problems/recursion/LetterCombinationsOfAPhoneNumber.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/)
- [📄 NeetCode](https://neetcode.io/problems/combinations-of-a-phone-number)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/letter-phone_626178)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=0snEunUacZY)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Little optimized from the last solution but the approach is same we will use a 2d array instead of a hashmap

```java
private static void type2() {
		String digits = "23";
		List<String> list = letterCombinations2(digits);
		System.out.println(list);
	}
	private static List<String> letterCombinations2(String digits) {
		List<String> list = new ArrayList<>();
		int n = digits.length();
		char[] bucket = new char[n];
		letterCombinations(0, digits.toCharArray(), list, bucket);
		return list;
	}
	private static void letterCombinations(int i, char[] digits, List<String> list, char[] bucket) {
		// if we have reached the end of the digits, then add the string to the answer
		if (i == digits.length) {
			list.add(new String(bucket));
			return;
		}
		int digit = digits[i] - '0';
		char[] values = keypadValues[digit];
		for (char ch : values) {
			bucket[i] = ch;
			letterCombinations(i + 1, digits, list, bucket);
		}
	}
```

### Approach 1 — Brute Force

Using the backtracking the key pad values are stored in a hashmap we are just creating a String builder, and each time we are adding one character and after using that we are just removing that

```java
private static void type1() {
		String digits = "23";
		List<String> answer = letterCombinations1(digits);
		System.out.println(answer);
	}
	private static List<String> letterCombinations1(String digits) {
		char[] arr = digits.toCharArray();
		List<String> answer = new ArrayList<>();
		letterCombinations1(0, arr, answer, new StringBuilder());
		return answer;
	}
	public static void letterCombinations1(int i, char[] digits, List<String> answer, StringBuilder sb) {
		int n = digits.length;
		// if we have reached the end of the digits, then add the string to the answer
		if (i == n) {
			answer.add(sb.toString());
			return;
		}
		List<Character> letters = keys.get(digits[i]);
		for (char ch : letters) {
			sb.append(ch);
			letterCombinations1(i + 1, digits, answer, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
```

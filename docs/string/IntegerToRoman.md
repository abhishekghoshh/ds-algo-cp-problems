# IntegerToRoman

**Topic:** `string` | **File:** `com/problems/string/IntegerToRoman.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/integer-to-roman/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ohBNdSJyLh8)
- [▶ YouTube](https://www.youtube.com/watch?v=Rsq1ObYg6ak)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
		int num = 2994;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				res.append(romans[i]);
			}
		}
		System.out.println(res);
	}
```

### Approach 1 — Brute Force

We have added all the points and also some of the other points We have some standard values that we will be adding Symbol Value I 1 V 5 X 10 L 50 C 100 D 500 M 1000 but apart from this we have to think about some other consideration like for 4 the Roman representation is IV not IIII so we have to add some the points in between so for every point we will be adding one less than the number like 4 for 5 40 for 50 90 for 100 400 for 500

```java
private static void type1() {
		int num = 2994;
		StringBuilder sb = new StringBuilder();
		for (int i = points.length - 1; i >= 0; i--) {
			if (points[i].value <= num) {
				for (int j = 0; j < num / points[i].value; j++) {
					sb.append(points[i].key);
				}
				num = num % points[i].value;
			}
		}
		System.out.println(sb);
	}
```

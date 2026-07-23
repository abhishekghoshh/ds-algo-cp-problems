# OddOrEven

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/OddOrEven.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/odd-even_7993579)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/odd-or-even3618/1)

## Approaches

Implementation:

### Implementation

Given a positive integer N, determine whether it is odd or even. suppose n = 1101 in binary so we & with 1 then 1101 & 1 => 1101 & 0001 => 1 if it is 1 then it is odd else even 1 means all bits are zero only the right most bit is 1

```java
private static void type1() {
		int n = 78;
		int lsb = n & 1;
		String ans = lsb == 0 ? "even" : "odd";
		System.out.println(ans);
	}
```

# RandomizedSetProblem

**Topic:** `array` | **File:** `com/problems/array/RandomizedSetProblem.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/insert-delete-getrandom-o1/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=j4KwhBziOpg)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
		RandomizedSet randomizedSet = new RandomizedSet();
		randomizedSet.insert(1);
		randomizedSet.insert(10);
		randomizedSet.insert(20);
		randomizedSet.insert(30);
		for (int i = 0; i < 10; i++) System.out.println(randomizedSet.getRandom());
	}
```

# NextAlphabeticalElement

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=X45c37QMdX0&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=12)

## 📝 Problem Statement

Find the next alphabetical element greater than a given character.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
	private static void type2() {
		char[] letters = {'a', 'b', 'm', 'n', 'x', 'x', 'x', 'y', 'z'};
		char target = 'x';
		int low = 0, high = letters.length - 1, mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (letters[mid] <= target) low = mid + 1;
			else high = mid - 1;
		}
		char result = low != letters.length ? letters[low] : letters[0];
		System.out.println(result);
	}
}
```

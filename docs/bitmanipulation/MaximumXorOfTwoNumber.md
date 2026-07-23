# MaximumXorOfTwoNumber

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimize-xor/)

## 📝 Problem Statement

Given two positive integers num1 and num2, find the positive integer x such

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

first find the count of the 2nd number we know xor of 1 and 1 is 0 so if we have to create a 2nd number in order to make minimum xor value we have to unset the left most bits as they has the higher value so we will start from the left and place the 1 at same position where 1 can be found in first num if the there is some more 1 left to place we will place it from the right to have to minimum xor value

```java
	private static void type1() {
		int num1 = 3;
		int num2 = 5;
		int count = 0, num2Copy = num2;
		// first find the count of the 2nd number
		while (num2Copy != 0) {
			num2Copy = num2Copy & (num2Copy - 1);
			count++;
		}
		int mask = 1 << 30;
		int num = 0;
		// we know xor of 1 and 1 is 0
		// so if we have to create a 2nd number in order to make minimum xor value
		// we have to unset the left most bits as they has the higher value
		// so we will start from the left and place the 1 at same position where 1 can
		// be found in first num
		for (int i = 30; i >= 0 && count > 0; i--) {
			if ((num1 & mask) != 0) {
				num += mask;
				count--;
			}
			mask = mask >> 1;
		}
		mask = 1;
		// if the there is some more 1 left to place we will place it from the right
		// to have to minimum xor value
		while (count != 0) {
			if ((num & mask) == 0) {
				num = num | mask;
				count--;
			}
			mask = mask << 1;
		}
		System.out.println(num);
	}

}
```

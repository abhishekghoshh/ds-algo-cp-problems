# ExtractTheLeftMostSetBit

**Topic:** `bitmanipulation`  

## 📝 Problem Statement

Extract the leftmost set bit of a number.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

complexity O(1) suppose our number is 0000010001100 then our ans will be 0000010000000 if somehow we can set all the bits after the left most set bit like 0000011111111 then we can just +1 to that which will give us 0000100000000 then we can just right right shift once int n = (1 << 30) + 5; we are actually copying the left most set bit and copying that to last if the number is 0000010001100 then after this operation it will become 0000011001100 after this operation it will become 0000011111100 after this operation it will become 0000011111111 as integer is 32 bits thats why we are doing till 16

```java
	private static void type3() {
//		int n = (1 << 30) + 5;
		int n = 140;
		if (n >= (1 << 30)) {
			System.out.println("index is 30  mask is " + Integer.toBinaryString(1 << 30));
			return;
		}
		// we are actually copying the left most set bit and copying that to last
		// if the number is 0000010001100
		n = n | (n >> 1);
		// then after this operation it will become 0000011001100
		n = n | (n >> 2);
		// after this operation it will become 0000011111100
		n = n | (n >> 4);
		// after this operation it will become 0000011111111
		// as integer is 32 bits thats why we are doing till 16
		n = n | (n >> 8);
		n = n | (n >> 16);
		int mask = (n + 1) >> 1;
		System.out.println("mask is " + Integer.toBinaryString(mask));
	}
```

### Approach 2

binary search approach complete the remianing there is a issue

**Time Complexity:** `O(log(32)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		int n = 1;
		int low = 2;
		int high = 30;
		int mid = -1, mask;
		while (low <= high) {
			mid = low + ((high - low) >> 1);
			mask = 1 << mid;
			if (n >= mask) {
				low = mid + 1;
			} else if (n < mask) {
				high = mid - 1;
			}
		}
		System.out.println(mid);
	}
```

### Approach 1: 🔨 Brute Force

brute force apprach from the 30th bit we will check until we find any set bit we have found our set bit we can break here

```java
	private static void type1() {
		int n = 140;
		int mask = 1 << 30;
		int i = 30;
		while (mask != 0) {
			if ((n & mask) != 0) {
				// we have found our set bit
				// we can break here
				break;
			}
			mask = mask >> 1;
			i--;
		}
		System.out.println("index is " + i + " mask is " + Integer.toBinaryString(mask));
	}

}
```

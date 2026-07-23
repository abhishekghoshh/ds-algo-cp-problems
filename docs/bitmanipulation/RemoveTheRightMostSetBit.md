# RemoveTheRightMostSetBit

**Topic:** `bitmanipulation`  

## 📝 Problem Statement

so first we have to find the bit where 1 is present

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

most optimized approach Intuition when we subtract 1 from any number then what we do exactly suppose n = 101100 n-1 = 101011 when we do -1 then it will borrow 1 from the right most set bit like 100-001 => 011 and if we look closely between n and n-1 then we will find that the bits which is in the left of (right most set bit) remains intact and bit from the (right most set bit) just toggled now if we do an and(&) operation then everything in right will be cleared out

**Time Complexity:** `O(1)`

```java
	private static void type3() {
		int n = 104;
		n = n & (n - 1);
		System.out.println(n);
	}
```

### Approach 2

same as type1 rather than changing the input we can also change the mask we can right shift the mask till it reaches the first 1 once mask reaches the first set bit and val will be other than 0 we need to shift left

**Time Complexity:** `O(log(n)`

```java
	private static void type2() {
		int n = 104;
		// rather than changing the input we can also change the mask
		// we can right shift the mask till it reaches the first 1
		int mask = 1;
		// once mask reaches the first set bit and val will be other than 0
		while ((n & mask) == 0) {
			// we need to shift left
			mask = mask << 1;
		}
		n = n & (~mask);
		System.out.println(n);
	}
```

### Approach 1: 🔨 Brute Force

suppose n = 100110 so after extracting n will be 100100 so first we have to find the bit where 1 is present x&1 will tell that last bit is 1 or not that means last bit 0 we will right shift by one now we know the position so we can create the mask our mask will clear the ith bit we know how to do that

```java
	private static void type1() {
		int n = 104;
		int x = n, i = 0;
		// x&1 will tell that last bit is 1 or not
		while ((x & 1) == 0) {
			// that means last bit 0
			// we will right shift by one
			x = x >> 1;
			i++;
		}
		// now we know the position
		// so we can create the mask
		// our mask will clear the ith bit
		// we know how to do that
		int mask = ~(1 << i);
		n = n & mask;
		System.out.println(n);
	}

}
```

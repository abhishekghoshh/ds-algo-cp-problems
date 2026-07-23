# ExtractTheRightMostSetBit

**Topic:** `bitmanipulation`  

## 📝 Problem Statement

Extract the rightmost set bit of a number.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

this is almost the same as the previous type. we can derive any number that has 1 as a1b, where a can be any number of 0/1, and b is 0 if try to find the -x which will be 2's complement of x. -x = 2's comp x => ~x +1 => a~0b~ +1 => a~1b (b~ is all 1's 0b~ +1 will be 1b) -x = a~1b now x & (-x) => a1b & a~1b => 1b

```java
	private static void type3() {
		int n = 104;
		int ans = n & (-n);
		System.out.println(ans);
	}
```

### Approach 2

optimized approach suppose n = 101100 so our and will be 000100 this problem is similar to remove the last set bit n-1 will be 101011 if we see here the bit in left is same in a bit in right changes to 1 and the right most set bit became 0 if we reverse it then it will use 010100 in ~(n-1) all bits are different except the right set a bit so if we so do a and operation then we will get our mask

**Time Complexity:** `O(1)`

```java
	private static void type2() {
		int n = 104;
		int mask = n & (~(n - 1));
		System.out.println(mask);
	}
```

### Approach 1: 🔨 Brute Force

brute force approach suppose n = 101100 so our ans will be 000100 so we can create a mask and perform and operation until it's value become other than 0 we have not found the 1 bit, yet we have to go to left by one bit

**Time Complexity:** `O(log(n)`

```java
	private static void type1() {
		int n = 104;
		int mask = 1;
		while ((n & mask) == 0) {
			// we have not found the 1 bit, yet we have to go to left by one bit
			mask = mask << 1;
		}
		System.out.println(mask);
	}

}
```

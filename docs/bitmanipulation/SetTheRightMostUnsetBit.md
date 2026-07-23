# SetTheRightMostUnsetBit

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/set-the-rightmost-unset-bit_8160456)
- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

Write your code here.

```java
	private static void type2() {
		int n = 10;
		System.out.println(Integer.toBinaryString(n));
		int answer = setRightMostUnsetBit(n);
		System.out.println(answer);
		System.out.println(Integer.toBinaryString(answer));
	}

	public static int setRightMostUnsetBit(int n) {
		// Write your code here.
		int copy = n;
		int mask = 1;
		while (copy != 0 && (copy & 1) == 1) {
			mask = (mask << 1);
			copy = copy >> 1;
		}
		return copy == 0 ? n : (n | mask);
	}
```

### Approach 1: 🔨 Brute Force

```java
	private static void type1() {
		int n = 1279;
		int N = setBit(n);
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(N));
	}

	// TODO check later
	static int setBit(int n) {
		for (int i = 0; i < 32; i++) {
			int num = (1 << i) | n;
			if ((1 << i) > n) return n;
			if (num != n) return num;
		}
		return n;
	}
}
```

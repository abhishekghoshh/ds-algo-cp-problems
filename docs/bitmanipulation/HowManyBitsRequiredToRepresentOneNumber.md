# HowManyBitsRequiredToRepresentOneNumber

**Topic:** `bitmanipulation`  

## 📝 Problem Statement

Find how many bits are needed to represent a number.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

when base is 2

```java
	private static void type3() {
		int n = 100;
		int bitsRequired = 0;
		while (n != 0) {
			bitsRequired++;
			n = (n >> 1);
		}
		System.out.println("bits required is " + bitsRequired);
	}
```

### Approach 2

optimized approach

```java
	private static void type2() {
		int n = 100;
		int base = 2;
		int bitsRequired = 0, bound = 1;
		while (bound <= n) {
			bitsRequired++;
			bound *= base;
		}
		System.out.println("bits required is " + bitsRequired);
	}
```

### Approach 1: 🔨 Brute Force

for in general

```java
	private static void type1() {
		int n = 100;
		int base = 2;
		int bitsRequired = 1 + (int) (Math.log(n) / Math.log(base));
		System.out.println("bits required is " + bitsRequired);
	}

}
```

# NegativeOfNumber

**Topic:** `bitmanipulation`  

## 📝 Problem Statement

so we can represent 256 numbers with this

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
	private static void type1() {
		int n = 278;

		System.out.println("(n) : " + toBinaryString(n));
		System.out.println("(~n): " + toBinaryString(~n));
		System.out.println("(~n) + 1 : " + toBinaryString((~n) + 1));

		int nOn = (~n) + 1;
		System.out.println(n + " : " + nOn);
	}

	private static String toBinaryString(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 32; i++) {
			sb.append(n & 1);
			n = n >>> 1;
		}
		return sb.reverse().toString();
	}

}
```

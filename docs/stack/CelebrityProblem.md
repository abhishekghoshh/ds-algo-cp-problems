# CelebrityProblem

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-the-celebrity/)
- [📄 Coding Ninjas](https://www.codingninjas.com/codestudio/problems/the-celebrity-problem_982769)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Z5AEc12ieOs)
- [▶ YouTube](https://www.youtube.com/watch?v=CiiXBvrX-5A)

## 📝 Problem Statement

A celebrity is a person known to all but does not know anyone at a

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

if matrix[i][j] == 1 then i knows j so i is not celebrity if both matrix[i][j] and matrix[j][i] is 0 then both are not celebrity everybody should know the celebrity at last we will cross check that our assumption is correct or not so we will check the false conditions matrix[c][i] == 1 means c knows i so c is not celebrity matrix[i][c] == 0 means i does not know c, so c is not celebrity

```java
	private static void type3() {
		int[][] matrix = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		int n = 3;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) stack.push(i);
		while (stack.size() >= 2) {
			int p1 = stack.pop();
			int p2 = stack.pop();
			// if matrix[i][j] == 1 then i knows j so i is not celebrity
			// if both matrix[i][j] and matrix[j][i] is 0 then both are not celebrity
			// everybody should know the celebrity
			if (matrix[p1][p2] == 1) stack.push(p2);
			else stack.push(p1);

		}
		int c = stack.pop();
		// at last we will cross check that our assumption is correct or not
		for (int i = 0; i < n; i++) {
			// so we will check the false conditions
			// matrix[c][i] == 1 means c knows i so c is not celebrity
			// matrix[i][c] == 0 means i does not know c, so c is not celebrity
			if (i != c && (matrix[c][i] == 1 || matrix[i][c] == 0)) {
				c = -1;
				break;
			}
		}
		System.out.println(c + " th person is celebrity");
	}
```

### Approach 2

we will assume that 0th person is a celebrity and update it once they know anyone that means c knows i so c is not a celebrity, so we will i as a celebrity at last, we will cross-check that our assumption is correct or not so we will check the false conditions matrix[c][i] == 1 means c knows i so c is not celebrity matrix[i][c] == 0 means i does not know c, so c is not celebrity

```java
	private static void type2() {
		int[][] matrix = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		int n = 3;
		// we will assume that 0th person is a celebrity and update it once they know anyone
		int c = 0;
		for (int i = 1; i < n; i++)
			// that means c knows i
			// so c is not a celebrity,
			// so we will i as a celebrity
			if (matrix[c][i] == 1) c = i;

		// at last, we will cross-check that our assumption is correct or not
		for (int i = 0; i < n; i++) {
			// so we will check the false conditions
			// matrix[c][i] == 1 means c knows i so c is not celebrity
			// matrix[i][c] == 0 means i does not know c, so c is not celebrity
			if (i != c && (matrix[c][i] == 1 || matrix[i][c] == 0)) {
				c = -1;
				break;
			}
		}
		System.out.println(c + " th person is celebrity");
	}
```

### Approach 1: 🔨 Brute Force

brute force approach it means how many persons know him it means he knows how many persons it means i know j

**Time Complexity:** `O(n^2 + n)`
**Space Complexity:** `O(2n)`

```java
	private static void type1() {
		int[][] matrix = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
		int n = 3;
		// it means how many persons know him
		int[] in = new int[n];
		// it means he knows how many persons
		int[] out = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				// it means i know j
				if (matrix[i][j] == 1) {
					out[i]++;
					in[j]++;
				}
		}
		int c = -1;
		for (int i = 0; i < n; i++)
			if (out[i] == 0 && in[i] == n - 1) c = i;
		System.out.println(c + " th person is celebrity");
	}

}
```

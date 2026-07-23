# TowerOfHanoi

**Topic:** `recursion`  

## 📝 Problem Statement

Solve the Tower of Hanoi puzzle: move n disks from source to destination using an auxiliary rod. Only smaller disks can be placed on larger disks.

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=tZELBt_y50o)

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

```java
	private static void type3() {
	}
```

### Approach 2

this is not an optimal approach

```java
	private static void type2() {
		int totalDisks = 3;
		char fromDisk = 'A';
		char toDisk = 'B';
		char extraDisk = 'C';
		shift(totalDisks, fromDisk, toDisk, extraDisk);
	}
```

### Approach 1: 🔨 Brute Force

Our job is to move n disk from A disk to B disk, and we have one extra C disk we can divide the task in three parts first move the n-1 from A -> C then move nth disk from A-> B then move that n-1 disks from C->B if there is no disk to move move the n-1 from A -> C move nth disk from A-> B move that n-1 disks from C->B


```java
	private static void type1() {
		int totalDisks = 2;
		int fromDisk = 1;
		int toDisk = 2;
		int extraDisk = 3;
		long count = toh(totalDisks, fromDisk, toDisk, extraDisk);
		System.out.println(count);
	}

	private static long toh(int n, int fromDisk, int toDisk, int extraDisk) {
		// if there is no disk to move
		if (n == 1) {
			System.out.println("move disk " + n + " from rod " + fromDisk + " to rod " + toDisk);
			return 1;
		}
		long count = 1;
		// move the n-1 from A -> C
		count += toh(n - 1, fromDisk, extraDisk, toDisk);
		// move nth disk from A-> B
		System.out.println("move disk " + n + " from rod " + fromDisk + " to rod " + toDisk);
		// move that n-1 disks from C->B
		count += toh(n - 1, extraDisk, toDisk, fromDisk);

		return count;
	}

	private static void shift(int totalDisks, char fromDisk, char toDisk, char extraDisk) {
		// if there is no disk to move
		if (totalDisks == 0) return;
		// move the n-1 from A -> C
		shift(totalDisks - 1, fromDisk, extraDisk, toDisk);
		// move nth disk from A-> B
		System.out.printf("Moving disk no: %d from %c disk to %c disk \n", totalDisks, fromDisk, toDisk);
		// move that n-1 disks from C->B
		shift(totalDisks - 1, extraDisk, toDisk, fromDisk);
	}

}
```

# MinimumMultiplicationsToReachEnd

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=_BvEJ3VIDWw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=39)
- [📄 takeUforward](https://takeuforward.org/graph/g-39-minimum-multiplications-to-reach-end/)

## 📝 Problem Statement

Given start, end and an array arr of n numbers. At each step, start is

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

using bfs, we don't have to store the level as we are increasing the level by 1 only as we know that all the item will range from 0 to pivot, so we can just use an array here we will not store the level in the queue, we will check the current level of the queue then add a new level

```java
	private static void type2() {
		int[] arr = { 2, 5, 7 };
		int start = 3;
		int end = 30;
		int ans = minimumMultiplications2(arr, start, end);
		System.out.println(ans);

	}

	static int minimumMultiplications2(int[] arr, int start, int end) {
		int PIVOT = 100000;
		int level = 0;

		// as we know that all the item will range from 0 to pivot,
		// so we can just use an array
		boolean[] set = new boolean[PIVOT + 1];
		set[start] = true;
		// here we will not store the level in the queue,
		// we will check the current level of the queue then add a new level
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int node = queue.poll();
				if (node == end) return level;
				for (int item : arr) {
					int mul = (node * item) % PIVOT;
					if (!set[mul]) {
						set[mul] = true;
						queue.offer(mul);
					}
				}
			}
			level++;
		}
		return -1;
	}
```

### Approach 1: 🔨 Brute Force

we will apply Dijkstra here, but we will use queue in place of Priority Queue, as we are going via level wise as we know that all the item will range from 0 to pivot, so we can just use an array we will store the multiplication and the level in the queue and everytime we will add new output and level+1 if the new output is not yet considered, then only we will store it in the queue

```java
	private static void type1() {
		int[] arr = { 2, 5, 7 };
		int start = 3;
		int end = 30;
		int ans = minimumMultiplications1(arr, start, end);
		System.out.println(ans);

	}

	static int minimumMultiplications1(int[] arr, int start, int end) {
		int PIVOT = 100000;
		// as we know that all the item will range from 0 to pivot, so we can just use an array
		boolean[] set = new boolean[PIVOT + 1];
		set[start] = true;
		Queue<int[]> queue = new LinkedList<>();
		// we will store the multiplication and the level in the queue
		// and everytime we will add new output and level+1
		queue.add(new int[]{start, 0});
		while (!queue.isEmpty()) {
			int[] pair = queue.poll();
			int node = pair[0];
			int lvl = pair[1];
			if (node == end) return lvl;
			for (int item : arr) {
				int mul = (node * item) % PIVOT;
				// if the new output is not yet considered, then only we will store it in the queue
				if (!set[mul]) {
					set[mul] = true;
					queue.offer(new int[]{mul, lvl + 1});
				}
			}
		}
		return -1;
	}
}
```

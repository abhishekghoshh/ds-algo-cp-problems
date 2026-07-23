# HeightOfBinaryTree

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/maximum-depth-of-binary-tree/description/)
- [📄 NeetCode](https://neetcode.io/problems/depth-of-binary-tree)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/height-of-binary-tree_4609628)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/841416)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=eD3tmO66aBA&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=15)
- [▶ YouTube](https://www.youtube.com/watch?v=aqLTbtWh40E&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=5)
- [▶ YouTube](https://www.youtube.com/watch?v=hTM3phVI6YQ)
- [📄 takeUforward](https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/)

## 📝 Problem Statement

it will use the recursion stack

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

level wise traversal using a queue take a integer level variable and increment that in every iteration as there is a root that is not null, that is why we are adding level as 1 n is the number of the node on that specific level, polling all the nodes in that level after polling all the nodes if the nodes are capable of adding its left or right node in the queue.

then queue will not be empty, and there should be a new level if there is any node added in queue, that means there will be a new level

```java
	private static void type2() {
		TNode root = TNode.withNodes(3, 9, 20, NULL, NULL, 15, 7);
		int height = height2(root);
		System.out.println(height);

	}

	private static int height2(TNode root) {
		if (null == root) return 0;
		Queue<TNode> queue = new LinkedList<>();
		// as there is a root that is not null, that is why we are adding level as 1
		int level = 1;
		queue.offer(root);
		while (!queue.isEmpty()) {
			// n is the number of the node on that specific level,
			// polling all the nodes in that level
			int n = queue.size();
			for (int i = 0; i < n; i++) {
				TNode node = queue.poll();
				if (null != node.left) queue.offer(node.left);
				if (null != node.right) queue.offer(node.right);
			}
			// after polling all the nodes
			// if the nodes are capable of adding its left or right node in the queue.
			// then queue will not be empty, and there should be a new level
			// if there is any node added in queue, that means there will be a new level
			if (!queue.isEmpty()) level++;
		}
		return level;
	}
```

### Approach 1: 🔨 Brute Force

using recursion, it will use the recursion stack

```java
	public static void type1() {
		TNode root = TNode.withNodes(3, 9, 20, NULL, NULL, 15, 7);
		int height = height1(root);
		System.out.println(height);
	}

	private static int height1(TNode root) {
		if (null == root) return 0;
		return 1 + Math.max(
				height1(root.left),
				height1(root.right)
		);
	}


}
```

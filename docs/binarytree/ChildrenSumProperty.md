# ChildrenSumProperty

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/children-sum-parent/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/children-sum-property_8357239)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=fnmisPM6cVo&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=30)
- [📄 takeUforward](https://takeuforward.org/data-structure/check-for-children-sum-property-in-a-binary-tree/)

## 📝 Problem Statement

Given a binary tree, find if it satisfies the&nbsp;Children Sum Property which has the following rules

Each non-leaf node must have a value equal to the&nbsp;sum&nbsp;of its&nbsp;left&nbsp;and&nbsp;right&nbsp;children&#x27;s values. 
A NULL child is cons

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

NOTE this is taken from striver video this problem is not in the geekforgeeks link study it later it will change the dynamics of the tree

```java
	private static void type2() {
		TNode root = TNode.withNodes(2, 35, 10, 2, 3, 5, 2);
		PrintUtl.print(root);
		reorder(root);
		PrintUtl.print(root);
	}

	// TODO study it later
	// it will change the dynamics of the tree
	private static void reorder(TNode root) {
		if (root == null) return;
		int child = 0;
		if (root.left != null) child += root.left.data;
		if (root.right != null) child += root.right.data;
		if (child < root.data) {
			if (root.left != null) root.left.data = root.data;
			else if (root.right != null) root.right.data = root.data;
		}
		reorder(root.left);
		reorder(root.right);
		int total = 0;
		if (root.left != null) total += root.left.data;
		if (root.right != null) total += root.right.data;
		if (root.left != null || root.right != null) root.data = total;
	}
```

### Approach 1: 🔨 Brute Force

this is a leaf node, and we will return its data only if the left data is -1 then in the left branch the already broken so, we will return -1 directly if the right data is -1 then in the right branch the already broken

```java
	private static void type1() {
		TNode root = TNode.withNodes(10, 10);
		boolean isSumProperty = isSumProperty(root) != -1;
		System.out.println(isSumProperty);
	}

	public static int isSumProperty(TNode root) {
		if (null == root) return 0;
		// this is a leaf node, and we will return its data only
		if (null == root.left && null == root.right) return root.data;
		int left = isSumProperty(root.left);
		// if the left data is -1 then in the left branch the already broken
		// so, we will return -1 directly
		if (left == -1) return -1;
		int right = isSumProperty(root.right);
		// if the right data is -1 then in the right branch the already broken
		// so, we will return -1 directly
		if (right == -1) return -1;
		return (left + right == root.data) ? root.data : -1;
	}

}
```

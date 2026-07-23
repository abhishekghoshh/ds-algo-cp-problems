# PrintRootToNodePath

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 InterviewBit](https://www.interviewbit.com/problems/path-to-given-node/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=fmflMqVOC7k&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=27)
- [📄 takeUforward](https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/)

## 📝 Problem Statement

Path to Given Node - Problem Description Given a Binary Tree A containing N nodes. You need to find the path from Root to a given node B. NOTE: * No two nodes in the tree have same data values. * You can assume that B is present in the tree A and a path always exists. Problem Constraints 1 &lt;= N &lt;= 105 1 &lt;= Data Values of Each Node &lt;= N 1 &lt;= B &lt;= N Input Format First Argument represents pointer to the root of binary tree A. Second Argument is an integer B denoting the node numbe

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

if node is null then we are unable to find the target if the current node is target or either in left subtree or right subtree we have found the target, then we will add the node to the current list and return true if we have not found the target, then we will simply return false

```java
	private static void type1() {
		TNode root = TNode.withCount(100);
		int target = 56;
		List<Integer> list = allRootToLeaf(root, target);
		System.out.println(list);
	}

	public static List<Integer> allRootToLeaf(TNode root, int target) {
		List<Integer> list = new ArrayList<>();
		find(root, target, list);
		reverse(list);
		return list;
	}

	private static boolean find(TNode root, int target, List<Integer> list) {
		// if node is null then we are unable to find the target
		if (null == root) return false;
		// if the current node is target or either in left subtree or right subtree we have
		// found the target, then we will add the node to the current list and return true
		if (root.data == target
				|| (find(root.left, target, list)
				|| find(root.right, target, list))) {
			list.add(root.data);
			return true;
		}
		// if we have not found the target, then we will simply return false
		return false;
	}

	private static void reverse(List<Integer> list) {
		int n = list.size();
		for (int i = 0; i < n / 2; i++) {
			int num1 = list.get(i);
			int num2 = list.get(n - i - 1);
			list.set(i, num2);
			list.set(n - i - 1, num1);
		}
	}

}
```

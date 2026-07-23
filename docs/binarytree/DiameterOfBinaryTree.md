# DiameterOfBinaryTree

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/diameter-of-binary-tree/description/)
- [📄 NeetCode](https://neetcode.io/problems/binary-tree-diameter)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/920552)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Rezetez59Nk&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=17)
- [▶ YouTube](https://www.youtube.com/watch?v=zmPj_Ee3B8c&list=PL_z_8CaSLPWfxJPz2-YKqL9gXWdgrhvdn&index=3)
- [▶ YouTube](https://www.youtube.com/watch?v=K81C31ytOZE)
- [📄 takeUforward](https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/)

## 📝 Problem Statement

we could either use a class level variable or send another object as a parameter in the method

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

simple problem with simple intuition we will compute height and side by we will compute the diameter, but we need to store the diameter individually we could either use a class level variable or send another object as a parameter in the method we're just computing the diameter and updating the diameter of a node is leftHeight + rightHeight

```java
	private static void type1() {
		TNode root = TNode.withCount(16);
		height(root);
		System.out.println(MAX_DIAMETER);
	}

	private static int MAX_DIAMETER = 0;

	private static int height(TNode root) {
		if (null == root) return 0;
		int leftH = height(root.left);
		int rightH = height(root.right);
		// we're just computing the diameter and updating the
		// diameter of a node is leftHeight + rightHeight
		MAX_DIAMETER = Math.max(MAX_DIAMETER, leftH + rightH);
		return 1 + Math.max(leftH, rightH);
	}

}
```

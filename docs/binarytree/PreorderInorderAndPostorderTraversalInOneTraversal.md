# PreorderInorderAndPostorderTraversalInOneTraversal

**Topic:** `binarytree` | **File:** `com/problems/binarytree/PreorderInorderAndPostorderTraversalInOneTraversal.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/981269)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ySp2epYvgTE&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=14)
- [📄 takeUforward](https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/)

## Approaches

Implementation:

### Implementation

Not so important TODO check it later

```java
private static void type1() {
		TNode root = TNode.withCount(19);
		List<Integer> preOrder = new ArrayList<>(), inOrder = new ArrayList<>(), postOrder = new ArrayList<>();

		Stack<Pair> stack = new Stack<>();
		stack.push(new Pair(root, 1));

		while (!stack.isEmpty()) {
			Pair pair = stack.pop();
			// this is part of preorder increment 1 to 2
			// push the left side of the tree
			if (pair.num == 1) {
				preOrder.add(pair.node.data);
				pair.num++;
				stack.push(pair);
				if (pair.node.left != null) stack.push(new Pair(pair.node.left, 1));
			} else if (pair.num == 2) {
				// this is a part of in increment 2 to 3 push right
				inOrder.add(pair.node.data);
				pair.num++;
				stack.push(pair);
				if (pair.node.right != null) stack.push(new Pair(pair.node.right, 1));
			} else {
				// don't push it back again
				postOrder.add(pair.node.data);
			}
		}
		System.out.println(preOrder);
		System.out.println(inOrder);
		System.out.println(postOrder);
	}
```

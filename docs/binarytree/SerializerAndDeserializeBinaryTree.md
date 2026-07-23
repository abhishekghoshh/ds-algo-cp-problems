# SerializerAndDeserializeBinaryTree

**Topic:** `binarytree` | **File:** `com/problems/binarytree/SerializerAndDeserializeBinaryTree.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/)
- [📄 NeetCode](https://neetcode.io/problems/serialize-and-deserialize-binary-tree)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/920328)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=-YbXySKJsX8&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=37)
- [▶ YouTube](https://www.youtube.com/watch?v=u4JAi2JJhI8)
- [📄 takeUforward](https://takeuforward.org/data-structure/serialize-and-deserialize-a-binary-tree/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

This is a very good problem TODO we are using preorder as we can get the root at the starting index everytime for deserializing we are not slitting the string into nodes rather we are working on string directly using one pointer and everytime we see a space we treat the next number as new node

```java
private static void type2() {
		TNode root = TNode.withObjectNodes(1, 2, 3, null, null, 4, 5);
		Codec2 codec = new Codec2();
		String data = codec.serialize(root);
		TNode outputNode = codec.deserialize(data);
		System.out.println(data);
		PrintUtl.inOrder(root);
		PrintUtl.inOrder(outputNode);
	}
```

### Approach 1 — Brute Force

It will go till we see a space which denoted end of the current node todo it is a very good approach Using BFS and not very complex this is done using level order

```java
private static void type1() {
		TNode root = TNode.withObjectNodes(1, 2, 3, null, null, 4, 5);
		Codec1 codec = new Codec1();
		String data = codec.serialize(root);
		TNode outputNode = codec.deserialize(data);
		System.out.println(data);
		PrintUtl.inOrder(root);
		PrintUtl.inOrder(outputNode);
	}
```

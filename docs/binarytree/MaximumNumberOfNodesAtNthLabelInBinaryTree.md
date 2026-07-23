# MaximumNumberOfNodesAtNthLabelInBinaryTree

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/number-of-nodes_8162204)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=_ANrF3FJm7I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=2)
- [▶ YouTube](https://www.youtube.com/watch?v=ctCpP0RFDFc&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=3)
- [▶ YouTube](https://www.youtube.com/watch?v=hyLyW7rP24I&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=4)

## 📝 Problem Statement

Given an integer i, the maximum number of nodes on level i of a binary tree.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

Given an integer i, the maximum number of nodes on level i of a binary tree.

```java
    private static void type1() {
        // Given an integer i, the maximum number of nodes on level i of a binary tree.
        int n = 5;
        int maxNodes = 1 << (n - 1);
        System.out.println(maxNodes);
    }
}
```

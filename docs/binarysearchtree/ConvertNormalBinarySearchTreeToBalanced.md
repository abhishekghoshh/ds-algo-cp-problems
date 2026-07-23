# ConvertNormalBinarySearchTreeToBalanced

**Topic:** `binarysearchtree`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/normal-bst-to-balanced-bst_920472)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ElUqyFsddvo)
- [▶ YouTube](https://www.youtube.com/watch?v=ceGBg3g18js)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/)

## 📝 Problem Statement

and while rebuilding the Balanced Binary Search Tree we could use the same nodes

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

This approach is pretty optimized first we will get the imbalanced tree and get the inorder traversal of the tree. The inOrder traversal always gives us the sorted list. Then with this inOrder traversal we can create a balanced BST it is very easy to create a balanced bst if the inorder is given rather creating a list of Integer we could use a list of Tree node we could directly save the tree node in the list and while rebuilding the Balanced Binary Search Tree we could use the same nodes it will make a balanced BST we will always make size/2 th element as root

```java
    private static void type1() {
        TNode root = TNode.imbalancedBST(16);
        PrintUtl.levelOrder(root);
        PrintUtl.inOrder(root);

        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        root = build(inorder, 0, inorder.size() - 1);

        PrintUtl.levelOrder(root);
        PrintUtl.inOrder(root);
    }

    private static void inorder(TNode root, List<Integer> inorder) {
        if (root == null) return;
        inorder(root.left, inorder);
        inorder.add(root.data);
        inorder(root.right, inorder);
    }

    // it will make a balanced BST
    // we will always make size/2 th element as root
    private static TNode build(List<Integer> nums, int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TNode left = build(nums, l, mid - 1);
        TNode right = build(nums, mid + 1, r);
        return new TNode(nums.get(mid), left, right);
    }
}
```

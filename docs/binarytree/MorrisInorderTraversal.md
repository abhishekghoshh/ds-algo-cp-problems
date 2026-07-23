# MorrisInorderTraversal

**Topic:** `binarytree`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/binary-tree-inorder-traversal/)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/inorder-traversal/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/inorder-traversal_3839605)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=80Zug6D1_r4&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=38)
- [📄 takeUforward](https://takeuforward.org/data-structure/morris-inorder-traversal-of-a-binary-tree/)

## 📝 Problem Statement

Inorder traversal using Morris traversal (O(1) space).

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

inorder traversal without using any extra space in order we know that after all the left node is completed then root node will be traversed, the last node of the left side will be the rightest node of the left side, so we will create a link between the rightest node and the root and if there is no left, then we will directly add to list and go to right if it has the left node, then we will manipulate the pointers we will go to the rightest node we have added another extra condition here, let's say we have already established left-last to root.

and now we are visiting the root, but again by the code logic, it will again to establish the connection to root-left-last to root so we have to check that if the connection is already there or not setting the link then, we will go to the left, we know that root will be visited at some point this is the first time we are visiting the node this is the second time we are visiting the node there was already a link, that means this is the second time we are in the root.

so the left part is traversed completely, and we will now delete the link and add the root to list as this is the inorder traversal, we will add the node when we second time visit the node that means we have visited the entire left subtree if there is no left subtree, then it will go directly to the right for the last node of left subtree, there was a link attached from the last-node.right=root this is the time when we will finally visit the root node

```java
    private static void type1() {
        TNode root = TNode.withCount(15);
        PrintUtl.inOrder(root);

        List<Integer> answer = inorderTraversal(root);
        System.out.println(answer);
    }

    private static List<Integer> inorderTraversal(TNode root) {
        List<Integer> list = new ArrayList<>();
        while (null != root) {
            // if it has the left node, then we will manipulate the pointers
            if (null != root.left) {
                TNode last = root.left;
                // we will go to the rightest node
                // we have added another extra condition here,
                // let's say we have already established left-last to root.
                // and now we are visiting the root, but again by the code logic, it will again to
                // establish the connection to root-left-last to root
                // so we have to check that if the connection is already there or not
                while (null != last.right && last.right != root)
                    last = last.right;
                // setting the link then, we will go to the left, we know that root will be visited at some point
                if (last.right == null) {
                    // this is the first time we are visiting the node
                    last.right = root;
                    root = root.left;
                } else {
                    // this is the second time we are visiting the node
                    // there was already a link,
                    // that means this is the second time we are in the root.
                    // so the left part is traversed completely,
                    // and we will now delete the link and add the root to list
                    last.right = null;
                    // as this is the inorder traversal, we will add the node when we second time visit the node
                    // that means we have visited the entire left subtree
                    list.add(root.data);
                    root = root.right;
                }
            } else {
                // if there is no left subtree, then it will go directly to the right
                // TODO for the last node of left subtree, there was a link attached from the last-node.right=root
                //  this is the time when we will finally visit the root node
                list.add(root.data);
                root = root.right;
            }
        }
        return list;
    }
}
```

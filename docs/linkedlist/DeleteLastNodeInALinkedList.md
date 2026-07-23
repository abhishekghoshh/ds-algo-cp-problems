# DeleteLastNodeInALinkedList

**Topic:** `linkedlist`  

## 🎥 Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/delete-last-node-of-linked-list/)

## 📝 Problem Statement

Check if the linked list is empty or has only one node

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

Check if the linked list is empty or has only one node Create a temporary pointer for traversal Traverse the list until the second-to-last node detach the connection from the second-to-last node to delete the last node Return the updated head of the linked list

```java
    private static void type1() {
        Node node = new Node(2, 5, 8, 7);
        print(node);
        node = deleteTail(node);
        print(node);
    }

    private static Node deleteTail(Node head) {
        // Check if the linked list is empty or has only one node
        if (head == null || head.next == null) return null;
        // Create a temporary pointer for traversal
        Node node = head;
        // Traverse the list until the second-to-last node
        while (node.next.next != null)
            node = node.next;
        // detach the connection from the second-to-last node to delete the last node
        node.next = null;
        // Return the updated head of the linked list
        return head;
    }

}
```

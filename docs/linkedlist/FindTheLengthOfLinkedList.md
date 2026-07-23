# FindTheLengthOfLinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/count-nodes-of-linked-list_5884)

## 🎥 Solution Links

- [📄 takeUforward](https://takeuforward.org/linked-list/find-the-length-of-a-linked-list/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

recursive way

```java
    private static void type2() {
        Node head = new Node(3, 4, 5, 2, 6, 1, 9, -1);
        int count = length(head);
        System.out.println(count);
    }

    private static int length(Node node) {
        if (null == node) return 0;
        return 1 + length(node.next);
    }
```

### Approach 1: 🔨 Brute Force

iterative way

```java
    private static void type1() {
        Node head = new Node(3, 4, 5, 2, 6, 1, 9, -1);

        int count = 0;
        Node node = head;
        while (null != node) {
            count++;
            node = node.next;
        }
        System.out.println(count);
    }


}
```

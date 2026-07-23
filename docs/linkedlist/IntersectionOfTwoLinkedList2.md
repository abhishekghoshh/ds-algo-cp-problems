# IntersectionOfTwoLinkedList2

**Topic:** `linkedlist`  

## 📝 Problem Statement

store it in an array list then traverse it from the back

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

note here two linked lists have the common data not the common pointer

**Time Complexity:** `O((n1+n2)`
**Space Complexity:** `O(1)`

```java
    private static void type3() {
        Node headA = new Node(10, 6, 9, 15, 30);
        Node headB = new Node(10, 15, 30);
        Node point = getIntersectionNode1(headA, headB);
        print(point);
    }

    private static Node getIntersectionNode1(Node headA, Node headB) {
        Node head = null;
        int n1 = count(headA);
        int n2 = count(headB);
        while (n1 > n2) {
            headA = headA.next;
            n1--;
        }
        while (n2 > n1) {
            headB = headB.next;
            n2--;
        }
        while (null != headA && null != headB) {
            if (headA.data == headB.data) {
                if (head == null) head = headA;
            } else {
                head = null;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return head;
    }

    private static int count(Node head) {
        int n = 0;
        while (null != head) {
            head = head.next;
            n++;
        }
        return n;
    }
```

### Approach 2

using recursion first count the nodes then traverse extra nodes for the longer list

```java
    private static void type2() {

    }
```

### Approach 1: 🔨 Brute Force

brute force approach store it in an array list then traverse it from the back

```java
    private static void type1() {

    }
}
```

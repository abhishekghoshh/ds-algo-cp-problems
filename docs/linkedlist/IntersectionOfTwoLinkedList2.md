# IntersectionOfTwoLinkedList2

**Topic:** `linkedlist` | **File:** `com/problems/linkedlist/IntersectionOfTwoLinkedList2.java`

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Note here two linked lists have the common data not the common pointer time complexity O((n1+n2))+O(max((n1+n2))) space complexity O(1)

**Complexity:** Time: o((n1+n2) | Space: o(1)

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

Using recursion first count the nodes then traverse extra nodes for the longer list

```java
private static void type2() {

    }
```

### Approach 1 — Brute Force

Brute force approach store it in an array list then traverse it from the back

```java
private static void type1() {

    }
```

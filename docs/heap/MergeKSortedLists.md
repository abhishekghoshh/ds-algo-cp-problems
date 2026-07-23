# MergeKSortedLists

**Topic:** `heap` | **File:** `com/problems/heap/MergeKSortedLists.java`

**Tags:** Linked list, Heap

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/merge-k-sorted-lists/description/)
- [📄 NeetCode](https://neetcode.io/problems/merge-k-sorted-linked-lists)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/merge-k-sorted-lists_992772)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=l8CuET0jlDU)
- [▶ YouTube](https://www.youtube.com/watch?v=q5a5OiGbT6Q)

## Approaches

This problem has **4** approaches, progressing from brute force to optimal:

### Approach 4 — Optimal

If there is total n lists and k items on each list so time complexity is n*k*log(n) using the merge technique in the merge sort

```java
private static void type4() {
        Node[] lists = {
                new Node(1, 4, 5),
                new Node(1, 3, 4),
                new Node(2, 6),
        };

        Node answer = mergeKLists4(lists);
        print(answer);
    }
    private static Node mergeKLists4(Node[] lists) {
        int n = lists.length;
        if (n == 0) return null;
        return mergeKLists(lists, 0, n - 1);
    }
    private static Node mergeKLists(Node[] lists, int start, int end) {
        // if there is only one element
        if (start == end)
            return lists[start];
        // if there are 2 elements
        if (start + 1 == end)
            return merge(lists[start], lists[end]);
        // else we will divide the list then merge
        int mid = start + (end - start) / 2;
        Node left = mergeKLists(lists, start, mid);
        Node right = mergeKLists(lists, mid + 1, end);
        return merge(left, right);
    }
    private static Node merge(Node l1, Node l2) {
        Node dummyHead = new Node();
        Node prev = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 != null) ? l1 : l2;
        return dummyHead.next;
    }
```

### Approach 3

If there is total n lists and k items on each list so time complexity is n*k*log(n) todo same as type 2 with some little optimizations here we are checking with the next node in the min heap adding till current node has the next nodes lesser than next node in the heap

```java
private static void type3() {
        Node[] lists = {
                new Node(1, 4, 5),
                new Node(1, 3, 4),
                new Node(2, 6),
        };
        Node answer = mergeKLists3(lists);

        print(answer);
    }
    private static Node mergeKLists3(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // we will store all the linked list reference for getting the current lowest value
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        // we will store all the reference of the linked list because the linked list is stored increasingly
        for (Node node : lists) {
            if (null != node)
                minHeap.offer(node);
        }

        Node dummyHead = new Node();
        Node prev = dummyHead;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            // if there is no node in the heap then we will add the current node and break
            if (minHeap.isEmpty()) {
                prev.next = node;
                break;
            }
            Node nextLowest = minHeap.peek();
            while (null != node && node.data <= nextLowest.data) {
                prev.next = node;
                prev = node;
                node = node.next;
            }
            if (null != node) minHeap.offer(node);
        }
        return dummyHead.next;
    }
```

### Approach 2

Optimized approach we will use min heap here

```java
private static void type2() {
        Node[] lists = {
                new Node(1, 4, 5),
                new Node(1, 3, 4),
                new Node(2, 6),
        };
        Node answer = mergeKLists2(lists);
        print(answer);
    }
    private static Node mergeKLists2(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        // we will store all the linked list reference
        // for getting the current lowest value
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // we will store all the reference of the linked list
        // because the linked list is stored increasingly
        for (Node node : lists) {
            if (null != node)
                minHeap.offer(node);
        }

        Node dummyHead = new Node();
        Node prev = dummyHead;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            Node next = node.next;
            prev.next = node;
            prev = node;
            if (null != next) minHeap.offer(next);
        }
        return dummyHead.next;
    }
```

### Approach 1 — Brute Force

Brute force approach add everything to a list, then sort then

```java
private static void type1() {
        Node[] lists = {
                new Node(1, 4, 5),
                new Node(1, 3, 4),
                new Node(2, 6),
        };

        Node answer = mergeKLists1(lists);
        print(answer);
    }
    private static Node mergeKLists1(Node[] lists) {
        List<Node> list = new ArrayList<>();
        for (Node head : lists) {
            while (head != null) {
                list.add(head);
                head = head.next;
            }
        }
        list.sort(Comparator.comparingInt(node -> node.val));
        Node dummyHead = new Node();
        Node prev = dummyHead;
        for (Node node : list) {
            node.next = null;
            prev.next = node;
            prev = node;
        }
        return dummyHead.next;
    }
```

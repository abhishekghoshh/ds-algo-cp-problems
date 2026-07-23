# FindPairsWithGivenSumInSortedDoublyLinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/find-pairs-with-given-sum-in-doubly-linked-list_1164172)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=evxWPp3TI3E)
- [▶ YouTube](https://www.youtube.com/watch?v=YitR4dQsddE)

## 📝 Problem Statement

Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value target.
&nbsp;
Example 1:
Input:  
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach using two pointer approaches finding the tail node now we have head and tail using two pointer approach, we will add the list in a sorted order

```java
    private static void type2() {
        DNode head = new DNode(1, 2, 3, 4, 9);
        int k = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        DNode tail = head;
        // finding the tail node
        while (tail.next != null) tail = tail.next;
        // now we have head and tail
        // using two pointer approach, we will add the list in a sorted order
        while (head != null && tail != null && head.data < tail.data) {
            int sum = head.data + tail.data;
            if (sum == k) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(head.data);
                pair.add(tail.data);
                list.add(pair);
                head = head.next;
                tail = tail.prev;
            } else if (sum < k) head = head.next;
            else tail = tail.prev;
        }
        System.out.println(list);
    }
```

### Approach 1: 🔨 Brute Force

brute force approach adds the datas in a set

```java
    private static void type1() {
        DNode head = new DNode(1, 2, 3, 4, 9);
        int k = 5;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        DNode node = head;
        while (node != null) {
            if (set.contains(k - node.data)) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(k - node.data);
                pair.add(node.data);
                list.add(pair);
            }
            set.add(node.data);
            node = node.next;
        }
        list.sort(Comparator.comparingInt(l -> l.get(0)));
        System.out.println(list);
    }
}
```

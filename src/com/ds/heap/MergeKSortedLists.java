package com.ds.heap;

import com.algo.linkedlist.LinkedList;

import java.util.*;

import static com.util.ArrayUtil.print;

/*
 *
 * problem links :
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * https://www.codingninjas.com/studio/problems/merge-k-sorted-lists_992772
 *
 * Solution link :
 * https://www.youtube.com/watch?v=l8CuET0jlDU
 *
 * */
public class MergeKSortedLists {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // using the merge technique in the merge sort
    private static void type4() {
        LinkedList[] lists = {
                new LinkedList(1, 4, 5),
                new LinkedList(1, 3, 4),
                new LinkedList(2, 6),
        };

        LinkedList answer = mergeKListsHelper(lists, 0, lists.length - 1);
        print(answer);
    }

    private static LinkedList mergeKListsHelper(LinkedList[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start + 1 == end) return merge(lists[start], lists[end]);

        int mid = start + (end - start) / 2;
        LinkedList left = mergeKListsHelper(lists, start, mid);
        LinkedList right = mergeKListsHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    private static LinkedList merge(LinkedList l1, LinkedList l2) {
        LinkedList dummy = new LinkedList(0);
        LinkedList curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }

    // same as type 2 but
    // here I have added some optimizations
    private static void type3() {
        LinkedList[] lists = {
                new LinkedList(1, 4, 5),
                new LinkedList(1, 3, 4),
                new LinkedList(2, 6),
        };
        // we will store all the linked list reference
        // for getting the current lowest value
        PriorityQueue<LinkedList> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(linkedList -> linkedList.val));

        // we will store all the reference of the linked list
        // because the linked list is stored increasingly
        for (LinkedList linkedList : lists) minHeap.offer(linkedList);

        LinkedList prev = minHeap.poll();
        if (prev.next != null) minHeap.offer(prev.next);
        LinkedList answer = prev;

        while (!minHeap.isEmpty()) {
            prev.next = minHeap.poll();
            prev = prev.next;
            // we have made some optimization here
            // we are going to next until it is greater the current top heap element
            if (!minHeap.isEmpty()) {
                LinkedList currentTop = minHeap.peek();
                while (prev.next != null && prev.next.val <= currentTop.val)
                    prev = prev.next;
            } else break;
            if (prev.next != null) minHeap.offer(prev.next);
        }

        print(answer);
    }

    //optimized approach
    // we will use min heap here
    private static void type2() {
        LinkedList[] lists = {
                new LinkedList(1, 4, 5),
                new LinkedList(1, 3, 4),
                new LinkedList(2, 6),
        };
        // we will store all the linked list reference
        // for getting the current lowest value
        PriorityQueue<LinkedList> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(linkedList -> linkedList.val));

        // we will store all the reference of the linked list
        // because the linked list is stored increasingly
        for (LinkedList linkedList : lists) minHeap.offer(linkedList);

        LinkedList prev = minHeap.poll();
        if (prev.next != null) minHeap.offer(prev.next);
        LinkedList answer = prev;

        while (!minHeap.isEmpty()) {
            prev.next = minHeap.poll();
            prev = prev.next;
            if (prev.next != null) minHeap.offer(prev.next);
        }

        print(answer);
    }

    // brute force approach
    private static void type1() {
        LinkedList[] lists = {
                new LinkedList(1, 4, 5),
                new LinkedList(1, 3, 4),
                new LinkedList(2, 6),
        };

        List<Integer> list = new ArrayList<>();
        for (LinkedList arr : lists)
            while (arr != null) {
                list.add(arr.val);
                arr = arr.next;
            }
        Collections.sort(list);
        int size = list.size();
        LinkedList answer = new LinkedList(list.get(0));
        LinkedList prev = answer;
        for (int i = 1; i < size; i++) {
            prev.next = new LinkedList(list.get(i));
            prev = prev.next;
        }
        print(answer);
    }
}

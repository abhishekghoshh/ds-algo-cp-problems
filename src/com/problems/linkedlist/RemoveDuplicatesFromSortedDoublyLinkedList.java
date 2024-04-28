package com.problems.linkedlist;

import com.ds.linkedlist.DNode;

import java.util.TreeSet;

import static com.util.PrintUtl.print;

/*
 * problem links :
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1
 * https://www.codingninjas.com/studio/problems/remove-duplicates-from-a-sorted-doubly-linked-list_2420283
 *
 * Solution link :
 * https://www.youtube.com/watch?v=YJKVTnOJXSY
 * */
public class RemoveDuplicatesFromSortedDoublyLinkedList {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // same as previous slight modification
    // most optimized approach,
    // we will modify the existing pointer
    private static void type4() {
        DNode head = new DNode(1, 2, 2, 2, 3);
        DNode curr = head;
        // if the next pointer is the same as the current pointer, then we will detach the next pointer
        // and attach to the next to next pointer.
        // but we will not move the current pointer,
        // we will only move the current pointer if the next pointer is different
        while (curr != null && curr.next != null) {
            if (curr.data == curr.next.data)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        print(head);
    }

    //  optimized approach
    // we will modify the existing pointer
    private static void type3() {
        DNode head = new DNode(1, 2, 2, 2, 3);
        DNode curr = head;
        while (curr != null && curr.next != null) {
            DNode next = curr.next;
            // we will go to first non-duplicate code
            while (null != next && curr.data == next.data)
                next = next.next;
            curr.next = next;
            curr = next;
        }
        print(head);
    }

    // optimized approach
    // we will do place
    // we will compare with previous if it is not the same then only we will add the link
    private static void type2() {
        DNode head = new DNode(1, 2, 2, 2, 3);
        DNode newHead = new DNode(Integer.MIN_VALUE);
        DNode prev = newHead;
        DNode node = head;
        while (null != node) {
            // if the data is greater than previous, then only we will append the new link
            if (prev.data < node.data) {
                prev.next = node;
                node.prev = prev;
                prev = node;
            }
            node = node.next;
        }
        prev.next = null;
        head = newHead.next;
        print(head);
    }

    // brute force approach
    // Using a tree set to store all the unique element in a sorted manner
    private static void type1() {
        DNode head = new DNode(1, 2, 2, 2, 3);
        TreeSet<Integer> treeSet = new TreeSet<>();
        DNode node = head;
        while (null != node) {
            treeSet.add(node.data);
            node = node.next;
        }
        DNode newHead = new DNode(Integer.MIN_VALUE);
        DNode prev = newHead;
        while (!treeSet.isEmpty()) {
            // poll first will give us the lowest element
            DNode curr = new DNode(treeSet.pollFirst());
            prev.next = curr;
            curr.prev = prev;
            prev = curr;
        }
        head = newHead.next;
        print(head);
    }
}

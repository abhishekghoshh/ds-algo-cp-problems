package com.problems.linkedlist;

import com.ds.linkedlist.Node;

import java.util.ArrayList;
import java.util.List;

import static com.util.PrintUtl.print;

/*
 *
 * problem links :
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * Solution link :
 *
 * */
public class ReverseOfLinkedList2 {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // in place reversal
    private static void type2() {
        Node head = new Node(1, 2, 3, 4, 5);
        int left = 2, right = 4;
        Node ans = reverseBetween(head, left, right);
        print(head);
    }

    public static Node reverseBetween(Node head, int left, int right) {
        if (left == right) return head;
        Node node = new Node();
        node.next = head;
        Node copyHead = node;
        int i = 0;
        Node leftParent = null;
        // we will go to the first node of the [left,right] range
        // also we will track of the leftParent
        while (i < left) {
            i++;
            leftParent = node;
            node = node.next;
        }
        Node next = null, prev = null, leftStart = node;
        // now we will reverse the nodes of this range [left,right] one by one
        while (i <= right && node != null) {
            i++;
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        // now we will set the left-parent.next = right-node to left-start.next = right.next
        leftParent.next = prev;
        leftStart.next = next;
        return copyHead.next;
    }

    // using extra array for reversal
    private static void type1() {
        Node head = new Node(1, 2, 3, 4, 5);
        int left = 2, right = 4;
        print(head);
        List<Integer> list = new ArrayList<>();
        // add a dummy node at the start of the array list as left and right is 1 indexed
        list.add(Integer.MIN_VALUE);
        Node copy = head;
        // adding all the items to the buffer list
        while (copy != null) {
            list.add(copy.data);
            copy = copy.next;
        }
        // reversing the nodes
        while (left < right) {
            int item1 = list.get(left), item2 = list.get(right);
            list.set(right, item1);
            list.set(left, item2);
            left++;
            right--;
        }
        copy = head;
        int i = 1;
        // again copying the values from the buffer list to the actual list
        while (copy != null) {
            copy.data = list.get(i++);
            copy = copy.next;
        }
        print(head);
    }
}

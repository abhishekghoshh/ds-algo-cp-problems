package com.ds.linkedlist;

import com.algo.linkedlist.DNode;
import com.util.ArrayUtil;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/reverse-a-doubly-linked-list_1116098
 *
 * Solution link :
 * https://www.youtube.com/watch?v=u3WUW2qe6ww&list=PLgUwDviBIf0rAuz8tVcM0AymmhTRsfaLU&index=5
 *
 * https://takeuforward.org/data-structure/reverse-a-doubly-linked-list/
 * */
public class ReverseADoublyLinkedList {
    public static void main(String[] args) {
        type1();
    }


    // brute force approach
    private static void type1() {
        DNode head = new DNode(5, 8, 4, 9, 1);
        head = reverse1(head);
        ArrayUtil.print(head);
    }

    private static DNode reverse1(DNode head) {
        // if the head is null, or it is a single pointer,
        // then return the node
        if (head == null || head.next == null) return head;
        int n = 0;
        DNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        // we will store all the nodes in the array
        // then from the array we will try to reverse it
        DNode[] arr = new DNode[n];
        node = head;
        for (int i = 0; i < n && node != null; i++) {
            arr[i] = node;
            node = node.next;
        }
        // now we will change the pointers of the array
        for (int i = n - 1; i >= 0; i--) {
            DNode curr = arr[i];
            DNode next = i >= 1 ? arr[i - 1] : null;
            curr.next = next;
            if (null != next) next.prev = curr;
        }

        return arr[n - 1];
    }
}

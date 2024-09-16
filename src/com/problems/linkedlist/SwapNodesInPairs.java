package com.problems.linkedlist;

import com.ds.linkedlist.Node;
import com.util.PrintUtl;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * problem links :
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 *
 * Solution link :
 *
 * */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // in place reversal
    private static void type2() {
        Node head = new Node(1, 2, 3, 4);
        head = swapPairs2(head);
        PrintUtl.print(head);
    }


    // we will add one extra node at the start
    // we will go two nodes at a time
    public static Node swapPairs2(Node head) {
        if (null == head || head.next == null) return head;
        // this is the dummy node
        Node dummy = new Node();
        Node last = dummy;
        while (head != null && head.next != null) {
            Node next = head.next.next;
            // first node and the second node
            Node node1 = head, node2 = head.next;
            // now we will change the links
            last.next = node2;
            node2.next = node1;
            node1.next = next;
            // we will reassign the nodes
            last = node1;
            head = next;
        }
        // now return without the dummy node
        return dummy.next;
    }

    // using extra array for reversal
    // todo as per the problem said we should not change the nodes just change the links
    // time complexity O(3n)
    // space complexity O(n)
    private static void type1() {
        Node head = new Node(1, 2, 3, 4);
        head = swapPairs1(head);
        PrintUtl.print(head);
    }

    public static Node swapPairs1(Node head) {
        if (null == head || head.next == null) return head;
        List<Node> list = new ArrayList<>();
        Node copy = head;
        // adding the nodes to the list
        while (copy != null) {
            list.add(copy);
            copy = copy.next;
        }
        int n = list.size();
        // we will go to 2 hops everytime
        for (int i = 0; i < n; i += 2) {
            // if the next element is out of range then we will break;
            if (i + 1 > n - 1) break;
            // swapping the nodes
            Node node1 = list.get(i), node2 = list.get(i + 1);
            list.set(i + 1, node1);
            list.set(i, node2);
        }
        // swapping the links
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                list.get(i).next = list.get(i + 1);
            } else {
                list.get(i).next = null;
            }
        }
        return list.get(0);
    }
}

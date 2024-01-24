package com.ds.linkedlist;

import com.algo.linkedlist.Node;

/*
 *
 * problem links :
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
 * https://www.codingninjas.com/studio/problems/delete-middle-node_763267
 *
 * Solution link :
 * https://www.youtube.com/watch?v=ePpV-_pfOeI
 *
 * */
public class DeleteTheMiddleNodeOfLinkedList {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // optimized approach
    private static void type2() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
    }

    // brute force approach
    private static void type1() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
    }
}

package com.ds.linkedlist;

import com.algo.linkedlist.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.util.ArrayUtil.print;

/*
 * problem links :
 * https://leetcode.com/problems/sort-list/description/
 * https://www.codingninjas.com/studio/problems/sort-linked-list_625193
 *
 * Solution link :
 * https://www.youtube.com/watch?v=8ocB7a_c-Cc
 * */
public class SortLinkedList {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // using merge sort
    private static void type3() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
    }

    // optimized approach using insertion sort
    private static void type2() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
    }

    // brute force approach
    private static void type1() {
        Node head = new Node(1, 3, 4, 7, 1, 2, 6);
        Node node = head;
        List<Integer> list = new ArrayList<>();
        while (null != node) {
            list.add(node.data);
            node = node.next;
        }
        node = head;
        Collections.sort(list);
        for (int num : list) {
            node.data = num;
            node = node.next;
        }
        print(head);
    }
}

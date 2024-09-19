package com.problems.linkedlist;

import com.ds.linkedlist.Node;
import com.util.PrintUtl;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 *
 * problem links :
 * https://leetcode.com/problems/reorder-list/description/
 *
 * Solution link :
 *
 *
 * https://takeuforward.org/data-structure/reorder-list/
 * */
public class ReorderList {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        Node head = new Node(1, 2, 3, 4, 5, 6, 7);
        reorderList3(head);
        PrintUtl.print(head);
    }

    public static void reorderList3(Node head) {
        if (null == head.next) return;
        Node fast = head, slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node next = slow.next;
        slow.next = null;
        dfs(next, head);
    }

    private static Node dfs(Node next, Node head) {
        if (null == next) return head;
        Node nextHead = dfs(next.next, head);
        next.next = nextHead.next;
        nextHead.next = next;
        return next.next;
    }

    private static void type2() {
        Node head = new Node(1, 2, 3, 4, 5, 6, 7);
        reorderList2(head);
        PrintUtl.print(head);
    }

    public static void reorderList2(Node head) {
        if (null == head.next) return;
        Node fast = head, slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Node> stack = new Stack<>();
        Node next = slow.next;
        slow.next = null;
        while (next != null) {
            stack.push(next);
            next = next.next;
        }
        Node node = head;
        while (!stack.isEmpty()) {
            next = stack.pop();
            next.next = node.next;
            node.next = next;
            node = next.next;
        }
    }

    // brute force approach
    // store all the nodes in a list then operate from that list
    private static void type1() {
        Node head = new Node(1, 2, 3, 4, 5, 6, 7);
        reorderList1(head);
        PrintUtl.print(head);
    }

    public static void reorderList1(Node head) {
        if (null == head.next) return;
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        int mid = (int) (Math.ceil((double) list.size() / 2) - 1);
        list.get(mid).next = null;
        while (i < j) {
            Node node1 = list.get(i);
            Node node2 = list.get(j);
            node2.next = node1.next;
            node1.next = node2;
            i++;
            j--;
        }

    }

}

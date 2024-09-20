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

    // this is the same approach as previous but here we have used recursion in place of stack
    private static void type3() {
        Node head = new Node(1, 2, 3, 4, 5, 6, 7);
        reorderList3(head);
        PrintUtl.print(head);
    }

    public static void reorderList3(Node head) {
        // if there is only one node then we do not need to check anything
        if (null == head.next) return;
        // we will find the middle node with this approach
        Node fast = head, slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // we will break the list and the middle-node.next to null
        Node next = slow.next;
        slow.next = null;
        // manipulate the pointers as per the question
        dfs(next, head);
    }

    // this recursion call is to mimic the stack behavior
    // we are carrying the head and when the next is null, then only we will return head
    // return value will be the current head
    // next.next = nextHead.next;
    // nextHead.next = next;
    // now next.next will be the new next head which we will return
    // which will be used by the previous recursion call
    private static Node dfs(Node next, Node head) {
        if (null == next) return head;
        Node nextHead = dfs(next.next, head);
        next.next = nextHead.next;
        nextHead.next = next;
        return next.next;
    }

    // this is optimized approach
    // we will use first and slow pointer to find the mid-node
    // once found, then we will store the last half nodes in a stack
    // because we need the nth node at first
    private static void type2() {
        Node head = new Node(1, 2, 3, 4, 5, 6, 7);
        reorderList2(head);
        PrintUtl.print(head);
    }

    public static void reorderList2(Node head) {
        // if there is only one node then we do not need to check anything
        if (null == head.next) return;
        // we will find the middle node with this approach
        Node fast = head, slow = head;
        while (null != fast && null != fast.next) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // we will break the list and the middle-node.next to null
        Node next = slow.next;
        slow.next = null;
        // we will save the last half nodes in stack
        Stack<Node> stack = new Stack<>();
        while (next != null) {
            stack.push(next);
            next = next.next;
        }
        // now we will pop from the stack and manipulate the pointers as per the question
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
    // once the nodes are saved then we will manipulate the nodes by indices
    private static void type1() {
        Node head = new Node(1, 2, 3, 4, 5, 6, 7);
        reorderList1(head);
        PrintUtl.print(head);
    }

    public static void reorderList1(Node head) {
        // if there is only one node then we do not need to check anything
        if (null == head.next) return;
        // we will store the nodes in the array list
        List<Node> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        // once stored we will first break the nodes
        // find we will set the next node of the mid to null
        int i = 0, j = list.size() - 1;
        int mid = (int) (Math.ceil((double) list.size() / 2) - 1);
        list.get(mid).next = null;
        // now we will manipulate the pointers as per the question
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

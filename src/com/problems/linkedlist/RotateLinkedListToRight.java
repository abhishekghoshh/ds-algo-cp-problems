package com.problems.linkedlist;

import com.ds.linkedlist.Node;

import static com.util.PrintUtl.print;

/*
 *
 * problem links :
 * https://leetcode.com/problems/rotate-list/
 * https://www.naukri.com/code360/problems/920454
 *
 * Solution link :
 * https://www.youtube.com/watch?v=uT7YI7XbTY8
 * https://www.youtube.com/watch?v=9VPm6nEbVPA&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=40
 *
 * https://takeuforward.org/data-structure/rotate-a-linked-list/
 * */
public class RotateLinkedListToRight {

    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    private static void type3() {
        Node head = new Node(1, 2, 3, 4, 5);
        int k = 2;
        print(head);
        head = rotateRight3(head, k);
        print(head);
    }

    // slightly better than previous
    // as here we are counting the nodes and going to the last node
    // at the same time
    public static Node rotateRight3(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int n = 1;
        Node last = head;
        while (null != last.next) {
            n++;
            last = last.next;
        }
        if (k % n == 0) return head;
        k = k % n;
        k = n - k;
        Node node = head;
        Node prev = null, newHead;
        while (k != 0) {
            prev = node;
            node = node.next;
            k--;
        }
        newHead = node;
        last.next = head;
        prev.next = null;
        return newHead;
    }

    // TODO best approach
    // discuss it in the interview
    // optimized approach
    // time complexity O(n)
    // space complexity O(1)
    // if the series is  1 2 3 4 5 and k = 2
    // then after two rotation it will become  4 5 1 2 3
    // see our our work is just cut the last k pointers
    // and add it to head
    // so from the start we will go n-k nodes
    // which is same as k nodes from the end
    private static void type2() {
        Node head = new Node(1, 2, 3, 4, 5);
        int k = 2;
        print(head);
        head = rotateRight2(head, k);
        print(head);
    }

    // for example 1,2,3,4,5 will be 4,5,1,2,3 after 2 rotation
    // if list is null, or it has only one element or k ==0 then we will just return
    // as we don't have to do anything
    // our job is to attach 5 to 1 then detach 3.next from 4 to null
    // then assign 4 to head
    // so our list will become like 1,2,3,4,5->>1
    // then it will become 1,2,3->>null 4,5->>1 and 4 is head now
    // our list will become 4,5,1,2,3
    // so first we will go to last pointer and along with it, we will count length
    // then we will attach last.next = head
    // now our list become cycle
    // we are at 5 and k=2, so we need to travel n-k distance
    // after traveling we will reach node 3
    // now we will assign head to 3.next which is 4
    // also breaks 3's next pointer
    public static Node rotateRight2(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int n = 0;
        Node node = head;
        while (null != node) {
            n++;
            node = node.next;
        }
        if (k % n == 0) return head;
        k = k % n;
        k = n - k;
        node = head;
        Node prev = null, newHead;
        while (k != 0) {
            prev = node;
            node = node.next;
            k--;
        }
        newHead = node;
        while (null != node.next) node = node.next;
        node.next = head;
        prev.next = null;
        return newHead;
    }

    // brute force approach
    // time complexity O(k)
    // store it in the array
    // then rotate the array
    private static void type1() {

    }

    public static Node rotateRight1(Node head, int k) {

        return head;
    }
}

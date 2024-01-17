package com.algo.linkedlist;

public class LinkedList {
    public int val;
    public LinkedList next = null;


    LinkedList(int val) {
        this.val = val;
    }


    public LinkedList(int val, int... others) {
        LinkedList node = this;
        this.val = val;
        for (int data : others) {
            LinkedList newNode = new LinkedList(data);
            node.next = newNode;
            node = newNode;
        }
    }
}

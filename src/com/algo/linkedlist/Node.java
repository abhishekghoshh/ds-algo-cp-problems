package com.algo.linkedlist;

public class Node {
    public int data;
    public Node next = null;


    public Node() {
        this.data = 0;
        this.next = null;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }


    public Node(int val, int... others) {
        Node node = this;
        this.data = val;
        for (int data : others) {
            Node newNode = new Node(data);
            node.next = newNode;
            node = newNode;
        }
    }

    public Node next(Node node) {
        this.next = node;
        return this;
    }
}

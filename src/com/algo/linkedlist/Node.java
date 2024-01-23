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

    public Node last(Node node) {
        Node current = this;
        while (current.next != null) current = current.next;
        current.next = node;
        return this;
    }

    public static Node attach(Node node, Node... nodes) {
        Node head = node;
        Node last = node;
        while (last.next != null) last = last.next;
        for (Node start : nodes) {
            last.next = start;
            while (last.next != null) last = last.next;
        }
        return head;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

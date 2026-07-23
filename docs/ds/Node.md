# ListNode & DNode

## ListNode (`com/ds/linkedlist/Node.java`)

Multi-purpose linked list node with additional pointers for advanced problems.

```java
package com.ds.linkedlist;

public class Node {
    public int data;        // value (also accessible as val)
    public int val;
    public Node next;       // standard next pointer
    public Node bottom;     // for flattening multi-level lists
    public Node random;     // for deep copy with random pointers

    public Node() { this.val = this.data = 0; }
    public Node(int data) { this.val = this.data = data; }
    public Node(int data, Node next) { this.val = this.data = data; this.next = next; }

    // Chain constructor: Node(1, 2, 3, 4) → 1→2→3→4
    public Node(int val, int... others) {
        Node node = this;
        this.val = this.data = val;
        for (int data : others) {
            Node newNode = new Node(data);
            node.next = newNode;
            node = newNode;
        }
    }

    // Fluent API
    public Node next(Node node) { this.next = node; return this; }
    public Node chain(Node node) { /* appends to end */ return node; }
    public Node last(Node node) { /* appends and returns this */ return this; }
    public Node bottom(int... datas) { /* creates bottom chain */ return this; }
    public static Node attach(Node node, Node... nodes) { /* concatenates lists */ }
}
```

## DNode (`com/ds/linkedlist/DNode.java`)

Doubly linked list node with chain constructor.

```java
package com.ds.linkedlist;

public class DNode {
    public int data;
    public DNode next;
    public DNode prev;

    public DNode() {}
    public DNode(int data) { this.data = data; }
    public DNode(int data, DNode next) { this.data = data; this.next = next; this.prev = next; }

    // Chain constructor: DNode(1, 2, 3) → 1↔2↔3
    public DNode(int data, int... others) {
        DNode prev = this;
        this.data = data;
        for (int num : others) {
            DNode current = new DNode(num);
            current.prev = prev;
            prev.next = current;
            prev = current;
        }
    }

    public DNode next(DNode node) { this.next = node; node.prev = this; return this; }
}
```

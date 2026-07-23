# AddOneToNumberRepresentedByLinkedList

**Topic:** `linkedlist`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/add-one-to-a-number-represented-as-linked-list_920557)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=aXQWhbvT3w0)

## 📝 Problem Statement

store it in the stack then pop

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

using recursion, we will go till the last non-null node then we will add 1 to that node carry is 1 means we have to add a node at the start which will be the new node we will assume that +1 is carry 1 it will simplify some logic. we will return 1 if the node is null we don't need to store the carry because it can either be 0 or 1 it is not 0 means it is 1 it means it is 1

```java
    private static void type3() {
        Node head = new Node(1, 5, 3);
        print(head);
        int carry = add(head);
        // carry is 1 means we have to add a node at the start
        // which will be the new node
        if (carry == 1) {
            Node node = new Node(1);
            node.next = head;
            head = node;
        }
        print(head);
    }

    // we will assume that +1 is carry 1
    // it will simplify some logic.
    private static int add(Node head) {
        // we will return 1 if the node is null
        if (head == null) return 1;
        // we don't need to store the carry
        // because it can either be 0 or 1
        // it is not 0 means it is 1
        if (add(head.next) == 0) return 0;
        // it means it is 1
        int data = head.data + 1;
        head.data = data % 10;
        return (data / 10);
    }
```

### Approach 2

iterative approach store it in the stack then pop same as previous just some early optimization if in some point the carry is 0 then the carry will never be 1 we can just break the loop from that point

```java
    private static void type2() {
        Node head = new Node(1, 5, 3);
        print(head);
        Node node = head;
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int carry = 1;
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.data += carry;
            carry = node.data / 10;
            node.data = node.data % 10;
            // early optimization
            if (carry == 0) break;
        }
        if (carry == 1) {
            node = new Node(1);
            node.next = head;
            head = node;
        }
        print(head);
    }
```

### Approach 1: 🔨 Brute Force

iterative approach store it in the stack then pop

```java
    private static void type1() {
        Node head = new Node(1, 5, 3);
        print(head);
        Node node = head;
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        int carry = 1;
        while (!stack.isEmpty()) {
            node = stack.pop();
            node.data += carry;
            carry = node.data / 10;
            node.data = node.data % 10;
        }
        if (carry == 1) {
            node = new Node(1);
            node.next = head;
            head = node;
        }
        print(head);
    }
}
```

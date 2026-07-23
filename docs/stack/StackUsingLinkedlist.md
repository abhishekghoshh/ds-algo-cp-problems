# StackUsingLinkedlist

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/implement-stack-with-linked-list_1279905)

## 🎥 Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/implement-stack-using-linked-list/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
    private static void type2() {

    }

    static class Stack {
        private Node top;
        private int size = 0;

        Stack() {
            top = new Node();
        }

        int getSize() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }

        void push(int data) {
            size++;
            Node node = new Node(data);
            node.next = top;
            top = node;
        }

        void pop() {
            if (size == 0) return;
            size--;
            top = top.next;
        }

        int getTop() {
            if (size == 0) return -1;
            return top.data;
        }
    }

    static class Node {
        int data;
        Node next;

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
```

### Approach 1: 🔨 Brute Force

```java
    private static void type1() {
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        printException(() -> stack.push(4));
        System.out.println(stack.peek() + " " + stack.pop());
        System.out.println(stack.peek() + " " + stack.pop());
        System.out.println(stack.peek() + " " + stack.pop());
        System.out.println(stack.peek() + " " + stack.pop());
        printException(() -> System.out.println(stack.peek()));
        printException(() -> System.out.println(stack.pop()));
    }

    public static class StackUsingLinkedList<T> {
        private Node<T> top;
        private int size = 0;

        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
                this.next = null;
            }
        }

        StackUsingLinkedList() {
            top = new Node<>(null);
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

        public void push(T item) {
            size++;
            Node<T> node = new Node<>(item);
            node.next = top;
            top = node;
        }

        public T pop() {
            if (size == 0) {
                throw new UnsupportedOperationException("No element present for popping");
            }
            size--;
            Node<T> node = top;
            top = top.next;
            return node.data;
        }

        public T peek() {
            if (size == 0) {
                throw new UnsupportedOperationException("No element present for peeking");
            }
            return top.data;
        }
    }
}
```

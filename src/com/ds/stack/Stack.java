package com.ds.stack;

public interface Stack<T> {
    // return the number of elements in the stack
    public int size();

    // return if the stack is empty
    public boolean isEmpty();

    // push the element on the stack
    public void push(T elem);

    // pop the element off the stack
    public T pop();

    public T peek();


    public static void main(String[] args) {

        Stack<Integer> s = new ArrayStack<>(5);

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s.pop()); // 5
        System.out.println(s.pop()); // 4
        System.out.println(s.pop()); // 3

        s.push(3);
        s.push(4);
        s.push(5);

        while (!s.isEmpty()) System.out.println(s.pop());

        benchMarkTest();
    }

    // BenchMark IntStack vs ArrayDeque.
    private static void benchMarkTest() {

        int n = 10000000;
        Stack<Integer> intStack = new ArrayStack<>(n);

        // IntStack times at around 0.0324 seconds
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) intStack.push(i);
        for (int i = 0; i < n; i++) intStack.pop();
        long end = System.nanoTime();
        System.out.println("IntStack Time: " + (end - start) / 1e9);

        // ArrayDeque times at around 1.438 seconds
        //    java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>();
        //    java.util.Stack<Integer> arrayDeque = new java.util.Stack<>();
        java.util.ArrayDeque<Integer> arrayDeque = new java.util.ArrayDeque<>(n); // strangely the
        // ArrayQueue is slower when you give it an initial capacity.
        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayDeque.push(i);
        for (int i = 0; i < n; i++) arrayDeque.pop();
        end = System.nanoTime();
        System.out.println("ArrayDeque Time: " + (end - start) / 1e9);

        Stack<Integer> listStack = new LinkedListStack<>();

        start = System.nanoTime();
        for (int i = 0; i < n; i++) listStack.push(i);
        for (int i = 0; i < n; i++) listStack.pop();
        end = System.nanoTime();
        System.out.println("ListStack Time: " + (end - start) / 1e9);

        Stack<Integer> arrayStack = new ArrayStack<>();

        start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayStack.push(i);
        for (int i = 0; i < n; i++) arrayStack.pop();
        end = System.nanoTime();
        System.out.println("ArrayStack Time: " + (end - start) / 1e9);
    }
}
package com.ds.stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private int size;
    private int capacity;
    private Object[] data;
    private static final int DEF_CAP = 1 << 3;

    public ArrayStack() {
        this(DEF_CAP);
    }

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T elem) {
        if (size == capacity) increaseCapacity();
        data[size++] = elem;
    }

    // Increase the capacity to store more elements.
    private void increaseCapacity() {
        capacity *= 2;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new IllegalArgumentException();
        T elem = (T) data[--size];
        data[size] = null;
        return elem;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new IllegalArgumentException();
        return (T) data[size - 1];
    }
}
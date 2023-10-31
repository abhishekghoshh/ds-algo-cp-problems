package com.implementations.heap;

import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxsize;

    public MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        heap = new int[this.maxsize];
    }

    public MaxHeap(int[] array) {
        this.maxsize = array.length;
        this.size = array.length;
        this.heap = Arrays.copyOf(array, size);
        for (int i = this.maxsize / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos) + 1;
    }

    private int rightChild(int pos) {
        return (2 * pos) + 2;
    }

    private boolean isLeaf(int pos) {
        if (pos > (size / 2) - 1 && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private void maxHeapify(int pos) {
        if (isLeaf(pos)) {
            return;
        }
        int highest = pos;
        if (leftChild(pos) < size && heap[pos] < heap[leftChild(pos)]) {
            highest = leftChild(pos);
        }
        if (leftChild(pos) < size && heap[pos] < heap[rightChild(pos)]) {
            highest = rightChild(pos);
        }
        if (highest != pos) {
            swap(pos, highest);
            maxHeapify(highest);
        }
    }

    public void insert(int element) {
        heap[size] = element;

        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int extractMax() {
        int popped = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return popped;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() != 0;
    }

    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print("Parent LinkedListNode : " + heap[i]);
            if (leftChild(i) < size) {
                System.out.print(" Left Child : " + heap[leftChild(i)]);
            }
            if (rightChild(i) < size) {
                System.out.print(" Right Child : " + heap[rightChild(i)]);
            }
            System.out.println(); // for new line
        }
    }
}

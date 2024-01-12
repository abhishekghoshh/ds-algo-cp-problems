package com.ds.queue;

import com.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * Problem link :
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * https://www.codingninjas.com/studio/problems/sliding-maximum-_701652
 *
 * Solution link :
 * https://www.youtube.com/watch?v=CZQGRp93K4k
 *
 * https://takeuforward.org/data-structure/sliding-window-maximum/
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
        type5();
        type6();
    }

    // TODO check this later
    private static void type6() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int n = nums.length;
        int[] res = new int[n + 1 - k];

        int maxId = 0;
        int max = Integer.MIN_VALUE;

        for (int x = 0; x < k; x++) {
            if (nums[x] >= max) {
                max = nums[x];
                maxId = x;
            }
        }
        res[0] = max;
        for (int i = 1, end; i < res.length; i++) {
            end = i + k - 1;
            if (i <= maxId) {
                if (max <= nums[end]) {
                    max = nums[end];
                    maxId = end;
                }
            } else {
                if (nums[end] >= max - 1) {
                    max = nums[end];
                    maxId = end;
                } else if (nums[i] >= max - 1) {
                    max = nums[i];
                    maxId = i;
                } else {
                    max = Integer.MIN_VALUE;
                    for (int x = i; x < end + 1; x++) {
                        if (nums[x] >= max) {
                            max = nums[x];
                            maxId = x;
                        }
                    }
                }
            }
            res[i] = max;
        }
        ArrayUtil.print(res);
    }

    // TODO check this later
    private static void type5() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int n = nums.length;
        int k1 = k - 1;

        int size = 2;
        while (size < k + 1) size <<= 1;
        int mask = size - 1;

        int[] deque = new int[size];
        int head = 0, tail = 0;

        int[] res = new int[n - k1];
        for (int i = 0; i < n; i++) {
            while (head != tail && nums[deque[head]] <= nums[i])
                head = head + 1 & mask;

            deque[head = head - 1 & mask] = i;

            if (deque[tail - 1 & mask] == i - k)
                tail = tail - 1 & mask;

            if (i >= k1)
                res[i - k1] = nums[deque[tail - 1 & mask]];
        }
        ArrayUtil.print(res);
    }

    // TODO check this later
    private static void type4() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        final int length = nums.length, k1 = k - 1;
        final IntDeque deque = new IntDeque(k + 1);
        final int[] res = new int[length - k1];
        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i])
                deque.removeLast();
            deque.addLast(i);
            if (deque.getFirst() == i - k)
                deque.removeFirst();
            if (i >= k1) res[i - k1] = nums[deque.getFirst()];
        }
        ArrayUtil.print(res);
    }

    private static final class IntDeque {
        private final int[] elements;
        private final int mask;
        private int head = 0, tail = 0;

        public IntDeque(int capacity) {
            final int mask = calcMask(capacity);
            this.mask = mask;
            this.elements = new int[mask + 1];
        }

        private int calcMask(final int n) {
            int size = 2;
            while (size < n) size <<= 1;
            return size - 1;
        }

        // not tested
        public void addFirst(int value) {
            head = head + mask & mask;
            elements[head] = value;
        }

        public void addLast(int value) {
            elements[tail] = value;
            tail = tail + 1 & mask;
        }

        public int removeFirst() {
            int value = elements[head];
            head = head + 1 & mask;
            return value;
        }

        public int removeLast() {
            tail = tail + mask & mask;
            return elements[tail];
        }

        public int getFirst() {
            return elements[head];
        }

        public int getLast() {
            return elements[tail + mask & mask];
        }

        public boolean isEmpty() {
            return head == tail;
        }
    }

    // TODO check this later
    private static void type3() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        // window size is k
        MonotonicQueue queue = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // add all the nums to the queue
                queue.push(nums[i]); // 0 , 1
            } else {
                queue.push(nums[i]);
                res[i - k + 1] = queue.max();
                queue.pop(nums[i - k + 1]);
            }
        }
        ArrayUtil.print(res);
    }

    static class MonotonicQueue {
        LinkedList<Integer> list = new LinkedList<>();

        public void push(int n) {
            // Maintain a decreasing monotonic queue doubly linked list
            while (!list.isEmpty() && list.getLast() < n) list.pollLast();
            list.addLast(n);
        }

        public int max() {
            return list.getFirst();
        }

        public void pop(int n) {
            // why do we need this if the statement is sometimes, n already removed
            if (n == list.getFirst()) list.pollFirst();
        }
    }

    // TODO see this later
    // Using queue
    // optimized approach
    private static void type2() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int r = 0;
        // store index
        // we will store the queue in a decreasing fashion,
        // so the peekLast/or of the queue is always highest
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // remove numbers out of range k
            if (!deque.isEmpty() && deque.peek() == i - k)
                deque.poll();
            // remove smaller numbers in k range as they are useless
            // because if the current number is greater
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.addLast(i);
            //check if the window is even valid (i-k>=0)
            if (i >= k - 1 && !deque.isEmpty()) res[r++] = nums[deque.peek()];
        }
        ArrayUtil.print(res);
    }

    // brute force approach
    private static void type1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int n = nums.length;
        int r = n - k + 1;
        int[] res = new int[r];
        int max;
        for (int i = 0; i < r; i++) {
            max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++)
                max = Math.max(max, nums[i + j]);
            res[i] = max;
        }
        ArrayUtil.print(res);
    }
}

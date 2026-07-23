# SlidingWindowMaximum

**Topic:** `queue`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/sliding-window-maximum/description/)
- [📄 NeetCode](https://neetcode.io/problems/sliding-window-maximum)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/sliding-maximum-_701652)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=CZQGRp93K4k)
- [▶ YouTube](https://www.youtube.com/watch?v=DfljaUwZsOk)
- [📄 takeUforward](https://takeuforward.org/data-structure/sliding-window-maximum/)

## 📝 Problem Statement

Maximum in every sliding window of size K using deque.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

create a personal queue with array we will store the queue in a decreasing fashion, so the peekLast/or of the queue is always highest remove numbers out of range k if there is any element which is greater than the last added then we will remove the last added check if the window is even valid (i-k>=0)

```java
    private static void type3() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow3(nums, k);
        PrintUtl.print(res);

    }

    private static int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // we will store the queue in a decreasing fashion, so the peekLast/or of the queue is always highest
        DQ deque = new DQ(n);
        for (int r = 0, i = 0; i < n; i++) {
            // remove numbers out of range k
            if (!deque.isEmpty() && deque.peek() == (i - k))
                deque.poll();
            // if there is any element which is greater than the last added then we will remove the last added
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.add(i); // adding the current element
            // check if the window is even valid (i-k>=0)
            if (i >= k - 1 && !deque.isEmpty()) {
                res[r++] = nums[deque.peek()];
            }
        }
        return res;
    }

    static class DQ {
        int n;
        int[] queue;
        int last, first;

        DQ(int n) {
            this.n = n;
            this.queue = new int[n];
            last = first = -1;
        }

        public boolean isEmpty() {
            return first == -1;
        }

        public int peek() {
            return queue[first];
        }

        public void poll() {
            if (first == last) {
                first = last = -1;
            } else {
                first++;
            }
        }

        public void pollLast() {
            if (first == last) {
                first = last = -1;
            } else {
                last--;
            }
        }

        public int peekLast() {
            return queue[last];
        }

        public void add(int i) {
            if (last == -1) {
                first = 0;
            }
            queue[++last] = i;
        }
    }
```

### Approach 2

optimized approach using the deque the main problem in the sliding window is once the maximum element is outside of the window then we need to find the new maximum by iterating the window again one solution is to store elements in decreasing fashion so once the element is gone we will find next max again in O(1) by queue.peek() but if there is any element which is greater than the last added then we will remove the last added we will do this till the last num is not greater than the current then ultimately the queue will be again decreasing we will store the queue in a decreasing fashion, so the peekLast/or of the queue is always highest remove numbers out of range k if there is any element which is greater than the last added then we will remove the last added check if the window is even valid (i-k>=0)

```java
    private static void type2() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow2(nums, k);
        PrintUtl.print(res);
    }

    private static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        // we will store the queue in a decreasing fashion, so the peekLast/or of the queue is always highest
        Deque<Integer> deque = new ArrayDeque<>();
        for (int r = 0, i = 0; i < n; i++) {
            // remove numbers out of range k
            if (!deque.isEmpty() && deque.peek() == (i - k))
                deque.poll();
            // if there is any element which is greater than the last added then we will remove the last added
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.addLast(i); // adding the current element
            // check if the window is even valid (i-k>=0)
            if (i >= k - 1 && !deque.isEmpty()) {
                res[r++] = nums[deque.peek()];
            }
        }
        return res;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow1(nums, k);
        PrintUtl.print(res);
    }

    private static int[] maxSlidingWindow1(int[] nums, int k) {
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
        return res;
    }
}
```

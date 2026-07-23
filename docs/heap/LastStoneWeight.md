# LastStoneWeight

**Topic:** `heap`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/last-stone-weight/description/)
- [📄 NeetCode](https://neetcode.io/problems/last-stone-weight)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=B-QCq79-Vfw)

## 📝 Problem Statement

Smash the two heaviest stones repeatedly. Return the weight of the last stone.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach using heap

```java
    private static void type2() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int ans = lastStoneWeight2(stones);
        System.out.println(ans);
    }

    public static int lastStoneWeight2(int[] stones) {
        int n = stones.length;
        if (n == 1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((s1, s2) -> Integer.compare(s2, s1));
        for (int s : stones) maxHeap.offer(s);
        while (maxHeap.size() > 1) {
            int s1 = maxHeap.poll();
            int s2 = maxHeap.poll();
            if (s1 != s2) {
                maxHeap.offer(Math.abs(s1 - s2));
            }
        }
        return !maxHeap.isEmpty() ? maxHeap.peek() : 0;
    }
```

### Approach 1: 🔨 Brute Force

using brute force approach

```java
    private static void type1() {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int ans = lastStoneWeight1(stones);
        System.out.println(ans);
    }

    public static int lastStoneWeight1(int[] stones) {
        int n = stones.length;
        while (n > 1) {
            Arrays.sort(stones);
            stones[n - 2] = stones[n - 1] - stones[n - 2];
            n--;
        }
        return stones[0];
    }
}
```

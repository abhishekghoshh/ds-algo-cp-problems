# InsertInterval

**Topic:** `greedy`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/insert-interval/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/-insert-interval_285893)

## 🎥 Solution Links

- [📄 takeUforward](https://takeuforward.org/data-structure/insert-new-interval/)

## 📝 Problem Statement

Insert and merge a new interval into a sorted interval list.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

using a linked list first we go till the interval which will be merged with the newInterval we can perform this using the binary search as well as the intervals are in sorted order we will merge the interval with the newInterval till there is a discrete interval we will add the interval if there is any remaining

```java
    private static void type1() {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        int n = intervals.length;
        int[] interval;
        List<int[]> list = new ArrayList<>();
        int i = 0;
        // first we go till the interval which will be merged with the newInterval
        // we can perform this using the binary search as well
        // as the intervals are in sorted order
        while (i < n && intervals[i][1] < newInterval[0])
            list.add(intervals[i++]);
        // we will merge the interval with the newInterval till there is a discrete interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            interval = intervals[i++];
            newInterval[0] = Math.min(interval[0], newInterval[0]);
            newInterval[1] = Math.max(interval[1], newInterval[1]);
        }
        list.add(newInterval);
        // we will add the interval if there is any remaining
        while (i < n) list.add(intervals[i++]);
        int n1 = list.size();
        int[][] mergedList = new int[n1][];
        for (i = 0; i < n1; i++) mergedList[i] = list.get(i);
        PrintUtl.print2D(mergedList);
    }
}
```

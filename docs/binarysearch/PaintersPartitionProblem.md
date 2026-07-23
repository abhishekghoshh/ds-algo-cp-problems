# PaintersPartitionProblem

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/painter-s-partition-problem_1089557)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=thUd_WJn6wk)
- [📄 takeUforward](https://takeuforward.org/arrays/painters-partition-problem/)

## 📝 Problem Statement

Partition boards among painters to minimize the maximum time.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

binary search on method approach

```java
    private static void type2() {
        List<Integer> arr = List.of(2, 1, 5, 6, 2, 3);
        int k = 2;
        int max = 0, sum = 0;
        for (int num : arr) {
            if (num > max) max = num;
            sum += num;
        }
        int low = max, high = sum, answer = -1, mid, count;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            count = countForMid(arr, mid, k);
            if (count <= k) {
                answer = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        System.out.println(answer);
    }

    private static int countForMid(List<Integer> nums, int mid, int k) {
        int count = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                count++;
                sum = num;
            }
        }
        return count;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```

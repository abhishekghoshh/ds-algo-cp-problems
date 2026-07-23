# NumberOfGreaterElementsToTheRight

**Topic:** `stack` | **File:** `com/problems/stack/NumberOfGreaterElementsToTheRight.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/count-of-greater-elements-to-the-right_8365436)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Complete this problem

```java
private static void type2() {
        int[] nums = {5, 2, 10, 4};
        int[] query = {0, 1};
        int n = nums.length;
        int q = query.length;
        int[] ngeCount = new int[n];
        int[] answer = new int[q];
        Stack<Integer> stack = new Stack<>();
        print(answer);
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        int[] nums = {5, 2, 10, 4};
        int[] query = {0, 1};
        int n = nums.length;
        int q = query.length;
        int[] answer = new int[q];
        int qe;
        for (int x = 0; x < q; x++) {
            qe = query[x];
            for (int i = qe + 1; i < n; i++)
                if (nums[qe] < nums[i])
                    answer[x]++;
        }
        PrintUtl.print(answer);
    }
```

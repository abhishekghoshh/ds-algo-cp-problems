# AssignElementsToGroupsWithConstraints

**Topic:** `prime` | **File:** `com/problems/prime/AssignElementsToGroupsWithConstraints.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/assign-elements-to-groups-with-constraints/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Complete it later create a sieve first check the hint of the problem

```java
private static void type2() {
        int[] groups = {8, 4, 3, 2, 4};
        int[] elements = {4, 2};
        int[] ans = assignElements2(groups, elements);
        PrintUtl.print(ans);
    }
    private static int[] assignElements2(int[] groups, int[] elements) {
        int n = groups.length;
        int[] ans = new int[n];
        return ans;
    }
```

### Approach 1 — Brute Force

Using brute force approach creates a map of elements now for iterate over the group elements and find the divisors and check if the divisor is present or not in the element map and check their indices

```java
private static void type1() {
        int[] groups = {8, 4, 3, 2, 4};
        int[] elements = {4, 2};
        int[] ans = assignElements1(groups, elements);
        PrintUtl.print(ans);
    }
    public static int[] assignElements1(int[] groups, int[] elements) {
        int n = groups.length;
        int[] ans = new int[n];
        // creating a map
        int max = 0;
        for (int num : elements) {
            if (num > max) max = num;
        }
        int[] map = new int[max + 1];
        Arrays.fill(map, -1);
        int n1 = elements.length;
        for (int i = 0; i < n1; i++) {
            int num = elements[i];
            if (map[num] == -1) map[num] = i;
        }
        // now iterate over the groups and find the divisors
        for (int i = 0; i < n; i++) {
            int num = groups[i];
            ans[i] = n1 + 1;
            for (int div = 1; div <= max && (div * div) <= num; div++) {
                // if the number is not divisible by the divisor, then skip
                if (num % div != 0) continue;
                if (map[div] != -1 && ans[i] > map[div]) {
                    ans[i] = map[div];
                }
                int otherDiv = num / div;
                if (otherDiv > max) continue;
                if (map[otherDiv] != -1 && ans[i] > map[otherDiv]) {
                    ans[i] = map[otherDiv];
                }
            }
            if (ans[i] == (n1 + 1)) ans[i] = -1;
        }
        return ans;
    }
```

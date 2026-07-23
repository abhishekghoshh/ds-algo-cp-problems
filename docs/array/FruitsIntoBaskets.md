# FruitsIntoBaskets

**Topic:** `array` | **File:** `com/problems/array/FruitsIntoBaskets.java`

## Problem Statement

these 2 problems are similar just the constraints are different <p> 1 <= n <= 100 <br> 1 <= fruits[i], baskets[i] <= 1000 <p> 1 <= n <= 105 <br> 1 <= fruits[i], baskets[i] <= 109

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/fruits-into-baskets-ii/description/)
- [📄 LeetCode](https://leetcode.com/problems/fruits-into-baskets-iii/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Check it later

```java
private static void type2() {
    }
```

### Approach 1 — Brute Force

When the input is small, then we can apply brute force directly

```java
private static void type1() {
        int[] fruits = {4, 2, 5};
        int[] baskets = {3, 5, 4};
        int ans = numOfUnplacedFruits1(fruits, baskets);
        System.out.println(ans);
    }
    public static int numOfUnplacedFruits1(int[] fruits, int[] baskets) {
        int count = 0;
        int n1 = fruits.length, n2 = baskets.length;
        for (int f : fruits) {
            int pos = -1;
            for (int j = 0; j < n2; j++) {
                if (f <= baskets[j]) {
                    baskets[j] = 0;
                    pos = j;
                    break;
                }
            }
            if (pos == -1) count++;
        }

        return count;
    }
```

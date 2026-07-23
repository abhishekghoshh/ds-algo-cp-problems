# RecursionTheory

**Topic:** `recursion` | **File:** `com/problems/recursion/RecursionTheory.java`

## Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/sum-of-first-n-terms5843/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=yVdKa8dnKiE)
- [▶ YouTube](https://www.youtube.com/watch?v=69ZCDFy-OUo)
- [📄 takeUforward](https://takeuforward.org/recursion/introduction-to-recursion-understand-recursion-by-printing-something-n-times/)
- [📄 takeUforward](https://takeuforward.org/data-structure/sum-of-first-n-natural-numbers/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Sum of first n terms

```java
private static void type2() {
        long n = 7;
        long ans = sumOfSeries(n);
        System.out.println(ans);
    }
```

### Approach 1 — Brute Force

Print 1 To N Without Loop

```java
private static void type1() {
        int N = 10;
        printNos(1, N);
        System.out.println();
    }
    public static void printNos(int i, int N) {
        if (i == N + 1) return;
        System.out.print(i + " ");
        printNos(i + 1, N);
    }
```

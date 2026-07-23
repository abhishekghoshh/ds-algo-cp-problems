# RecursionTheory

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops-1587115620/1)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/sum-of-first-n-terms5843/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=yVdKa8dnKiE)
- [▶ YouTube](https://www.youtube.com/watch?v=69ZCDFy-OUo)
- [📄 takeUforward](https://takeuforward.org/recursion/introduction-to-recursion-understand-recursion-by-printing-something-n-times/)
- [📄 takeUforward](https://takeuforward.org/data-structure/sum-of-first-n-natural-numbers/)

## 📝 Problem Statement

Theory and fundamentals of recursion.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

Sum of first n terms

```java
    private static void type2() {
        long n = 7;
        long ans = sumOfSeries(n);
        System.out.println(ans);
    }

    static long sumOfSeries(long n) {
        if (n == 0) return 0;
        return (n * n * n) + sumOfSeries(n - 1);
    }

}
```

### Approach 1: 🔨 Brute Force

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

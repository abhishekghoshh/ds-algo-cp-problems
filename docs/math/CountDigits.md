# CountDigits

**Topic:** `math`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/count-digits5716/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=1xNbjMdbjug)
- [📄 takeUforward](https://takeuforward.org/data-structure/count-digits-in-a-number/)

## 📝 Problem Statement

Given a positive integer n, count the number of digits in n that divide n evenly (i.e., without leaving a remainder). Return the total number of such digits.

A digit d of n divides n evenly if the remainder when n is divided by d is 0 (n % d == 0).D

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
    private static void type1() {
        int n = 2446;
        int ans = evenlyDivides(n);
        System.out.println(ans);
    }

    static int evenlyDivides(int N) {
        // code here
        int i = 0;
        int num = N;
        while (N > 0) {
            int digit = N % 10;
            N = N / 10;
            if (digit != 0 && num % digit == 0) i++;
        }
        return i;
    }
}
```

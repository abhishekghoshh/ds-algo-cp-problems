# NDigitNumbersWithDigitsInIncreasingOrder

**Topic:** `recursion` | **File:** `com/problems/recursion/NDigitNumbersWithDigitsInIncreasingOrder.java`

## Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=xlKrk3ZO3iM&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=11)
- [▶ YouTube](https://www.youtube.com/watch?v=YdRTk77iXXE)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Using backtracking

```java
private static void type3() {
        int n = 2;
        ArrayList<Integer> result = new ArrayList<>();
        int[] nums = new int[n];
        // handling the 0 case differently
        increasingNumbers3(n, 0, 0, nums, result);
        if (n == 1) result.add(0, 0);
        System.out.println(result);
    }
    private static void increasingNumbers3(int n, int index, int prev, int[] nums, ArrayList<Integer> result) {
        if (index == n) {
            int num = 0;
            for (int i = 0; i < n; i++) num = num * 10 + nums[i];
            result.add(num);
            return;
        }
        for (int digit = prev + 1; digit <= 9; digit++) {
            nums[index] = digit;
            increasingNumbers3(n, index + 1, digit, nums, result);
        }
    }
```

### Approach 2

Using recursion

```java
private static void type2() {
        int n = 1;
        ArrayList<Integer> result = new ArrayList<>();
        // handling the 0 case differently
        increasingNumbers2(n, 0, "", result);
        if (n == 1) result.add(0, 0);
        System.out.println(result);
    }
    private static void increasingNumbers2(int n, int prev, String number, ArrayList<Integer> result) {
        if (n == 0) {
            result.add(Integer.parseInt(number));
            return;
        }
        for (int digit = prev + 1; digit <= 9; digit++) {
            increasingNumbers2(n - 1, digit, number + digit, result);
        }
    }
```

### Approach 1 — Brute Force

Using normal recursion

```java
private static void type1() {
        int n = 2;
        ArrayList<Integer> result = increasingNumbers1(n);
        // handling the 0 case differently
        if (n == 1) result.add(0, 0);
        System.out.println(result);
    }
```

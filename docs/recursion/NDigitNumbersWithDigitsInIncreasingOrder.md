# NDigitNumbersWithDigitsInIncreasingOrder

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=xlKrk3ZO3iM&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=11)
- [▶ YouTube](https://www.youtube.com/watch?v=YdRTk77iXXE)

## 📝 Problem Statement

Given an integer n, return all the n digit numbers in increasing order, such that their digits are in strictly increasing order(from left to right).
Examples :
Input: n = 1
Output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
Explanation: Single digit numbers are

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

using backtracking handling the 0 case differently

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

using recursion handling the 0 case differently

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

### Approach 1: 🔨 Brute Force

using normal recursion handling the 0 case differently

```java
    private static void type1() {
        int n = 2;
        ArrayList<Integer> result = increasingNumbers1(n);
        // handling the 0 case differently
        if (n == 1) result.add(0, 0);
        System.out.println(result);
    }

    static ArrayList<Integer> increasingNumbers1(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (n == 1) {
            for (int digit = 1; digit < 10; digit++) list.add(digit);
            return list;
        }
        ArrayList<Integer> prev = increasingNumbers1(n - 1);
        for (int num : prev) {
            int last = num % 10;
            for (int digit = last + 1; digit < 10; digit++)
                list.add(num * 10 + digit);
        }
        return list;
    }

}
```

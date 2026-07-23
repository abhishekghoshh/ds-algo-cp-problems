# ArmstrongNumbers

**Topic:** `math` | **File:** `com/problems/math/ArmstrongNumbers.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/check-armstrong_589)
- [📄 LeetCode](https://leetcode.com/problems/armstrong-number/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=1xNbjMdbjug)
- [📄 takeUforward](https://takeuforward.org/maths/check-if-a-number-is-armstrong-number-or-not/)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int n = 371;
        boolean ans = checkArmstrong(n);
        System.out.println(ans);
    }
    private static boolean checkArmstrong(int n) {
        if (n == 0) return true;
        int copy = n;
        // let's find the digit count first
        int count = 0;
        while (copy > 0) {
            count++;
            copy = copy / 10;
        }
        copy = n;
        int num = 0;
        // we will find the armstrong value then, and check both are same or not
        while (copy > 0) {
            int digit = copy % 10;
            copy = copy / 10;
            num += (int) Math.pow(digit, count);
        }
        return (n == num);
    }
```

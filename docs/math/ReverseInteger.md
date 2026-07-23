# ReverseInteger

**Topic:** `math`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/reverse-integer/description/)
- [📄 NeetCode](https://neetcode.io/problems/reverse-integer)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=1xNbjMdbjug&t=1s)
- [📄 takeUforward](https://takeuforward.org/maths/reverse-digits-of-a-number)
- [▶ YouTube](https://www.youtube.com/watch?v=HAgLH58IgJQ)

## 📝 Problem Statement

Reverse a 32-bit signed integer. Handle overflow.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach simple clean approach we know the range is -2147483648 to 2147483647 checking for positive overflow, so the int max is 2147483647, and the current reverse is already more than 214748364 so whatever will add in iteration, that will still make the reverse number an overflow number.

or the current reverse is 214748364, and the current digit is more than 7, then also the reverse number will be overflow in the current iteration checking for negative overflow exactly same as the positive overflow, but the condition is different

```java
    private static void type2() {
        int x = -123;
        int reverse = reverse2(x);
        System.out.println(reverse);
    }

    public static int reverse2(int x) {
        int reverse = 0;
        while (x != 0) {
            int digit = x % 10;
            // checking for positive overflow,
            // so the int max is 2147483647, and the current reverse is already more than 214748364
            // so whatever will add in iteration,
            // that will still make the reverse number an overflow number.
            // or the current reverse is 214748364, and the current digit is more than 7,
            // then also the reverse number will be overflow in the current iteration
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            // checking for negative overflow
            // exactly same as the positive overflow, but the condition is different
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            reverse = (reverse * 10) + digit;
            x = x / 10;
        }
        return reverse;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
        int x = -123;
    }
}
```

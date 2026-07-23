# LemonadeChange

**Topic:** `greedy` | **File:** `com/problems/greedy/LemonadeChange.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/lemonade-change/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/lemonade-change_8224112)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int[] bills = {5, 5, 10, 10, 20};
        boolean lemonadeChange = lemonadeChange(bills);
        System.out.println(lemonadeChange);
    }
    public static boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fives++;
            } else if (bill == 10) {
                if (fives == 0) return false;
                tens++;
                fives--;
            } else {
                if (tens > 0 && fives > 0) {
                    tens--;
                    fives--;
                } else if (fives >= 3) {
                    fives -= 3;
                } else return false;
            }
        }
        return true;
    }
```

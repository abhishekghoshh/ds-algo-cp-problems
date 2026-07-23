# ValidParenthesisStringWithEscapeCharacter

**Topic:** `greedy` | **File:** `com/problems/greedy/ValidParenthesisStringWithEscapeCharacter.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/lemonade-change/description/)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/lemonade-change_8224112)

## Approaches

Implementation:

### Implementation

Check one more time

```java
private static void type1() {
        String s = "(*))";
        boolean possible = checkValidString1(s);
        System.out.println(possible);
    }
    public static boolean checkValidString1(String s) {
        // open parentheses count in range [cmin, cmax]
        int cmin = 0;  // Minimum number of open parentheses
        int cmax = 0; // Maximum number of open parentheses
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmin++;
                cmax++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else { // '*' character
                cmax++; // if `*` become `(` then openCount++
                cmin--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens,
                // So openCount will be in the new range [cmin-1, cmax+1]
            }
            // If at any point, the high becomes negative, the string is not valid
            // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            // For example: ())(
            if (cmax < 0) return false;
            // It's invalid if open parentheses count < 0 that's why cmin can't be negative
            cmin = Math.max(0, cmin);
        }
        // The string is valid if the minimum number of open parentheses is 0
        return cmin == 0;
    }
```

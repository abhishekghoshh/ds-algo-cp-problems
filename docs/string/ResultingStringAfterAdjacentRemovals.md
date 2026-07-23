# ResultingStringAfterAdjacentRemovals

**Topic:** `string` | **File:** `com/problems/string/ResultingStringAfterAdjacentRemovals.java`

**Tags:** String, Stack, Greedy

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/resulting-string-after-adjacent-removals/description/)

## Approaches

Implementation:

### Implementation

This is a very optimized approach using stack, but here we are using string builder as stack and return the final string

```java
private static void type1() {
        String s = "bcda";
        String ans = resultingString(s);
        System.out.println(ans);
    }
    public static String resultingString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (sb.isEmpty()) {
                sb.append(ch);
                continue;
            }
            if (isConsecutive(sb.charAt(sb.length() - 1), ch)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
```

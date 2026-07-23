# CheckTwoChessboards

**Topic:** `logicbuilding` | **File:** `com/problems/logicbuilding/CheckTwoChessboards.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        String coordinate1 = "a1", coordinate2 = "c3";
        boolean ans = checkTwoChessboards(coordinate1, coordinate2);
        System.out.println(ans);
    }
    public static boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        // transforming
        int x1 = coordinate1.charAt(0) - 'a';
        int y1 = coordinate1.charAt(1) - '1';
        int x2 = coordinate2.charAt(0) - 'a';
        int y2 = coordinate2.charAt(1) - '1';
        // checking absolute distance is even distance or odd
        return Math.abs((x1 - y1) % 2) == Math.abs((x2 - y2) % 2);
    }
```

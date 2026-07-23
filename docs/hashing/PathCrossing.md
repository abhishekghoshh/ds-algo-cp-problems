# PathCrossing

**Topic:** `hashing` | **File:** `com/problems/hashing/PathCrossing.java`

**Tags:** Array, Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/path-crossing/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=VWRJBNP7uH8)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

This is an optimized approach same as previous but here we will not use the custom class for the hashCode here we will calculate the hash code for (x,y) and store it in the Set of integer abd check if the hash is already present in the set or not

```java
private static void type2() {
        String path = "NES";
        boolean ans = isPathCrossing2(path);
        System.out.println(ans);
    }
```

### Approach 1 — Brute Force

We will start (0,0) and depending on the direction we will increment or decrement the value of x or y todo this should come at first to your mind we will start with (0,0) and then we go to each direction one by one increment and decrement x and y coordinate accordingly we will add the coordinates into a set of Coordinates

```java
private static void type1() {
        String path = "NES";
        boolean ans = isPathCrossing1(path);
        System.out.println(ans);
    }
    private static boolean isPathCrossing1(String path) {
        Set<Pair> set = new HashSet<>();
        // (0,0) is the starting point
        Pair curr = new Pair(0, 0);
        set.add(curr);
        for (char d : path.toCharArray()) {
            // based on the direction we are choosing dx and dy
            int dx = 0, dy = 0;
            if (d == 'E') {
                dx++;
            } else if (d == 'W') {
                dx--;
            } else if (d == 'N') {
                dy++;
            } else {
                dy--;
            }
            curr = curr.clone(dx, dy);
            if (!set.add(curr)) return true;
        }
        return false;
    }
```

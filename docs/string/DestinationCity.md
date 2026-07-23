# DestinationCity

**Topic:** `string` | **File:** `com/problems/string/DestinationCity.java`

**Tags:** String, Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/destination-city/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Hi8vMnnTZHE)

## Approaches

Implementation:

### Implementation

This is a very simple problem of hashing first put all the paths in a map then for every destination city check if it is a key for the map or not if not then return the city

```java
private static void type1() {
        List<List<String>> paths = List.of();
        String ans = destCity(paths);
        System.out.println(ans);
    }
```

# FirstUniqueCharacterInAString

**Topic:** `string` | **File:** `com/problems/string/FirstUniqueCharacterInAString.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/first-unique-character-in-a-string/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=rBENYgWy3xU)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Same as previous but here we are using the int array as map as it is easy, and we know the range of character

```java
private static void type3() {
        String s = "leetcode";
        int ans = firstUniqChar3(s);
        System.out.println(ans);
    }
```

### Approach 2

Calculating the frequency now we are iterating from first to last and checking if the freq of the character is 1 if 1 then we will return the index optimized approach this is simple problem of hashing we will use a map or [char,int] and store the freq of every character

```java
private static void type2() {
        String s = "leetcode";
        int ans = firstUniqChar2(s);
        System.out.println(ans);
    }
```

### Approach 1 — Brute Force

Calculating the frequency now we are iterating from first to last and checking if the freq of the character is 1 if 1 then we will return the index brute force approach for every character we will check if this is a unique character or not

```java
private static void type1() {
    }
```

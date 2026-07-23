# FindTheDifference

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-the-difference/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=oFmv4N4z00c)

## 📝 Problem Statement

similar to the find the extra and missing number problem

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach using xor characters can be represented as the ascii integers all the characters which are present in the both strings will be cancelled only once character will be remaining

```java
    private static void type2() {
        String s = "abcd", t = "abcde";
        char ans = findTheDifference2(s, t);
        System.out.println(ans);
    }

    private static char findTheDifference2(String s, String t) {
        int xor = 0;
        for (char ch : s.toCharArray()) {
            xor ^= ch;
        }
        for (char ch : t.toCharArray()) {
            xor ^= ch;
        }
        return (char) xor;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach using a set adding all the elements of s to the set now checking from t if the element is present in the set

```java
    private static void type1() {
        String s = "abcd", t = "abcde";
        char ans = findTheDifference1(s, t);
        System.out.println(ans);
    }

    public static char findTheDifference1(String s, String t) {
        Set<Character> set = new HashSet<>();
        // adding all the elements of s to the set
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        // now checking from t if the element is present in the set
        for (char ch : t.toCharArray()) {
            if (set.contains(ch)) return ch;
        }
        return '-';
    }
}
```

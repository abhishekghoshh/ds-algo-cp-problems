# RedistributeCharactersToMakeAllStringsEqual

**Topic:** `string` | **File:** `com/problems/string/RedistributeCharactersToMakeAllStringsEqual.java`

**Tags:** String, Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=a3SmUiimBi8)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

This is same as the previous but here we will use an integer array as it easy to use an int array

```java
private static void type2() {
        String[] words = {"abc", "aabc", "bc"};
        boolean ans = makeEqual2(words);
        System.out.println(ans);
    }
    public static boolean makeEqual2(String[] words) {
        int n = words.length;
        if (n == 1) return true;
        int[] freq = new int[26];
        // storing the total frequency
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                int pos = ch - 'a';
                freq[pos]++;
            }
        }
        // checking if the freq of a char can be distributed to all the words or not
        for (int f : freq) {
            if (f % n != 0) return false;
        }
        return true;
    }
```

### Approach 1 — Brute Force

This is not brute force here we will use a freq map of [char,int] to store the total freq of the all the characters from all the words then we will divide each character freq by the total number of words if there is any character which can be distributed to all the words then we will return false

```java
private static void type1() {
        String[] words = {"abc", "aabc", "bc"};
        boolean ans = makeEqual1(words);
        System.out.println(ans);
    }
    private static boolean makeEqual1(String[] words) {
        int n = words.length;
        if (n == 1) return true;
        Map<Character, Integer> freq = new HashMap<>();
        // storing the total frequency
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                freq.put(ch, 1 + freq.getOrDefault(ch, 0));
            }
        }
        // checking if the freq of a char can be distributed to all the words or not
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int f = freq.getOrDefault(ch, 0);
            if (f % n != 0) return false;
        }
        return true;
    }
```

# FirstUniqueCharacterInAString

**Topic:** `string`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/first-unique-character-in-a-string/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=rBENYgWy3xU)

## 📝 Problem Statement

Find the first non-repeating character in a string and return its index.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as previous but here we are using the int array as map as it is easy, and we know the range of character calculating the frequency now we are iterating from first to last and checking if the freq of the character is 1 if 1 then we will return the index

```java
    private static void type3() {
        String s = "leetcode";
        int ans = firstUniqChar3(s);
        System.out.println(ans);
    }

    static int firstUniqChar3(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n == 1) return 0;
        // calculating the frequency
        int[] freq = new int[26];
        for (char ch : arr) {
            int pos = ch - 'a';
            freq[pos]++;
        }
        // now we are iterating from first to last and
        // checking if the freq of the character is 1 if 1 then we will return the index
        for (int i = 0; i < n; i++) {
            int pos = arr[i] - 'a';
            if (freq[pos] == 1) return i;
        }
        return -1;
    }
```

### Approach 2

optimized approach this is simple problem of hashing we will use a map or [char,int] and store the freq of every character calculating the frequency now we are iterating from first to last and checking if the freq of the character is 1 if 1 then we will return the index

```java
    private static void type2() {
        String s = "leetcode";
        int ans = firstUniqChar2(s);
        System.out.println(ans);
    }

    static int firstUniqChar2(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        if (n == 1) return 0;
        // calculating the frequency
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : arr) {
            freq.put(ch, 1 + freq.getOrDefault(ch, 0));
        }
        // now we are iterating from first to last and
        // checking if the freq of the character is 1 if 1 then we will return the index
        for (int i = 0; i < n; i++) {
            if (freq.getOrDefault(arr[i], 0) == 1)
                return i;
        }
        return -1;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach for every character we will check if this is a unique character or not

```java
    private static void type1() {
    }
}
```

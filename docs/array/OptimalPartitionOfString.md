# OptimalPartitionOfString

**Topic:** `array`  
**Tags:** String, Hashing, Greedy, Sliding window

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/optimal-partition-of-string/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=CKZPdiXiQf0)

## 📝 Problem Statement

Partition string into minimum substrings with unique characters.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach using sliding window approach we will use a set to mark the character which we have seen already. once there is a character that is already seen, we will reset the set and increment counter as that is the start of a new string the character is already present resetting the set, unmarking the characters 'i' is the start of the new string

```java
    private static void type2() {
        String s = "abacaba";
        int count = partitionString2(s);
        System.out.println(count);
    }

    public static int partitionString2(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        boolean[] set = new boolean[26];
        int count = 1;
        int prevStart = 0;
        for (int i = 0; i < n; i++) {
            int pos = arr[i] - 'a';
            // the character is already present
            if (set[pos]) {
                count++;
                // resetting the set, unmarking the characters
                for (int j = prevStart; j < i; j++)
                    set[arr[j] - 'a'] = false;
                // 'i' is the start of the new string
                prevStart = i;
            }
            set[pos] = true;
        }
        return count;
    }
```

### Approach 1: 🔨 Brute Force

brute force

```java
    private static void type1() {
    }
}
```

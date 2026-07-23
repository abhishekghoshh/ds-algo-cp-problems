# PartitionString

**Topic:** `string`  
**Tags:** Array, String

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/partition-string/description/)

## 📝 Problem Statement

Partition the string into as many parts as possible so that each letter appears in at most one part.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

```java
    private static void type2() {
    }
```

### Approach 1: 🔨 Brute Force

brute force solution using set

```java
    private static void type1() {
        String s = "abbccccd";
        List<String> ans = partitionString1(s);
        System.out.println(ans);
    }

    public static List<String> partitionString1(String s) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        List<String> ans = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < n; i++) {
            String sub = s.substring(start, i + 1);
            if (!seen.contains(sub)) {
                seen.add(sub);
                ans.add(sub);
                start = i + 1;
            }
        }
        return ans;
    }
}
```

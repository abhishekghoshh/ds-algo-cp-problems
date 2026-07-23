# EncodeAndDecodeStrings

**Topic:** `string` | **File:** `com/problems/string/EncodeAndDecodeStrings.java`

**Tags:** Array, String, Hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/encode-and-decode-strings/description/)
- [📄 NeetCode](https://neetcode.io/problems/string-encode-and-decode)
- [https://www.lintcode.com/problem/659/](https://www.lintcode.com/problem/659/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=B1k_sxOSgv8)
- [https://medium.com/@miniChang8/leetcode-encode-and-decode-strings-4dde7e0efa1c](https://medium.com/@miniChang8/leetcode-encode-and-decode-strings-4dde7e0efa1c)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        List<String> strs = List.of("neet", "code", "love", "you");
        String encodedString = encode(strs);
        System.out.println(encodedString);
        List<String> decodedString = decode(encodedString);
        System.out.println(decodedString);
    }
    public static String encode(List<String> list) {
        // if the list is empty then we will return null;
        if (list.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        int n = list.size();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i));
            // we will only append the separator if it is not the last element
            if (i != n - 1) sb.append(LS);
        }
        return sb.toString();
    }
    public static List<String> decode(String str) {
        // if the string is null then we will return and empty list
        if (null == str) return List.of();
        // else we will split the string based one separator
        return List.of(str.split(LS));
    }
```

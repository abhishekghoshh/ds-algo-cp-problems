# EncodeAndDecodeTinyURL

**Topic:** `array` | **File:** `com/problems/array/EncodeAndDecodeTinyURL.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/encode-and-decode-tinyurl/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=VyBOaboQLGc)
- [📄 LeetCode](https://leetcode.com/discuss/interview-question/system-design/?currentPage=1&orderBy=hot&query=)
- [📄 LeetCode](https://leetcode.com/discuss/interview-question/124658/Design-a-URL-Shortener-(-TinyURL-)-System/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

This is more of a system design problem it is a better approach we are using the system current timestamp which

```java
private static void type2() {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec2 codec = new Codec2();
        String encodedUrl = codec.encode(url);
        String decodedUrl = codec.decode(encodedUrl);
        System.out.println(encodedUrl + " -> " + decodedUrl);
    }
```

### Approach 1 — Brute Force

Encodes a URL to a shortened URL. this is basically based on the current system time it will generate a unique Decodes a shortened URL to its original URL. kind of brute force

```java
private static void type1() {
        String url = "https://leetcode.com/problems/design-tinyurl";
        Codec1 codec = new Codec1();
        String encodedUrl = codec.encode(url);
        String decodedUrl = codec.decode(encodedUrl);
        System.out.println(encodedUrl + " -> " + decodedUrl);
    }
```

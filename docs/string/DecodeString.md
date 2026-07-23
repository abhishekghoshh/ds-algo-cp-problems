# DecodeString

**Topic:** `string`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/decode-string_696319)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/decode-the-string2444/1)

## 🎥 Solution Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/decode-string-recursively-encoded-count-followed-substring/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problem-details/encode-and-decode_1467061)

## 📝 Problem Statement

Given an encoded string s, decode it by expanding the pattern k[substring], where the substring inside brackets is written k times. k is guaranteed to be a positive integer, and encodedString contains only lowercase english alphabets. Return the fina

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

using recursion

```java
    private static void type1() {
        String str = "3[a2[b]]";
        String ans = decodeString1(str);
        System.out.println(ans);
    }


    private static String decodeString1(String str) {
        char[] arr = str.toCharArray();
        int n = arr.length;

        return "";
    }
}
```

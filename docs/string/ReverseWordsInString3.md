# ReverseWordsInString3

**Topic:** `string` | **File:** `com/problems/string/ReverseWordsInString3.java`

**Tags:** String, two pointers

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/reverse-words-in-a-string-iii/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=7kUEwiwwnlA)

## Approaches

Implementation:

### Implementation

's' does not contain any leading or trailing spaces. 's' contains printable ASCII characters. All the words in s are separated by a single space.

```java
private static void type1() {
        String s = "Let's take LeetCode contest";
        String ans = reverseWords(s);
        System.out.println(ans);
    }
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // we will traverse the entire array,
        // and if the next character is a space, or it is the last character in the array,
        // then we will reverse the word
        for (int i = 0, start = 0; i < n; i++) {
            // either it is the last character or there is a space at the next character
            if (i == n - 1 || arr[i + 1] == ' ') {
                reverse(arr, start, i);
                start = i + 2; // updating the start of the word
            }
        }
        return new String(arr);
    }
    public static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char ch = arr[i];
            arr[i] = arr[j];
            arr[j] = ch;
            i++;
            j--;
        }
    }
```

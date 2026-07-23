# StringIsPalindrome

**Topic:** `recursion`  

## 📝 Problem Statement

Check if a string is a palindrome using recursion.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

if start equal to end, then it is the single letter we are considering if start is greater than the end that means we have covered all the string and start has crossed the end the start and end character is different now we will call isPalindrome function with start+1 and end-1

```java
    private static void type1() {
        String str = "aabbccbbaa";
        char[] arr = str.toCharArray();
        int n = arr.length;
        boolean isPalindrome = isPalindrome(arr, 0, n - 1);
        System.out.println(isPalindrome);
    }

    private static boolean isPalindrome(char[] str, int start, int end) {
        // if start equal to end, then it is the single letter we are considering
        // if start is greater than the end that means we have covered all the string
        // and start has crossed the end
        if (start >= end) return true;
        // the start and end character is different
        if (str[start] != str[end]) return false;
        // now we will call isPalindrome function with start+1 and end-1
        return isPalindrome(str, start + 1, end - 1);
    }

}
```

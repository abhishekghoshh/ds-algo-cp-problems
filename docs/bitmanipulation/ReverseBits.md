# ReverseBits

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/reverse-bits/description/)
- [📄 NeetCode](https://neetcode.io/problems/reverse-bits)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=UcoN6UjAI64)

## 📝 Problem Statement

Reverse all 32 bits of an unsigned integer.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

optimized approach this is very similar to the reverse of the number in decimal, but here rather divide by 10 we will divide by 2 and take the reminder from 2 though it is similar to do (n % 2) and (n & 1) and (n / 2) and (n >>> 1) we will use >>> instead of >> as the number might be in negative so >> will not work as integer has 32 bits, so we will loop it 32 times

```java
    private static void type1() {
        int n = 964176192;
        int ans = reverseBits(n);
        System.out.println(ans);
    }


    public static int reverseBits(int n) {
        int ans = 0;
        // as integer has 32 bits, so we will loop it 32 times
        for (int i = 0; i < 32; i++) {
            int digit = (n & 1);
            ans = ans * 2 + digit;
            n = n >>> 1; // shifting to the right by 1
        }
        return ans;
    }
}
```

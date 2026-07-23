# MinimumNumberOfSwapsToMakeTheStringBalanced

**Topic:** `array`  
**Tags:** Arrays, Two Pointers, String, Stack, Greedy

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=3YDBT9ZrfaU)

## 📝 Problem Statement

Each swap can fix two unmatched brackets, so the minimum number of swaps required is (unmatched+1)/2

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

check this solution again We will be a little greedy here The total number of unmatched opening brackets at the end will tell us how many swaps are necessary to balance the string so, we keep track the number of unmatched closing brackets. Each swap can fix two unmatched brackets, so the minimum number of swaps required is (unmatched+1)/2 Iterate through each character in the string Each swap can fix two imbalances, hence divide by 2

```java
    private static void type1() {
        String s = "]][][[";
        int ans = minSwaps3(s);
        System.out.println(ans);
    }

    public static int minSwaps3(String s) {
        int imbalance = 0; // This variable tracks the number of unmatched closing brackets
        int openBrackets = 0; // This variable tracks the number of unmatched opening brackets
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                openBrackets++; // Increment for an opening bracket
            } else { // c == ']'
                if (openBrackets > 0) {
                    openBrackets--; // Match with an opening bracket
                } else {
                    imbalance++; // Unmatched closing bracket
                }
            }
        }
        // Each swap can fix two imbalances, hence divide by 2
        return (imbalance + 1) / 2;
    }


}
```

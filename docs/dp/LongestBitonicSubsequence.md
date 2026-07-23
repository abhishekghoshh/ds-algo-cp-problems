# LongestBitonicSubsequence

**Topic:** `dp`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/longest-bitonic-sequence_1062688)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=y4vN0WNdrlg&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=47)
- [📄 takeUforward](https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/)

## 📝 Problem Statement

Given an array of positive integers. Find&amp;nbsp;the maximum length of Bitonic subsequence.&amp;nbsp; A subsequence of array is called Bitonic if it is first strictly increasing, then strictly decreasing. Return the maximum length of bitonic subsequence.&amp;n

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

we can do it inside a single iteration Arrays to store lengths of increasing and decreasing subsequences Calculate the lengths of increasing subsequences Reverse the direction of nested loops and calculate the lengths of decreasing subsequences Calculate the length of the longest bitonic subsequence we will decrease by 1 as for dp1 and dp2 both

```java
    private static void type3() {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;


        // Arrays to store lengths of increasing and decreasing subsequences
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for (int left = 0; left < n; left++) {
            // Calculate the lengths of increasing subsequences
            int maxLeft = 0;
            for (int prev = 0; prev < left; prev++)
                if (arr[prev] < arr[left])
                    maxLeft = Math.max(maxLeft, dp1[prev]);
            dp1[left] = maxLeft + 1;
            // Reverse the direction of nested loops and calculate the lengths of decreasing subsequences
            int right = n - 1 - left;
            int maxRight = 0;
            for (int prev = n - 1; prev > right; prev--)
                if (arr[prev] < arr[right])
                    maxRight = Math.max(maxRight, dp2[prev]);
            dp2[right] = maxRight + 1;
        }
        int max = 0;
        // Calculate the length of the longest bitonic subsequence
        // we will decrease by 1 as for dp1 and dp2 both
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp1[i] + dp2[i] - 1);

        System.out.println(max);
    }
```

### Approach 2

this is inspired from the longest increasing subsequence what is a bitonic array, it is increasing first then decreasing and decreasing means increasing from the right to left. so if we can start 2 longest increasing subsequences, and then on each index, if we take the sum, then that will be a bitonic array focusing that index at a center.

we will take the maximum to find out the longest among them Arrays to store lengths of increasing and decreasing subsequences Calculate the lengths of increasing subsequences Reverse the direction of nested loops and calculate the lengths of decreasing subsequences Calculate the length of the longest bitonic subsequence we will decrease by 1 as for dp1 and dp2 both

```java
    private static void type2() {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        // Arrays to store lengths of increasing and decreasing subsequences
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // Calculate the lengths of increasing subsequences
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int prev = 0; prev < i; prev++)
                if (arr[prev] < arr[i])
                    max = Math.max(max, dp1[prev]);
            dp1[i] = max + 1;
        }
        // Reverse the direction of nested loops and calculate the lengths of decreasing subsequences
        for (int i = n - 1; i >= 0; i--) {
            int max = 0;
            for (int prev = n - 1; prev > i; prev--)
                if (arr[prev] < arr[i])
                    max = Math.max(max, dp2[prev]);
            dp2[i] = max + 1;
        }

        int max = 0;
        // Calculate the length of the longest bitonic subsequence
        // we will decrease by 1 as for dp1 and dp2 both
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp1[i] + dp2[i] - 1);

        System.out.println(max);
    }
```

### Approach 1: 🔨 Brute Force

```java
    private static void type1() {

    }
}
```

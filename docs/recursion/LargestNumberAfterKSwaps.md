# LargestNumberAfterKSwaps

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=HAWAG7nil9o&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=9)
- [▶ YouTube](https://www.youtube.com/watch?v=DOXoQfHyc7A&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=10)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/)

## 📝 Problem Statement

Given a number k and string s of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of s at most k times.
Examples :
Input: s = &quot;1234567&quot;, k = 4
Output: 7654321
Explanation: Three swaps c

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

The findMax function takes the original string, the remaining number of swaps (k), and a reference to the maximum number found so far. It uses nested loops to compare and swap each digit with every digit that follows it. If a swap is performed, it recursively calls itself with the updated string and k-1 swaps.

The maximum number found so far is updated if the current number is greater. Return if no swaps left Consider every digit Compare it with all digits after it If digit at position i is less than digit at position j, swap it and check for maximum number so far, then recurse for remaining swaps Swap str[i] with str[j] If the current num is more than the maximum so far Recurse for the other k - 1 swaps Backtrack: Undo the swap for backtracking

```java
    private static void type1() {
        int k = 3;
        String str = "4551711527";

        char[] arr = str.toCharArray();
        Data data = new Data(arr);
        findMaximumNum2(arr, k, data);
        String answer = new String(data.num);
        System.out.println(answer);
    }

    // Intuition is
    // The findMax function takes the original string, the remaining number of swaps (k),
    // and a reference to the maximum number found so far.
    //It uses nested loops to compare and swap each digit with every digit that follows it.
    //If a swap is performed, it recursively calls itself with the updated string and k-1 swaps.
    //The maximum number found so far is updated if the current number is greater.
    public static void findMaximumNum2(char[] num, int k, Data data) {
        // Return if no swaps left
        if (k == 0) return;
        int n = num.length;
        // Consider every digit
        for (int i = 0; i < n - 1; i++) {
            // Compare it with all digits after it
            for (int j = i + 1; j < n; j++) {
                // If digit at position i is less than digit at position j, swap it
                // and check for maximum number so far, then recurse for remaining swaps
                if (num[j] > num[i]) {
                    // Swap str[i] with str[j]
                    swap(num, i, j);

                    // If the current num is more than the maximum so far
                    if (data.isLesserThan(num))
                        System.arraycopy(num, 0, data.num, 0, n);

                    // Recurse for the other k - 1 swaps
                    findMaximumNum2(num, k - 1, data);

                    // Backtrack: Undo the swap for backtracking
                    swap(num, i, j);
                }
            }
        }
    }

    private static void swap(char[] num, int i, int start) {
        char temp = num[i];
        num[i] = num[start];
        num[start] = temp;
    }

    static class Data {
        char[] num;

        Data(char[] num) {
            this.num = new char[num.length];
            System.arraycopy(num, 0, this.num, 0, num.length);
        }

        public boolean isLesserThan(char[] other) {
            int i = 0;
            while (i != other.length && other[i] == num[i]) i++;
            return i != other.length && other[i] > num[i];
        }
    }
}
```

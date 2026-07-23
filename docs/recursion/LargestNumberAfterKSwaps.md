# LargestNumberAfterKSwaps

**Topic:** `recursion` | **File:** `com/problems/recursion/LargestNumberAfterKSwaps.java`

## Problem Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=HAWAG7nil9o&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=9)
- [▶ YouTube](https://www.youtube.com/watch?v=DOXoQfHyc7A&list=PL_z_8CaSLPWdbOTog8Jxk9XOjzUs3egMP&index=10)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/)

## Approaches

Implementation:

### Implementation

Check the videos one more time

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
```

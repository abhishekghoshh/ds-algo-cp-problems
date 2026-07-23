# CountDistinctElementsInEveryWindow

**Topic:** `slidingwindow` | **File:** `com/problems/slidingwindow/CountDistinctElementsInEveryWindow.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/count-distinct-element-in-every-k-size-window_920336)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1)
- [📄 InterviewBit](https://www.interviewbit.com/problems/distinct-numbers-in-window/)

## Solution Links

- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/)
- [📄 takeUforward](https://takeuforward.org/data-structure/count-distinct-elements-in-every-window/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

If we use a simple hashmap instead of a frequency array, it will not get memory error

```java
private static void type3() {
        List<Integer> arr = List.of(1, 2, 1, 3, 4, 2, 3);
        int k = 4;
        List<Integer> ans = countDistinctElements3(arr, k);
        System.out.println(ans);
    }
    public static ArrayList<Integer> countDistinctElements3(List<Integer> arr, int k) {
        int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int f = 0;
        // for the first window
        for (int i = 0; i < k; i++) {
            int num = arr.get(i);
            int c = freq.getOrDefault(num, 0);
            if (c == 0) f++;
            freq.put(num, c + 1);
        }
        ans.add(f);
        // for the remaining window, we will decrease the left and increment the right
        for (int i = k; i < n; i++) {
            int rightNum = arr.get(i);
            int leftNum = arr.get(i - k);
            int leftC = freq.getOrDefault(leftNum, 0);
            if (leftC == 1) f--;
            freq.put(leftNum, leftC - 1);
            int rightC = freq.getOrDefault(rightNum, 0);
            if (rightC == 0) f++;
            freq.put(rightNum, rightC + 1);
            ans.add(f);
        }
        return ans;
    }
```

### Approach 2

Simple sliding window using a map of (int,int) we will first count a for the first window then simultaneously count for the remaining window we will also take a variable f to count the distinct integers sliding window approach todo this is a right solution but as the max can be 10^5 to 10^9 so the freq array will cause memory overflow error

```java
private static void type2() {
        List<Integer> arr = List.of(1, 2, 1, 3, 4, 2, 3);
        int k = 4;
        List<Integer> ans = countDistinctElements2(arr, k);
        System.out.println(ans);
    }
    public static ArrayList<Integer> countDistinctElements2(List<Integer> arr, int k) {
        int n = arr.size();
        ArrayList<Integer> ans = new ArrayList<>();
        // as we are using the frequency array so for space optimization, we can calculate the min and max
        // use (-min) as offset
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        int offset = -min;
        int N = max - min + 1;
        int[] freq = new int[N];
        int f = 0;
        // for the first window
        for (int i = 0; i < k; i++) {
            int num = arr.get(i) + offset;
            if (freq[num] == 0) f++;
            freq[num]++;
        }
        ans.add(f);
        // for the remaining window, we will decrease the left and increment the right
        for (int i = k; i < n; i++) {
            int rightNum = arr.get(i) + offset;
            int leftNum = arr.get(i - k) + offset;
            if (freq[leftNum] == 1) f--;
            freq[leftNum]--;
            if (freq[rightNum] == 0) f++;
            freq[rightNum]++;
            ans.add(f);
        }
        return ans;
    }
```

### Approach 1 — Brute Force

Simple sliding window using a frequency array we will first count a for the first window then simultaneously count for the remaining window we will also take a variable f to count the distinct integers

```java
private static void type1() {

    }
```

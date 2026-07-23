# Counting Sort

## Problem Link
- [GeeksforGeeks - Counting Sort](https://practice.geeksforgeeks.org/problems/counting-sort/1)

## Solution Link
- [GeeksforGeeks](https://www.geeksforgeeks.org/counting-sort/)

## Approaches

### Type 1: Character Sorting (Simplified)

Count frequencies of characters (a-z), then reconstruct in order. O(n + 26) time.

```java
private static void type1() {
    String str = "geeksforgeeks";
    char[] arr = str.toCharArray();
    int n = arr.length;
    int[] freq = new int[26];
    // count frequencies
    for (char c : arr) freq[c - 'a']++;
    // reconstruct in order
    int index = 0;
    for (int i = 0; i < 26; i++)
        while (freq[i] > 0) {
            arr[index++] = (char) ('a' + i);
            freq[i]--;
        }
    PrintUtl.print(arr);
}
```

### Type 2: Integer Sorting with Cumulative Count

Full counting sort for integers: compute frequency array, convert to cumulative counts (prefix sums), then place elements from right to left for stability. O(n + range).

```java
private static void type2() {
    int[] arr = {2, 5, 7, 5, 9, 15, 13, 2, 7, 8};
    int n = arr.length;
    int max = max(arr);
    int min = min(arr);
    int[] copy = copy(arr);
    int range = max - min + 1;
    int[] freq = new int[range];

    // normalize by subtracting min
    for (int j : arr) freq[j - min]++;

    // convert to cumulative counts
    // after this, freq[i] = last position+1 for value (i+min)
    for (int i = 1; i < range; i++)
        freq[i] += freq[i - 1];

    // place elements from right to left (for stability)
    for (int i = n - 1; i >= 0; i--) {
        int item = copy[i] - min;
        arr[freq[item] - 1] = copy[i];
        freq[item]--;
    }
    PrintUtl.print(arr);
}
```

## Complexity
- **Time**: O(n + k) where k = range of values
- **Space**: O(k) for frequency array
- **Stable**: Yes (Type 2 - processing right to left preserves order)

## Key Insight

The cumulative count array transforms frequencies into position indices. For value v, `freq[v-min]` tells us how many elements ≤ v exist, giving the last position for v. Processing right-to-left ensures stability.

```
Example: arr = [2, 5, 7, 5, 9, ...], min=2, max=15
freq initially:  [2, 0, 2, 0, 2, 0, ...]  (counts for values 2..15)
freq cumulative: [2, 2, 4, 4, 6, 6, ...]  (index = freq-1 is last position)
```

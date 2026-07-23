# UpperBound

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/implement-upper-bound_8165383)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=6zhGS79oQ4k)
- [📄 takeUforward](https://takeuforward.org/arrays/implement-upper-bound/)

## 📝 Problem Statement

Find the upper bound (first position where element > target).

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

maybe an answer look for smaller index on the left

```java
    private static void type2() {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int x = 9;
        int answer = upperBound(arr, x);
        System.out.println(answer);
    }

    public static int upperBound(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
        int[] arr = {3, 5, 8, 9, 15, 19};
        int n = arr.length, x = 9;
        int answer = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                // upper-bound found
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
```

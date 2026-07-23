# LargestElementInArray

**Topic:** `array`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/largest-element-in-the-array-largest-element-in-the-array_5026279)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=37E9ckMDdTk&t=531s)
- [📄 takeUforward](https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

Using in place

**Time Complexity:** `O(n)`

```java
    private static void type2() {
        int[] arr = {2, 5, 1, 3, 0};
        int max = Integer.MIN_VALUE;
        for (int item : arr) max = Math.max(max, item);
        System.out.println(max);
    }
```

### Approach 1: 🔨 Brute Force

Using sorting

**Time Complexity:** `O(nlog(n)`

```java
    private static void type1() {
        int[] arr = {2, 5, 1, 3, 0};
        int[] copy = ArrayUtil.copy(arr);
        Arrays.sort(copy);
        System.out.println(copy[copy.length - 1]);
    }
}
```

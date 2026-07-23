# LeftRotateByOne

**Topic:** `array` | **File:** `com/problems/array/LeftRotateByOne.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wvcQg43_V8U&t=61s)
- [📄 takeUforward](https://takeuforward.org/data-structure/left-rotate-the-array-by-one/)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int[] arr = {1, 2, 3, 4, 5};
        int first = arr[0];
        for (int i = 1; i < arr.length; i++)
            arr[i - 1] = arr[i];
        arr[arr.length - 1] = first;
        print(arr);
    }
```

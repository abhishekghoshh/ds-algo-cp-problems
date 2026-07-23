# LeftRotateByOne

**Topic:** `array`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/left-rotate-an-array-by-one_5026278)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wvcQg43_V8U&t=61s)
- [📄 takeUforward](https://takeuforward.org/data-structure/left-rotate-the-array-by-one/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
    private static void type1() {
        int[] arr = {1, 2, 3, 4, 5};
        int first = arr[0];
        for (int i = 1; i < arr.length; i++)
            arr[i - 1] = arr[i];
        arr[arr.length - 1] = first;
        print(arr);
    }
}
```

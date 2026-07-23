# UnionOfTwoSortedArrays

**Topic:** `array`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/sorted-array_6613259)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=wvcQg43_V8U&t=2584s)
- [📄 takeUforward](https://takeuforward.org/data-structure/union-of-two-sorted-arrays/)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution



**Time Complexity:** `O(2(m+n)`

```java
    private static void type2() {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 4, 7};
        List<Integer> answer = new ArrayList<>();
        int n1 = arr1.length, n2 = arr2.length, i1 = 0, i2 = 0;
        while (i1 < n1 && i2 < n2) {
            int item = arr1[i1] < arr2[i2] ? arr1[i1++] : arr2[i2++];
            if (answer.isEmpty() || answer.get(answer.size() - 1) != item)
                answer.add(item);
        }
        while (i1 < n1) {
            int item = arr1[i1++];
            if (answer.isEmpty() || answer.get(answer.size() - 1) != item)
                answer.add(item);
        }
        while (i2 < n2) {
            int item = arr2[i2++];
            if (answer.isEmpty() || answer.get(answer.size() - 1) != item)
                answer.add(item);
        }
        PrintUtl.print(answer);
    }
```

### Approach 1: 🔨 Brute Force



**Time Complexity:** `O((m+n)`

```java
    private static void type1() {
        int[] arr1 = {1, 3, 4, 5};
        int[] arr2 = {2, 4, 7};
        Set<Integer> set = new TreeSet<>();
        for (int item : arr1)
            set.add(item);
        for (int item : arr2)
            set.add(item);
        List<Integer> answer = new ArrayList<>(set);
        PrintUtl.print(answer);
    }
}
```

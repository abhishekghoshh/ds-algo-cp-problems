# NextGreaterElementForDifferentArray

**Topic:** `stack`  
**Tags:** Array, Stack

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/next-greater-element-i/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/next-greater-element_670312)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Du881K7Jtk8)
- [📄 takeUforward](https://takeuforward.org/data-structure/next-greater-element-using-stack/)

## 📝 Problem Statement

Given two arrays, find the Next Greater Element of nums1 elements in nums2.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as type2 just to make it leetcode optimized we will replace map to array as we know the boundary we will replace the stack with array first, we will store the item and index in the map we could store the indices into a hashmap, but as we know the range, so we could use an array now we will calculate next greater element using a stack and store it in another array this part is for finding the greater element from the stack if the num is not present in the num1 then we will skip for this num and store the result in the array

```java
    private static void type3() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] nge = nextGreaterElement3(nums1, nums2);
        print(nge);
    }

    private static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // first, we will store the item and index in the map
        // we could store the indices into a hashmap, but as we know the range,
        // so we could use an array
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        for (int i = 0; i < n1; i++) {
            int num = nums1[i];
            map[num] = i;
        }

        // now we will calculate next greater element using a stack
        // and store it in another array
        int[] nge = new int[n1];
        int top = -1;
        int[] stack = new int[n2];
        for (int i = n2 - 1; i >= 0; i--) {
            int num = nums2[i];
            // this part is for finding the greater element from the stack
            while (top != -1 && stack[top] <= num) top--;
            int gte = (top != -1) ? stack[top] : -1;
            stack[++top] = nums2[i];
            // if the num is not present in the num1 then we will skip for this num
            int idx = map[num];
            if (idx == -1) continue;
            // and store the result in the array
            nge[idx] = gte;
        }
        return nge;
    }
```

### Approach 2

Optimized solution we can find the next greater element using the monotonic increasing stack first, we will store the item and index in the map we could store the indices into a hashmap, but as we know the range, so we could use an array now we will calculate next greater element using a stack and store it in another array this part is for finding the greater element from the stack if the num is not present in the num1 then we will skip for this num and store the result in the array

```java
    private static void type2() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] nge = nextGreaterElement2(nums1, nums2);
        print(nge);
    }

    private static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // first, we will store the item and index in the map
        // we could store the indices into a hashmap, but as we know the range,
        // so we could use an array
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        for (int i = 0; i < n1; i++) {
            int num = nums1[i];
            map[num] = i;
        }
        // now we will calculate next greater element using a stack and store it in another array
        int[] nge = new int[n1];
        Stack<Integer> stack = new Stack<>();
        for (int i = n2 - 1; i >= 0; i--) {
            int num = nums2[i];
            // this part is for finding the greater element from the stack
            while (!stack.isEmpty() && stack.peek() <= num)
                stack.pop();
            int gte = !stack.isEmpty() ? stack.peek() : -1;
            stack.push(num);
            // if the num is not present in the num1 then we will skip for this num
            int idx = map[num];
            if (idx == -1) continue;
            // and store the result in the array
            nge[idx] = gte;
        }
        return nge;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach first, we will store the item and index in the map we could store the indices into a hashmap, but as we know the range, so we could use an array we will find the max if the num is not present in the num1 then we will skip for this num we will find the next greater element for the num and store the result in the array

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(1)`

```java
    public static void type1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] nge = nextGreaterElement1(nums1, nums2);
        print(nge);
    }

    private static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nge = new int[n1];
        // first, we will store the item and index in the map
        // we could store the indices into a hashmap, but as we know the range,
        // so we could use an array
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        for (int i = 0; i < n1; i++) {
            int num = nums1[i];
            map[num] = i;
        }
        // we will find the max
        for (int i = n2 - 1; i >= 0; i--) {
            // if the num is not present in the num1 then we will skip for this num
            int num = nums2[i];
            int idx = map[num];
            if (idx == -1) continue;
            // we will find the next greater element for the num
            int gte = -1;
            for (int j = i + 1; j < n2; j++) {
                if (num < nums2[j]) {
                    gte = nums2[j];
                    break;
                }
            }
            // and store the result in the array
            nge[idx] = gte;
        }
        return nge;
    }
}
```

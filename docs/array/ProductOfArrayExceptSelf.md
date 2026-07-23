# ProductOfArrayExceptSelf

**Topic:** `array`  
**Tags:** Array, Hashing, Prefix sum

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/product-of-array-except-self/description/)
- [📄 NeetCode](https://neetcode.io/problems/products-of-array-discluding-self)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=bNvIQI2wAjk)

## 📝 Problem Statement

Product of all elements except self without division.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

prefix sum approach but optimized rather than having 2 arrays we will just need 2 variable, left and right everytime we will calculate the left multiplication and save it to the ans also update the left at the 2nd loop we will start from last and calculate and right multiplication and save that to the ans and also update the right

**Time Complexity:** `O(2n)`
**Space Complexity:** `O(1)`

```java
    private static void type3() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] ans = productExceptSelf3(nums);
        PrintUtl.print(ans);
    }

    // rather than having 2 arrays we will just need 2 variable, left and right
    public static int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 1, right = 1;
        // everytime we will calculate the left multiplication and save it to the ans
        // also update the left
        for (int i = 0; i < n; ++i) {
            ans[i] = left;
            left *= nums[i];
        }
        // at the 2nd loop we will start from last and calculate and right multiplication
        // and save that to the ans and also update the right
        for (int i = n - 1; i >= 0; --i) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
```

### Approach 2

brute force approach O(n) if there is atleast one zero element its not bad approach though we will count the frequencies of 0 and also we will start we will find the zero frequency and zero index we have 3 cases to think about if there are more than one 0 then we the ans will be the array of all zeros of there is only one zero then all the indices will be 0 only then index which has that 0 will have the multiplication value if we do not have any 0 then ans[i] = mul / nums[i]

**Time Complexity:** `O(2n)`
**Space Complexity:** `O(1)`

```java
    private static void type2() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] ans = productExceptSelf1(nums);
        PrintUtl.print(ans);
    }

    // we will count the frequencies of 0
    // and also we will start
    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        long mul = 1;
        int zeroCount = 0, zeroIndex = -1;
        // we will find the zero frequency and zero index
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
                continue;
            }
            mul = mul * nums[i];
        }
        // we have 3 cases to think about
        int[] res = new int[n];
        // if there are more than one 0 then we the ans will be the array of all zeros
        if (zeroCount > 1) return res;
        // of there is only one zero then all the indices will be 0
        // only then index which has that 0 will have the multiplication value
        if (zeroCount == 1) {
            res[zeroIndex] = (int) mul;
            return res;
        }
        // if we do not have any 0 then ans[i] = mul / nums[i]
        for (int i = 0; i < n; i++) {
            res[i] = (int) (mul / nums[i]);
        }
        return res;
    }
}
```

### Approach 1: 🔨 Brute Force

prefix sum approach same we will use 2 prefix-mul array just like prefix sum array to store the prefix multiplication we need it from left and right so if the index is i then mul[i] = left-prefix-mul[i-1] * right-prefix-mul[i+1] we will compute both left and right prefix multiplication first in another loop we will calculate the ans calculating the left prefix mul calculating the left right mul calculating the ans multiplying the both side

**Space Complexity:** `O(2n)`

```java
    private static void type1() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] ans = productExceptSelf2(nums);
        PrintUtl.print(ans);
    }

    // we will use 2 prefix-mul array just like prefix sum array to store the prefix multiplication
    // we need it from left and right
    // so if the index is i then mul[i] = left-prefix-mul[i-1] * right-prefix-mul[i+1]
    // we will compute both left and right prefix multiplication first
    // in another loop we will calculate the ans
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        int[] ans = new int[n];
        // calculating the left prefix mul
        for (int i = 0; i < n; i++) {
            left[i] = nums[i] * (i > 0 ? left[i - 1] : 1);
        }
        // calculating the left right mul
        for (int i = n - 1; i >= 0; i--) {
            right[i] = nums[i] * (i < n - 1 ? right[i + 1] : 1);
        }
        // calculating the ans
        // multiplying the both side
        for (int i = 0; i < n; i++) {
            ans[i] *= (i > 0 ? left[i - 1] : 1);
            ans[i] *= (i < n - 1 ? right[i + 1] : 1);
        }
        return ans;
    }
```

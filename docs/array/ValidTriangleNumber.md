# ValidTriangleNumber

**Topic:** `array`  
**Tags:** Arrays, Two Pointers, Sorting, Greedy, Binary Search

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/valid-triangle-number/description/)

## 🎥 Solution Links

- [https://www.hellointerview.com/learn/code/two-pointers/valid-triangle-number](https://www.hellointerview.com/learn/code/two-pointers/valid-triangle-number)

## 📝 Problem Statement

check (a+b) > c and (b+c) > a and (a+c) > b

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

taking the intuition of the type2 approach but, here instead of finding one pair at a time we will find sequence of numbers which satisfy the condition. again, we will start with sorting the number array, and we will start with this point. let's say a and b are the two smallest sides and c is the largest side.

so basically we need to find which numbers hold this (a + b) > c we will fix c which will be nums.length - 1 now lets we are at ith and jth index (i < j) and this condition holds (nums[i] + nums[j]) > c. and if we go to right from ith index and towards the jth index so nums[i] will only increase.

so (nums[i] + nums[j]) > c this condition will hold for all the numbers from i to j. so we will do the same for all the c starting from the last index. this condition holds (nums[i] + nums[j]) > nums[k], means we found our range of triplets we will add (j-i) range to our answer now we will test with j-1, as this is the only way to decrease the value of (nums[i] + nums[j]) else means (nums[i] + nums[j]) <= nums[k], this condition holds, so we will increase the value of (nums[i] + nums[j]) and only way to increase it is by increasing i

```java
    private static void type3() {
        int[] nums = {2, 2, 3, 4};
        int answer = triangleNumber3(nums);
        System.out.println(answer);
    }

    private static int triangleNumber3(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int k = nums.length - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                // this condition holds (nums[i] + nums[j]) > nums[k], means we found our range of triplets
                // we will add (j-i) range to our answer
                // now we will test with j-1, as this is the only way to decrease the value of (nums[i] + nums[j])
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                }else{
                    // else means (nums[i] + nums[j]) <= nums[k], this condition holds,
                    // so we will increase the value of (nums[i] + nums[j]) and only way to increase it is by increasing i
                    i++;
                }
            }
        }
        return count;
    }
```

### Approach 2

Here we will sort the array, now in the left we have smaller number and in the right we have larger numbers, and we will follow this rule (a + b > c) => b > (c - a) so will fix the left side(a) and right side(c) and we need to find the middle(b) which is greater than (c - a) and we can find it using binary search, as the array is sorted we will fix the left side and right side and find the middle


```java
    private static void type2() {
        int[] nums = {2, 2, 3, 4};
        int answer = triangleNumber2(nums);
        System.out.println(answer);
    }

    private static int triangleNumber2(int[] nums) {
        int count = 0;
        int n = nums.length;
        if (n <= 2) return 0;
        Arrays.sort(nums);
        // we will fix the left side and right side and find the middle
        for (int end = n - 1; end >= 2; end--) {
            for (int start = 0; start <= end - 2; start++) {
                int seed = nums[end] - nums[start];
                count += greaterCount(nums, start + 1, end - 1, seed);
            }
        }
        return count;
    }

    public static int greaterCount(int[] nums, int start, int end, int seed) {
        if (start == end) return (nums[start] > seed) ? 1 : 0;
        if (nums[start] > seed) return end - start + 1;
        if (nums[end] <= seed) return 0;
        int endIndex = end;
        int greaterIndex = end;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (seed < nums[mid]) {
                end = mid;
                greaterIndex = mid;
            } else {
                start = mid + 1;
            }
        }
        return endIndex - greaterIndex + 1;
    }
```

### Approach 1: 🔨 Brute Force

Brute Force Approach Find all the triplets in the array and check if they can form a triangle or not check (a+b) > c and (b+c) > a and (a+c) > b


```java
    private static void type1() {
        int[] nums = {2, 2, 3, 4};
        int answer = triangleNumber1(nums);
        System.out.println(answer);
    }

    private static int triangleNumber1(int[] nums) {
        return 0;
    }

}
```

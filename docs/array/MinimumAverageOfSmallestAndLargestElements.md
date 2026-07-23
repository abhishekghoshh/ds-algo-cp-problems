# MinimumAverageOfSmallestAndLargestElements

**Topic:** `array`  
**Tags:** hashing, swap-sort, Cycle-Detection-Using-Tortoise-Method

## 📝 Problem Statement

and skip these in the next iteration

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

we can use the same array, we just need to sort it to find the smallest element on the left side and the largest elements on the right side. so we will use two pointers at the start and the end and traverse the array

```java
    private static void type3() {
        int[] nums = {7, 8, 3, 4, 15, 13, 4, 1};
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = n - 1;
        double min = nums[n - 1];
        while (i < j) {
            double avg = ((double) (nums[i] + nums[j])) / 2;
            if (avg < min) min = avg;
            i++;
            j--;
        }
        System.out.println(min);
    }
```

### Approach 2

store the smallest and largest n/2 numbers in 2 heaps simultaneously then pop from heap and take average max heap for storing n/2 smallest element and min for storing n/2 largest elements

```java
    private static void type2() {
        int[] nums = {7, 8, 3, 4, 15, 13, 4, 1};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int k = n / 2;
        for (int num : nums) {
            if (minHeap.size() == k) minHeap.poll();
            minHeap.offer(num);

            if (maxHeap.size() == k) maxHeap.poll();
            maxHeap.offer(num);
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            double avg = ((double) (maxHeap.poll() + minHeap.poll())) / 2;
            min = Math.min(min, avg);
        }
        System.out.println(min);
    }
```

### Approach 1: 🔨 Brute Force

brute force approach, find the smallest and largest number from the array and remove it from the array. do this for n/2 times use a visited array to mark the current smallest and largest number, and skip these in the next iteration

```java
    private static void type1() {
    }


}
```

package com.problems.special.meetinthemiddle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
 * Problem link :
 * https://leetcode.com/problems/closest-subsequence-sum
 *
 *
 * Solution link :
 * https://www.youtube.com/watch?v=naz_9njI0I0
 *
 */
public class ClosestSubsequenceSum {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
        type5();
        type6();
        type7();
    }

    // TODO study it later
    // best approach in leetcode
    private static void type7() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int answer = minAbsDifference7(nums, goal);
        System.out.println(answer);
    }

    public static int minAbsDifference7(int[] nums, int goal) {
        int all_length = nums.length;
        int all_mid = all_length >> 1;
        int[] left = new int[1];
        int[] right = new int[1];

        for (int i = 0; i < all_mid; i++) {
            left = dfs(left, nums[i]);
        }
        for (int i = all_mid; i < all_length; i++) {
            right = dfs(right, nums[i]);
        }
        int ans = Integer.MAX_VALUE;
        Arrays.sort(left);
        Arrays.sort(right);
        for (int i = 0, j = right.length - 1; i < left.length && j >= 0; i++) {
            while (j >= 0 && left[i] + right[j] > goal) {
                j--;
            }
            int k = j + 1;
            if (k < right.length) {
                ans = Math.min(ans, left[i] + right[k] - goal);
            }
            if (j >= 0) {
                ans = Math.min(ans, goal - left[i] - right[j]);
            }
        }
        return ans;
    }

    public static int[] dfs(int[] curr, int val) {
        int n = curr.length;
        int j = 0;
        int p = 0;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            while (j < n && curr[i] > curr[j] + val) {
                ans[p++] = curr[j] + val;
                j++;
            }
            ans[p++] = curr[i];
            if (j < n && curr[i] == curr[j] + val) {
                j++;
            }
        }
        while (j < n) {
            ans[p++] = curr[j] + val;
            j++;
        }
        return ans;
    }

    // TODO study it later
    private static void type6() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int answer = minAbsDifference5(nums, goal);
        System.out.println(answer);
    }

    public static int MAXN = 1 << 20;
    public static int[] lsum = new int[MAXN];
    public static int[] rsum = new int[MAXN];
    public static int fill;

    public int minAbsDifference6(int[] nums, int goal) {
        int n = nums.length;

        long max = 0;
        long min = 0;
        for (int num : nums)
            if (num >= 0) max += num;
            else min += num;
        if (goal >= max) return (int) Math.abs(max - goal);
        if (goal <= min) return (int) Math.abs(min - goal);

        Arrays.sort(nums);
        int res = Math.abs(goal);
        fill = 0;
        count(nums, 0, n / 2, 0, lsum);
        int lsize = fill;
        fill = 0;
        count(nums, n / 2, n, 0, rsum);
        int rsize = fill;
        Arrays.sort(lsum, 0, lsize);
        Arrays.sort(rsum, 0, rsize);

        for (int i = 0, j = rsize - 1; i < lsize; i++) {
            while (j > 0 && Math.abs(goal - lsum[i] - rsum[j - 1]) <= Math.abs(goal - lsum[i] - rsum[j]))
                j--;
            res = Math.min(res, Math.abs(goal - lsum[i] - rsum[j]));
        }
        return res;
    }

    public static void count(int[] nums, int cur, int end, int pastSum, int[] arr) {
        if (cur == end) {
            arr[fill] = pastSum;
            fill++;
        } else {
            int next = cur + 1;
            while (next < end && nums[next] == nums[cur])
                next++;
            for (int k = 0; k < next - cur + 1; k++)
                count(nums, next, end, pastSum + k * nums[cur], arr);
        }
    }

    // meet in the middle technique
    // with little optimization
    private static void type5() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int answer = minAbsDifference5(nums, goal);
        System.out.println(answer);
    }

    public static int minAbsDifference5(int[] nums, int goal) {
        int p = 0, n = 0;
        for (int num : nums) {
            if (num > 0) p += num;
            if (num < 0) n += num;
        }
        if (goal >= p) return goal - p;
        if (goal <= n) return n - goal;

        Set<Integer> s1 = new HashSet<>();
        TreeSet<Integer> s2 = new TreeSet<>();
        int mid = nums.length / 2;
        backtrack(nums, 0, mid - 1, 0, s1);
        if (s1.contains(goal)) return 0;
        backtrack(nums, mid, nums.length - 1, 0, s2);
        if (s2.contains(goal)) return 0;

        int min = Integer.MAX_VALUE;
        for (int x : s1) {
            int target = goal - x;
            Integer ceil = s2.ceiling(target);
            if (ceil != null) {
                if (ceil == target) return 0;
                min = Math.min(min, ceil - target);
                Integer prev = s2.lower(ceil);
                if (prev != null) {
                    min = Math.min(min, target - prev);
                }
            } else min = Math.min(min, target - s2.last());

        }
        return min;
    }

    private static void backtrack(int[] nums, int start, int end, int sum, Set<Integer> set) {
        if (start > end) {
            set.add(sum);
            return;
        }
        // select
        backtrack(nums, start + 1, end, sum + nums[start], set);
        // not select
        backtrack(nums, start + 1, end, sum, set);
    }


    // man in the middle technique
    // here we will sort both first and second array
    // then we will apply two-pointer approach
    private static void type4() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int n = nums.length;
        int half = n >> 1;
        int[] first = getAllSumArray(nums, 0, half);
        int[] second = getAllSumArray(nums, half + 1, n - 1);
        int minAbs = Integer.MAX_VALUE;
        int i = 0, j = second.length - 1;
        while (i < first.length && j >= 0) {
            int sum = first[i] + second[j];
            minAbs = Math.min(minAbs, Math.abs(goal - sum));
            if (minAbs == 0) break;
            else if (sum < goal) i++;
            else j--;
        }
        System.out.println(minAbs);
    }

    private static int[] getAllSumArray(int[] nums, int start, int end) {
        int[] array = new int[1 << (end + 1 - start)];
        for (int i = start; i <= end; i++) {
            int offset = 1 << (i - start);
            for (int j = 0; j < offset; j++) {
                array[j + offset] = array[j] + nums[i];
            }
        }
        Arrays.sort(array);
        return array;
    }



    // same as type2 but here we will generate all the sum using recursion
    private static void type3() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int n = nums.length;
//        if (n == 1) return Math.min(Math.abs(goal), Math.abs(nums[0] - goal));
        index = 0;
        int n1 = n / 2, n2 = n - n / 2;
        int[] firstHalf = new int[1 << n1];
        findAllSums(0, n / 2, 0, nums, firstHalf);
        index = 0;
        int[] secondHalf = new int[1 << n2];
        findAllSums(n / 2, n, 0, nums, secondHalf);
        Arrays.sort(secondHalf);
        int answer = Integer.MAX_VALUE;
        int closest;
        for (int item : firstHalf) {
            closest = findClosestElement(goal - item, secondHalf);
            answer = Math.min(answer, Math.abs(goal - item - closest));
        }
        System.out.println(answer);
    }

    private static int index = 0;

    private static void findAllSums(int i, int end, int sum, int[] nums, int[] subsetSumArray) {
        if (i == end) {
            subsetSumArray[index++] = sum;
            return;
        }
        findAllSums(i + 1, end, sum + nums[i], nums, subsetSumArray);
        findAllSums(i + 1, end, sum, nums, subsetSumArray);
    }


    // using meet in the middle approach
    private static void type2() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        int n = nums.length;
//        if (n == 1) return Math.min(Math.abs(goal), Math.abs(nums[0] - goal));
        int[] firstHalf = findAllSums(nums, 0, n / 2 - 1, 0);
        int[] secondHalf = findAllSums(nums, n / 2, n - 1, n / 2);
        Arrays.sort(secondHalf);
        int answer = Integer.MAX_VALUE;
        int closest;
        for (int item : firstHalf) {
            closest = findClosestElement(goal - item, secondHalf);
            answer = Math.min(answer, Math.abs(goal - item - closest));
        }
        System.out.println(answer);
    }

    // time complexity O(2^n)
    private static int[] findAllSums(int[] nums, int start, int end, int offset) {
        int n = end - start + 1;
        int bound = 1 << n;
        int[] res = new int[bound];
        int sum;
        for (int i = 0; i < bound; ++i) {
            sum = 0;
            for (int j = 0; j < n; ++j)
                if ((i & (1 << j)) != 0)
                    sum += nums[j + offset];
            res[i] = sum;
        }
        return res;
    }

    // binary search to find the closest possible number from the array
    private static int findClosestElement(int item, int[] arr) {
        int n = arr.length;
        if (item <= arr[0]) return arr[0];
        if (item >= arr[n - 1]) return arr[n - 1];
        int low = 0, high = n - 1, mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] == item) return item;
            else if (arr[mid] < item) low = mid + 1;
            else high = mid - 1;
        }
        // at this point low exceeds high
        // the sequence is like arr[high], item, arr[low]
        // so we will calculate the difference with low and high places
        int differenceWithLow = arr[low] - item;
        int differenceWithHigh = item - arr[high];
        return differenceWithLow < differenceWithHigh ? arr[low] : arr[high];
    }



    //brute force approach
    // we will generate all the possible sum
    // and while generating we will try to find the closest subset sum to the goal
    private static void type1() {
        int[] nums = {7, -9, 15, -2};
        int goal = -5;
        Data data = new Data();
        data.answer = Integer.MAX_VALUE;
        data.goal = goal;
        generateAllSums(0, 0, nums, data);
        System.out.println(data.answer);
    }

    static class Data {
        int answer, goal;
    }

    private static void generateAllSums(int i, int sum, int[] nums, Data data) {
        if (i == nums.length) {
            data.answer = Math.min(data.answer, Math.abs(data.goal - sum));
            return;
        }
        generateAllSums(i + 1, sum + nums[i], nums, data);
        generateAllSums(i + 1, sum, nums, data);
    }

}

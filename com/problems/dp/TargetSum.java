package com.problems.dp;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/target-sum/description/
 * https://neetcode.io/problems/target-sum
 *
 * Solution link :
 * https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
 *
 * https://www.youtube.com/watch?v=g0npyaQtAQM
 * https://www.youtube.com/watch?v=dwMOrl85Xes
 * https://neetcode.io/solutions/target-sum
 *
 * https://www.youtube.com/watch?v=b3GD8263-PQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=22
 * https://takeuforward.org/data-structure/target-sum-dp-21/
 */
public class TargetSum {

    // You are given an integer array nums and an integer target.
    // You want to build an expression out of nums by adding one of the symbols '+'
    // and '-' before each integer in nums and then concatenate all the integers.
    // For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
    // and concatenate them to build the expression "+2-1".
    // Return the number of different expressions that you can build, which
    // evaluates to target.
    public static void main(String[] args) {
        // the intuition is different
        type1();
        type2();
        type3();
        type4();
        // intuition from the count number of subset with given sum difference
        type5();
    }

    // intuition from the count number of subset with given sum difference (CountNumberOfSubsetWithGivenSumDifference.type2)
    private static void type5() {
        // todo check the type2 from the count number of subset with given sum difference
        //  we can apply the same logic here
        //  add + or - to num means there will be some numbers which will have positive sign and some will have negative
    }

    // If we look closely at the last solution, we can observe that to evaluate the
    // current row of dp, only the last row of the dp array is needed.
    // Thus, we can save some space by using a 1D dp array instead of a 2D dp array.
    // The only change required is that we have to create an array next[].
    // Of the same size as dp so that we can update it while scanning through dp
    // since it is not safe to mutate dp when the iteration is in progress. After
    // the iteration is completed, we set dp equal to next and create a new
    // empty array next before the next iteration starts, and so on.
    // Time complexity: O(t.n)O(t.n). Each of the nn dp arrays of size tt has
    // been filled just once. Here, tt refers to the sum of the num array and
    // nn refers to the length of the nums array.
    // Space complexity: O(t)O(t). Two dp arrays of size 2t + 12⋅t+1 are
    // used; therefore, the space usage is O(t)O(t).
    private static void type4() {
        int[] nums = { 1, 1, 1, 2, 3 };
        int target = 2;
        int count = findTargetSumWays4(nums, target);
        System.out.println(count);
    }

    private static int findTargetSumWays4(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        // if sum + target is odd, then we cannot make subsets
        // if the sum is lesser than the target, then we cannot make the target by
        // subtracting one partition to another
        if ((sum + target) % 2 != 0 || sum < Math.abs(target))
            return 0;
        int[] dp = new int[2 * sum + 1];
        dp[nums[0] + sum] = 1;
        dp[-nums[0] + sum] += 1;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int[] temp = new int[2 * sum + 1];
            for (int s = -sum; s <= sum; s++) {
                int offsetSum = s + sum;
                if (dp[offsetSum] > 0) {
                    temp[offsetSum + num] += dp[offsetSum];
                    temp[offsetSum - num] += dp[offsetSum];
                }
            }
            dp = temp;
        }

        return dp[target + sum];
    }


    private static void type3() {
        int[] nums = { 1, 1, 1, 2, 3 };
        int target = 2;
        int count = findTargetSumWays3(nums, target);
        System.out.println(count);
    }

    private static int findTargetSumWays3(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        // if sum + target is odd, then we cannot make subsets
        // if the sum is lesser than the target, then we cannot make the target by
        // subtracting one partition to another
        if ((sum + target) % 2 != 0 || sum < Math.abs(target))
            return 0;

        // if we think closely, then intermediate sum can be range from -total to +total,
        // - total when all signs are negative and +total when all signs are positive
        // so our range will be from o..n and -total..+total
        // so can make our dp array to store intermediate result, but we can not use negative index,
        // so we will add offset and our offset will be the total sum
        int[][] dp = new int[n][2 * sum + 1];
        // till 0th element the total sum can be +0th element or -0th element, so we will increment the count
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;

        // we will start from 1
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int s = -sum; s <= sum; s++) {
                int offsetSum = s + sum;
                // dp[i - 1][offsetSum] is greater than 0 means it is possible to create sum s with n-1 elements
                // so will take current num use both of the signs and add the value of dp[i - 1][offsetSum] to that
                if (dp[i - 1][offsetSum] > 0) {
                    dp[i][offsetSum + num] += dp[i - 1][offsetSum];
                    dp[i][offsetSum - num] += dp[i - 1][offsetSum];
                }
            }
        }
        return dp[n - 1][target + sum];
    }


    // todo will only work on the positive numbers
    /*
    *  Recursion with Memoization.
      In the last approach, we can observe that a lot of redundant function calls
      were made with the same value of i as the current index and the same value of
      the sum as the current sum.
      Since the same values could be obtained through multiple paths in the recursion tree.
      To remove this redundancy, we make use of memoization as well to store the results
      which have been calculated earlier.

      Thus, for every call to calculate(nums, i, sum, S), we store the result obtained in memo[i][sum + total],
      where total stands for the sum of all the elements from the input array.
      The factor of total has been added as an offset to the sum value
      to map all the sum possible to positive integer range.
      By making use of memoization, we can get the result of each redundant function call in constant time.

      Time complexity: O(t *n)).
      The memo array of size O(t*n) has been filled just once.
      Here, tt refers to the sum of the nums array and nn refers to the length of the nums array.
      Space complexity: O(t*n).
      The depth of the recursion tree can go up to n. The memo array contains t*n elements.

      0 <= nums[i] <= 1000 criteria is in the input
      if all num is less than zero then we can just use Math.abs(sum)
      we will add sum as offset
      as at some point there be a situation where the current sum can be less than
      zero, so to tackle that we will increase the array size by sum,
      so if all the elements will be minus then also the current sum will get 0
    * */
    private static void type2() {
        int[] nums = {1, 1, 1, 2, 3};
        int target = 2;
        int count = findTargetSumWays2(nums, target);
        System.out.println(count);
    }

    public static int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        // if sum + target is odd, then we cannot make subsets
        // if the sum is lesser than the target, then we cannot make the target by
        // subtracting one partition to another
        if ((sum + target) % 2 != 0 || sum < Math.abs(target))
            return 0;

        int[][] dp = new int[n][2 * sum + 1];
        // we are using -1 set the cell value as unvisited
        for (int[] row : dp) Arrays.fill(row, -1);

        return findTargetSumWays2(nums, 0, 0, target, dp, sum);
    }

    public static int findTargetSumWays2(int[] nums, int i, int sum, int target, int[][] dp, int offset) {
        // if index reaches nums length that means we have consumed the entire array
        int n = nums.length;
        if (i == n)
            return (sum == target) ? 1 : 0;

        // we are checking in the dp table if it consists the value,
        // we are adding offset because the sum can be negative
        if (dp[i][sum + offset] != -1) return dp[i][sum + offset];

        // else we have 2 possible choices, either add + to this number or add (-)to this number,
        // but before return, we will set the dp cell value
        return dp[i][sum + offset] =
                findTargetSumWays2(nums, i + 1, sum + nums[i], target, dp, offset)
                        + findTargetSumWays2(nums, i + 1, sum - nums[i], target, dp, offset);
    }


    // todo will only work on the positive numbers
    /*
    *  Brute force approach
     The brute force approach is based on recursion.
     We need to try to put both the + and - symbols at every location in the given nums array
     and find out the assignments which lead to the required result
     For this, we make use of a recursive function calculate(nums, i, sum, S),
     which returns the assignments leading to the sum SS, starting from the ith
     index onwards, provided the sum of elements up to the ith element is sum.
     This function appends a + sign and a - sign both to the element at the
     current index and calls itself with the updated sum as sum +
     nums[i]sum+nums[i] and sum - nums[i]sum−nums[i] respectively along with the
     updated current index as i+1.
     Whenever we reach the end of the array, we compare the sum obtained with SS.
     If they are equal, we increment the count value to be returned.
     Time complexity: O(2^n) as Size of recursion tree will be 2^n
     Space complexity: O(n) The depth of the recursion tree can go up to n.
    * */
    private static void type1() {
        int[] nums = {1, 1, 1, 2, 3};
        int target = 2;
        int count = findTargetSumWays1(nums, 0, 0, target);
        System.out.println(count);
    }

    public static int findTargetSumWays1(int[] nums, int i, int sum, int target) {
        // if index reaches nums length that means we have consumed the entire array
        int n = nums.length;
        if (i == n)
            return (sum == target) ? 1 : 0;
        // else we have 2 possible choices, either add + to this number or add - to this number
        return findTargetSumWays1(nums, i + 1, sum + nums[i], target)
                    + findTargetSumWays1(nums, i + 1, sum - nums[i], target);
    }
}

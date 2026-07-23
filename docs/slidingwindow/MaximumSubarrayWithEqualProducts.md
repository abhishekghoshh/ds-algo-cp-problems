# MaximumSubarrayWithEqualProducts

**Topic:** `slidingwindow` | **File:** `com/problems/slidingwindow/MaximumSubarrayWithEqualProducts.java`

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
        int[] nums = {1, 2, 1, 2, 1, 1, 1};
        int ans = maxLength2(nums);
        System.out.println(ans);
    }
    public static int maxLength2(int[] nums) {
        int n = nums.length;
        int mul = nums[0] * nums[1];
        int gcd = gcd(nums[0], nums[1]), lcm = lcm(nums[0], nums[1]);
        int max = 2, len = 2;
        int i = 2;
        while (i < n) {
            int num = nums[i];
            mul = mul * num;
            gcd = gcd(gcd, num);
            lcm = lcm(lcm, num);
            if (gcd * lcm != mul) {
                int j = i;
                mul = nums[j] * nums[j - 1];
                gcd = gcd(nums[j], nums[j - 1]);
                lcm = lcm(nums[j], nums[j - 1]);
                j--;
                len = 1;
                while (gcd * lcm == mul) {
                    len++;
                    if (j >= 1) j--;
                    else break;
                    mul = mul * nums[j];
                    gcd = gcd(gcd, nums[j]);
                    lcm = lcm(lcm, nums[j]);
                }
            } else {
                len++;
            }
            i++;
            max = Math.max(max, len);
        }
        return max;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        int[] nums = {1, 2, 1, 2, 1, 1, 1};
        int ans = maxLength1(nums);
        System.out.println(ans);
    }
    private static int maxLength1(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int start = 0; start < n; start++) {
            long product = 1;
            int gcd = nums[start];
            int lcm = nums[start];
            for (int end = start; end < n; end++) {
                product *= nums[end];
                // Update GCD
                gcd = gcd(gcd, nums[end]);
                // Update LCM
                lcm = lcm(lcm, nums[end]);
                // Check if prod(arr) == lcm(arr) * gcd(arr)
                if (product == (long) lcm * gcd) {
                    max = Math.max(max, end - start + 1);
                }
            }
        }
        return max;
    }
```

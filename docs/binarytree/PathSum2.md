# PathSum2

**Topic:** `binarytree` | **File:** `com/problems/binarytree/PathSum2.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/path-sum-ii/description/)

## Approaches

Implementation:

### Implementation

Normal dfs traversal

```java
private static void type1() {
        TNode root = TNode.withCount(15);
        List<List<Integer>> ans = pathSum(root, 15);
        System.out.println(ans);
    }
    public static List<List<Integer>> pathSum(TNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root, 0, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    private static void pathSum(TNode root, int sum, int targetSum, List<Integer> bucket, List<List<Integer>> ans) {
        if (null == root) return;
        // adding current node to the bucket and the sum
        bucket.add(root.data);
        sum += root.data;
        // if it is the terminal node then only we will add the list to the ans
        if (null == root.left && null == root.right)
            if (sum == targetSum) ans.add(new ArrayList<>(bucket));
        // now we will traverse both of its left and right subtree if it is there
        if (null != root.left) pathSum(root.left, sum, targetSum, bucket, ans);
        if (null != root.right) pathSum(root.right, sum, targetSum, bucket, ans);
        bucket.remove(bucket.size() - 1);
    }
```

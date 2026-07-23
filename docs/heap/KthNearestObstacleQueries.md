# KthNearestObstacleQueries

**Topic:** `heap`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/k-th-nearest-obstacle-queries/description/)

## 📝 Problem Statement

it is a very simple problem of k nearest types using heap

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

it is a very simple problem of k nearest types using heap we will create a max heap and limit the size of the heap by k and always take the top most element distance is calculated via this formula for query(x,y)

```java
    private static void type1() {
        int[][] queries = {{1, 2}, {3, 4}, {2, 3}, {-3, 0}};
        int k = 2;
        int[] ans = resultsArray(queries, k);
        PrintUtl.print(ans);
    }

    public static int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int[] ans = new int[n];
        // we will create a max heap and limit the size of the heap by k
        // and always take the top most element
        PriorityQueue<Integer> heap = new PriorityQueue<>((d1, d2) -> d2 - d1);
        int i = 0;
        for (int[] q : queries) {
            // distance is calculated via this formula for query(x,y)
            int dis = Math.abs(q[0]) + Math.abs(q[1]);
            heap.offer(dis);
            if (heap.size() > k) heap.poll();
            if (heap.size() < k) {
                ans[i++] = -1;
                continue;
            }
            ans[i++] = heap.peek();
        }
        return ans;
    }

}
```

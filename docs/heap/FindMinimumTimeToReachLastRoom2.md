# FindMinimumTimeToReachLastRoom2

**Topic:** `heap` | **File:** `com/problems/heap/FindMinimumTimeToReachLastRoom2.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Check the question, it has an extra condition Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two using heap

```java
private static void type2() {
        int[][] moveTime = {{0, 0, 0, 0}, {0, 0, 0, 0}};
        int ans = minTimeToReach2(moveTime);
        System.out.println(ans);
    }
    public static int minTimeToReach2(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<Point> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p.t));
        // we will store the coordinate and time to reach to the current cell
        // also we will store the
        heap.offer(new Point(0, 0, 0, 1));
        int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!heap.isEmpty()) {
            Point p = heap.poll();
            if (p.x == n - 1 && p.y == m - 1) return p.t;
            for (int[] del : delta) {
                int x = p.x + del[0];
                int y = p.y + del[1];
                // if x and y is in bounds or x,y is not already visited
                if (x < 0 || x > n - 1 || y < 0 || y > m - 1 || moveTime[x][y] < 0) continue;
                int t, mt = moveTime[x][y];
                if (p.t >= mt) t = p.t + p.d;
                else t = mt + p.d;
                // Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two
                int nextD = (p.d == 1) ? 2 : 1;
                heap.offer(new Point(x, y, t, nextD));
                moveTime[x][y] = -1;
            }
        }
        return -1;
    }
```

### Approach 1 — Brute Force

Brute force

```java
private static void type1() {

    }
```

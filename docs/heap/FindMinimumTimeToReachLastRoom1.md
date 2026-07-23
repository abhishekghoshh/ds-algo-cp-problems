# FindMinimumTimeToReachLastRoom1

**Topic:** `heap`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/)

## 📝 Problem Statement

Find minimum time to reach the last room in a grid (Part 1).

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

using heap we will store the coordinate and time to reach to the current cell if x and y is in bounds or x,y is not already visited if the neighbour cell reach time is less than the prev time then we can directly go to the neighbour cell, else we have to wait for the neighbour's reach time and +1 for going to that cell

```java
    private static void type2() {int[][] moveTime = {{0, 0, 0}, {0, 0, 0}};
        int ans = minTimeToReach2(moveTime);
        System.out.println(ans);

    }

    public static int minTimeToReach2(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<Point> heap = new PriorityQueue<>(Comparator.comparingInt(p -> p.t));
        // we will store the coordinate and time to reach to the current cell
        heap.offer(new Point(0, 0, 0));
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
                // if the neighbour cell reach time is less than the prev time then we can directly go to the
                // neighbour cell, else we have to wait for the neighbour's reach time
                // and +1 for going to that cell
                if (p.t >= mt) t = p.t + 1;
                else t = mt + 1;
                heap.offer(new Point(x, y, t));
                moveTime[x][y] = -1;
            }
        }
        return -1;
    }

    static class Point {
        int x, y, t;

        Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
```

### Approach 1: 🔨 Brute Force

brute force

```java
    private static void type1() {

    }
}
```

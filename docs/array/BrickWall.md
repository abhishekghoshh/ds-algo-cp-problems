# BrickWall

**Topic:** `array`  
**Tags:** Arrays, Hashing, Prefix Sum

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/brick-wall/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Kkmv2h48ekw)

## 📝 Problem Statement

Find the minimum number of crossed bricks in a vertical line.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

same as the previous approach but here we are using the same loop going to the all row and saving the length at which the bricks are ending and checking the max count on which bricks are ending so if we place the line at the maxBricksEnding then it will cross (n - maxBricksEnding) number of bricks

```java
    private static void type3() {
        List<List<Integer>> wall = List.of(
                List.of(1, 2, 2, 1),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(2, 4),
                List.of(3, 1, 2),
                List.of(1, 3, 1, 1)
        );
        int ans = leastBricks3(wall);
        System.out.println(ans);
    }

    public static int leastBricks3(List<List<Integer>> wall) {
        Map<Integer, Integer> scale = new HashMap<>();
        int n = wall.size();
        int maxBricksEnding = 0;
        // going to the all row and saving the length at which the bricks are ending
        for (List<Integer> row : wall) {
            int length = 0;
            int size = row.size();
            for (int j = 0; j < size - 1; j++) {
                length += row.get(j);
                // and checking the max count on which bricks are ending
                int count = 1 + scale.getOrDefault(length, 0);
                maxBricksEnding = Math.max(maxBricksEnding, count);
                scale.put(length, count);
            }
        }
        // so if we place the line at the maxBricksEnding then it will cross (n - maxBricksEnding) number of bricks
        return n - maxBricksEnding;
    }
```

### Approach 2

optimized approach using hashing lets break the problem the line will cross the least number of the bricks means most of the bricks will be ending at this line so if the can find what is the length where the most of the bricks have ended we will image a imaginary scale on the wall (0, total-width) we use a variable length, and we will add bricks length to the length variable so if the bricks are [1, 2, 2, 1] so then we will find bricks at 1, 3, 5, 6 we will use a map and store how many bricks are at every length we could skip the last brick because the last brick will end at the end, and we can not draw the line on the wall, hence will skip the last brick going to the all row and saving the length at which the bricks are ending skipping the last brick and checking the max count on which bricks are ending so if we place the line at the maxBricksEnding then it will cross (n - maxBricksEnding) number of bricks

```java
    private static void type2() {
        List<List<Integer>> wall = List.of(
                List.of(1, 2, 2, 1),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(2, 4),
                List.of(3, 1, 2),
                List.of(1, 3, 1, 1)
        );
        int ans = leastBricks2(wall);
        System.out.println(ans);
    }

    public static int leastBricks2(List<List<Integer>> wall) {
        Map<Integer, Integer> scale = new HashMap<>();
        int n = wall.size();
        // going to the all row and saving the length at which the bricks are ending
        for (List<Integer> row : wall) {
            int length = 0;
            int size = row.size();
            // skipping the last brick
            for (int j = 0; j < size - 1; j++) {
                length += row.get(j);
                scale.put(length, 1 + scale.getOrDefault(length, 0));
            }
        }
        // and checking the max count on which bricks are ending
        int maxBricksEnding = 0;
        for (Map.Entry<Integer, Integer> entry : scale.entrySet()) {
            int count = entry.getValue();
            maxBricksEnding = Math.max(maxBricksEnding, count);
        }
        // so if we place the line at the maxBricksEnding then it will cross (n - maxBricksEnding) number of bricks
        return n - maxBricksEnding;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
    }
}
```

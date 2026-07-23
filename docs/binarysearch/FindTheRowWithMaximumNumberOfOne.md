# FindTheRowWithMaximumNumberOfOne

**Topic:** `binarysearch`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/row-of-a-matrix-with-maximum-ones_982768)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=SCz-1TtYxDI&t=2s)
- [📄 takeUforward](https://takeuforward.org/arrays/find-the-row-with-maximum-number-of-1s/)

## 📝 Problem Statement

Find the row with maximum number of 1s in a sorted binary matrix.

## 💡 Approaches

This problem can be solved in **4** different ways, each improving upon the previous:

### Approach 4: 🏆 Optimal Solution

best solution spreading to the right if there is any one for a row we are going as much as possible if there is any 0 encountered we are going to the next row if that cell is also 0 then again we are going to the next row

**Time Complexity:** `O(m+n)`

```java
    private static void type4() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        int n = 3, m = 3;
        int left = 0, right = m - 1;
        int maxI = -1;
        // spreading to the right if there is any one
        // for a row we are going as much as possible
        // if there is any 0 encountered we are going to the next row
        // if that cell is also 0 then again we are going to the next row
        while (left < n && right >= 0) {
            if (matrix.get(left).get(right) == 1) {
                maxI = left;
                right--;
            } else {
                left++;
            }
        }
        System.out.println(maxI);
    }
```

### Approach 3

complete it optimized from the previous one we will calculate for the 1st row then for the next row we will check if there is any 1 present or not if not then we will go to next row if yes we will try to calculate the first 1 for that row we repeat this process until we go till nth row

```java
    private static void type3() {

    }
```

### Approach 2

binary search approach traverse the rows: get the number of 1's: look for smaller index on the left

```java
    private static void type2() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        int n = 3, m = 3;
        int max = 0, maxI = -1, ones;
        // traverse the rows:
        for (int i = 0; i < n; i++) {
            // get the number of 1's:
            ones = m - lowerBound(matrix.get(i), m, 1);
            if (ones > max) {
                max = ones;
                maxI = i;
            }
        }
        System.out.println(maxI);
    }

    public static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0, high = n - 1, mid, ans = n;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (x <= arr.get(mid)) {
                ans = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else low = mid + 1; // look on the right
        }
        return ans;
    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        int n = 3, m = 3;

        int max = 0, index = -1, ones;
        for (int i = 0; i < n; i++) {
            ones = 0;
            for (int j = 0; j < m; j++) ones += matrix.get(i).get(j);
            if (ones > max) {
                max = ones;
                index = i;
            }
        }
        System.out.println(index);
    }
}
```

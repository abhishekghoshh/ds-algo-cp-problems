# FindKPairsWithSmallestSums

**Topic:** `heap` | **File:** `com/problems/heap/FindKPairsWithSmallestSums.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Check it later

```java
private static void type3() {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 20;
        List<List<Integer>> ans = kSmallestPairs3(nums1, nums2, k);
        System.out.println(ans);
    }
    public static List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<IndexPair> minSumPair = new PriorityQueue<>(
                Comparator.comparingInt(pair -> (nums1[pair.i1] + nums2[pair.i2])));
        IndexPair pair = new IndexPair(0, 0);
        minSumPair.add(pair);
        for (int i = 0; i < k; i++) {
            pair = minSumPair.poll();
            int i1 = pair.i1, i2 = pair.i2;
            ans.add(List.of(nums1[i1], nums2[i2]));
            if (i1 + 1 < n1)
                minSumPair.add(new IndexPair(i1 + 1, i2));
            // todo there is a problem of duplicate pairs that's why we have used a set
            //  but if we use this i1==0 then it's getting succeeded
            //  check why i1 == 0 is the main condition
            if (i2 + 1 < n2 && i1 == 0)
                minSumPair.add(new IndexPair(i1, i2 + 1));
        }
        return ans;
    }
```

### Approach 2

We will use a min heap to fetch the minimum element we will start with (0,0) and poll the minimum element everytime then we will offer (i+1,j) and (i+j+1) which can be the next minimum element

```java
private static void type2() {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 20;
        List<List<Integer>> ans = kSmallestPairs2(nums1, nums2, k);
        System.out.println(ans);
    }
    private static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        // we will use this max heap with our custom comparator
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        Set<Pair> pairSet = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        // we will start with the minimum element, which will be (0,0) element
        Pair pair = new Pair(0, 0, (nums1[0] + nums2[0]));
        minHeap.offer(pair);
        pairSet.add(pair);
        int size = 0;
        while (size < k) {
            pair = minHeap.poll();
            int i1 = pair.i1, i2 = pair.i2;
            ans.add(List.of(nums1[i1], nums2[i2]));
            if (i1 + 1 < n1) {
                Pair p1 = new Pair(i1 + 1, i2, (nums1[i1 + 1] + nums2[i2]));
                if (!pairSet.contains(p1)) {
                    pairSet.add(p1);
                    minHeap.offer(p1);
                }
            }
            if (i2 + 1 < n2) {
                Pair p2 = new Pair(i1, i2 + 1, (nums1[i1] + nums2[i2 + 1]));
                if (!pairSet.contains(p2)) {
                    pairSet.add(p2);
                    minHeap.offer(p2);
                }
            }
            size++;
        }
        return ans;
    }
```

### Approach 1 — Brute Force

Along with heap we have also used a set just to remove the duplicate pairs brute force approach we will calculate all the pair and sort them

```java
private static void type1() {
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 20;
        List<List<Integer>> ans = kSmallestPairs1(nums1, nums2, k);
        System.out.println(ans);
    }
    private static List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        // let's calculate the pairs first
        List<List<Integer>> list = new ArrayList<>();
        for (int item1 : nums1) {
            for (int item2 : nums2)
                list.add(List.of(item1, item2));
        }
        // we will sort the pairs with their pair multiplication
        list.sort(Comparator.comparingInt(l -> l.get(0) + l.get(1)));
        // we will take the sublist
        return list.subList(0, k);
    }
```

# MeetingRooms1

**Topic:** `greedy` | **File:** `com/problems/greedy/MeetingRooms1.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/meeting-rooms/description/)
- [https://www.lintcode.com/problem/920/](https://www.lintcode.com/problem/920/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=PaJxqZVPhbg)
- [https://leetcode.ca/all/252.html](https://leetcode.ca/all/252.html)
- [https://nwthomas.medium.com/meeting-rooms-leetcode-920-7e9d06f38a23](https://nwthomas.medium.com/meeting-rooms-leetcode-920-7e9d06f38a23)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
    }
```

### Approach 1 — Brute Force

Brute force but efficient approach

```java
private static void type1() {
        List<List<Integer>> intervals = new ArrayList<>(List.of(
                List.of(0, 30),
                List.of(5, 10),
                List.of(15, 20)
        ));
        boolean ans = canAttendMeetings(intervals);
        System.out.println(ans);
    }
    public static boolean canAttendMeetings(List<List<Integer>> intervals) {
        // sorting the intervals based on their starting time
        intervals.sort(Comparator.comparingInt(p -> p.get(0)));
        int i = 0, n = intervals.size();
        // we will initialize the end time with -inf
        int end = Integer.MIN_VALUE;
        while (i < n) {
            List<Integer> interval = intervals.get(i++);
            int newStartTime = interval.get(0);
            int newEndTime = interval.get(1);
            // we will check if the last meeting end time is greater than the current meeting starting time
            // so there is a conflict
            if (end > newStartTime) return false;
            // else we will set the current meeting end time to the end time
            end = newEndTime;
        }
        return true;
    }
```

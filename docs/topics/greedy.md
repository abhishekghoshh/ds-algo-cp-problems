# Greedy

## Overview

**18 files** covering greedy scheduling, interval problems, coin change, and allocation problems.

## Pattern

Greedy algorithms make locally optimal choices at each step. Key is proving that these local choices lead to a globally optimal solution.

## Problem Categories

### Scheduling & Intervals

| Problem | Greedy Choice |
|---------|--------------|
| N Meetings in One Room | Sort by end time, pick non-overlapping |
| Meeting Rooms I | Sort by start, check overlap |
| Meeting Rooms II | Min-heap of end times |
| Minimum Platforms | Sort arrivals & departures, two-pointer scan |
| Non-overlapping Intervals | Sort by end, count removals needed |
| Insert Interval | Add non-overlapping, merge overlapping |
| Job Sequencing Problem | Sort by profit, schedule in latest slot |

```java
// Job Sequencing: Sort by profit descending, assign to latest deadline
Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
int[] slots = new int[maxDeadline + 1];
for (Job j : jobs) {
    for (int t = j.deadline; t > 0; t--) {
        if (slots[t] == 0) {
            slots[t] = j.id;
            totalProfit += j.profit;
            break;
        }
    }
}
```

### Coin & Change

| Problem | Greedy Choice |
|---------|--------------|
| Minimum Coins | Pick largest denomination ≤ remaining (requires canonical system) |
| Fractional Knapsack | Sort by value/weight ratio, take max |
| Lemonade Change | Keep count of $5 and $10 bills |
| Candy | Left-to-right + right-to-left pass for rating neighbors |

### Other Greedy Problems

| Problem | Technique |
|---------|-----------|
| Assign Cookies | Sort both, two-pointer |
| Gas Station | Track total gas and current tank |
| Shortest Job First | Sort by burst time, cumulative waiting |
| Increasing Triplet Subsequence | Track first and second minimum |
| Non-decreasing Array | At most one modification check |
| Valid Parenthesis with Wildcard | Min/Max open bracket counts |
| Minimum Pushes to Type Word | Sort frequency, assign 1/2/3 pushes |
| Lexicographically Largest String | Greedy construction |
| Maximum Distinct Elements | Greedy reduction |

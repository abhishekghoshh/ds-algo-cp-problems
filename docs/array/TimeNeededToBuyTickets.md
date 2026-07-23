# TimeNeededToBuyTickets

**Topic:** `array` | **File:** `com/problems/array/TimeNeededToBuyTickets.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/time-needed-to-buy-tickets/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=cVmS9N6kf2Y)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimized approach apparently it seems like a queue problem but we can simplify this and k = 2 for the tickets[3,4,3,2,5] where n = 5 on first iteration it will after 5 seconds it will be [2,3,2,1,4] on second iteration it will after 5 seconds it will be [1,2,1,0,3] or [1,2,1,3] on third iteration it will after 3 second it will be [0,1,0,0,3] we are not decreasing any index after k because those person will get tickets after kth person at this time kth person has bought all his tickets, and we have found our answer So, person < k has bought either kth or tickets[i] ticket, whatever is less and the persons > k will buy either (kth-1) or tickets[i] ticket, whatever is less we will compute the person before and after separately

```java
private static void type2() {
        int[] tickets = {2, 3, 2};
        int k = 2;
        int ans = timeRequiredToBuy(tickets, k);
        System.out.println(ans);
    }
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int ticket = tickets[k];
        int totalTime = 0;
        // persons before k will buy at max kth ticket
        for (int i = 0; i < k; i++) {
            totalTime += Math.min(ticket, tickets[i]);
        }
        // kth person will buy his ticket
        totalTime += ticket;
        // persons before k will buy at max kth ticket - 1
        for (int i = k + 1; i < n; i++) {
            totalTime += Math.min(ticket - 1, tickets[i]);
        }
        return totalTime;
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {

    }
```

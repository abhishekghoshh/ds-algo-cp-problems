# Problem Series

## Overview

**15 files** in `com/problems/special/` covering problem series (Jump Game, Meet in the Middle, DSA Pumbai).

## Jump Game Series (7 variants)

All in `com/problems/special/jumpgame/`:

| Problem | Constraint | Approach |
|---------|-----------|----------|
| Jump Game 1 | Can you reach the end? | Greedy: track max reachable index |
| Jump Game 2 | Min jumps to reach end | Greedy BFS levels or DP |
| Jump Game 3 | Can reach 0 from start? | DFS/BFS on index graph |
| Jump Game 4 | Min jumps with equal-value teleport | BFS + HashMap for equal values |
| Jump Game 5 | Max indices visitable (decreasing) | DP + DFS with memo |
| Jump Game 6 | Max score, jump ≤ k steps | DP + sliding window max (deque) |
| Jump Game 7 | Can reach, binary string, range jumps | DP + sliding window/set |
| Frog Jump 1 | Cross river with stone positions | DP + HashSet |
| Frog Jump 2 | Min cost crossing river | DP |

## Stock Series

All in `com/problems/array/` and `com/problems/dp/`:

| Problem | Transactions | Constraint |
|---------|-------------|------------|
| Stock I | 1 | Max profit from one buy-sell |
| Stock II | Unlimited | Sum all positive diffs |
| Stock III | 2 | DP with transaction count |
| Stock IV | K | Generalized DP |
| With Cooldown | Unlimited | Can't buy 1 day after sell |
| With Fee | Unlimited | Subtract fee on each sell |

## Stone Game Series (Placeholders)

Referenced in `src/problem-series.md` as future work.

## DSA Pumbai

| Problem | Approach |
|---------|----------|
| Week 51 - K-Beauty of Number | Count substrings of length k that divide the number |

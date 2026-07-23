# P and NP Problems

## Overview

P vs NP is one of the most important unsolved problems in computer science.

## Definitions

- **P (Polynomial Time)**: Problems that can be solved by a deterministic Turing machine in polynomial time. These are considered "efficiently solvable."
- **NP (Nondeterministic Polynomial Time)**: Problems whose solutions can be verified by a deterministic Turing machine in polynomial time.
- **NP-Complete**: The hardest problems in NP. If any NP-Complete problem is in P, then P = NP.
- **NP-Hard**: Problems at least as hard as NP-Complete problems, but not necessarily in NP.

## Common NP-Complete Problems

| Problem | Description |
|---------|------------|
| Traveling Salesman (TSP) | Shortest route visiting all cities |
| Knapsack (Decision) | Can value ≥ V be achieved with weight ≤ W? |
| Boolean Satisfiability (SAT) | Is there an assignment making a boolean formula true? |
| Graph Coloring | Can a graph be colored with k colors? |
| Hamiltonian Cycle | Does a graph have a cycle visiting each vertex exactly once? |
| Subset Sum | Does a subset sum to a target value? |

## Dealing with NP-Complete Problems

When faced with NP-Complete problems, common approaches include:

1. **Approximation Algorithms**: Find near-optimal solutions (e.g., greedy for TSP within factor)
2. **Restricted Inputs**: Problems may be polynomial on special graphs (trees, bipartite)
3. **Parameterized Algorithms**: Complexity measured in terms of parameter k (e.g., vertex cover in O(2^k × n))
4. **Heuristics**: Practical solutions without theoretical guarantees
5. **Exact Exponential Algorithms**: Acceptable for small n (e.g., DP for TSP: O(n² × 2^n))

## P = NP?

The question of whether P = NP remains unsolved. Most computer scientists believe P ≠ NP.

## Resources

- [The greatest unsolved problem in computer science...](https://www.youtube.com/watch?v=x36UmiSiEzc)
- [Coursera: Shortest Paths Revisited, NP-Complete Problems](https://www.coursera.org/learn/algorithms-npcomplete)

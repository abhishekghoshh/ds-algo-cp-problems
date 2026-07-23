# FlipCoinsAndRangeQuery

**Topic:** `segmenttree` | **File:** `com/problems/segmenttree/FlipCoinsAndRangeQuery.java`

## Approaches

Implementation:

### Implementation

In this problem, we will have 2 kinds of queries 1. Flip the coins in a range (convert head to tail and tail to head) 2. How many heads are present in a range? in update query range of coins will be flipped. we will store the number of heads only flip means rangeCount - countOfHead we will use a boolean array for lazy index if false means no need to flip then true means flip even times of flip means no flip This is a problem of sum segment tree but as we are having range updates, so we are using lazy propagation here

```java
private static void type1() {

	}
```

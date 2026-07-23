# BitSet

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/BitSet.java`

## Approaches

Implementation:

### Implementation

Constraint 0 <= n <= 30 if the constraint is 0 <= n <= 60 then we can use double data type space complexity O(1) time complexity O(1)

**Complexity:** Time: o(1) | Space: o(1)

```java
private static void type1() {
		Set set = new Set();
		set.add(4);
		set.add(9);
		set.add(25);
		System.out.println(set.contains(4) + " " + set.contains(9) + " " + set.contains(25));
		set.remove(9);
		System.out.println(set.contains(4) + " " + set.contains(9) + " " + set.contains(25));
		System.out.println(set);
	}
```

# BitManipulation

**Topic:** `bitmanipulation` | **File:** `com/problems/bitmanipulation/BitManipulation.java`

## Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/bit-manipulation_8142533)

## Approaches

Implementation:

### Implementation

Brute force approach

```java
private static void type1() {
        int num = 25, i = 3;
        int[] answer = bitManipulation(num, i);
        print(answer);
    }
    public static int[] bitManipulation(int num, int i) {
        int mask = 1 << (i - 1);
        int bit = (num & mask) > 0 ? 1 : 0;
        int setBit = num | mask;
        int clearBit = num & (~mask);
        return new int[]{bit, setBit, clearBit};
    }
```

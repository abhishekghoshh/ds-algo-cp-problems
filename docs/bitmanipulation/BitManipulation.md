# BitManipulation

**Topic:** `bitmanipulation`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/bit-manipulation_8142533)

## 📝 Problem Statement

Code 360 by Coding Ninjas

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

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

}
```

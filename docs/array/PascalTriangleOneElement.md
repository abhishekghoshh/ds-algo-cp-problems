# PascalTriangleOneElement

**Topic:** `array` | **File:** `com/problems/array/PascalTriangleOneElement.java`

## Approaches

Implementation:

### Implementation

Specific element on pascal triangle

```java
private static void type1() {
        int row = 5;
        int column = 3;
        // value is (r-1) C (c-1)
        int value = 1;
        for (int i = row - 1; i > column - 1; i--) {
            value = value * i;
        }
        for (int i = column - 1; i > 1; i--) {
            value = value / i;
        }
        System.out.println("5th row 3rd column value is " + value);
    }
```

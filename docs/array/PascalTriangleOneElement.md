# PascalTriangleOneElement

**Topic:** `array`  

## 📝 Problem Statement

specific element on pascal triangle

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

specific element on pascal triangle value is (r-1) C (c-1)

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
}
```

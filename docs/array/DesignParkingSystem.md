# DesignParkingSystem

**Topic:** `array`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-parking-system/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=d5zCHesOrSk)

## 📝 Problem Statement

Design a parking system for big/medium/small cars.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

```java
    private static void type1() {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        parkingSystem.addCar(1);
        parkingSystem.addCar(2);
        parkingSystem.addCar(3);
        parkingSystem.addCar(1);
    }

    static class ParkingSystem {
        int[] parking;

        public ParkingSystem(int big, int medium, int small) {
            this.parking = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            if (parking[carType - 1] == 0) return false;
            parking[carType - 1]--;
            return true;
        }
    }

}
```

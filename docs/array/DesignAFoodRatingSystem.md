# DesignAFoodRatingSystem

**Topic:** `array` | **File:** `com/problems/array/DesignAFoodRatingSystem.java`

**Tags:** Array, hashing

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-a-food-rating-system/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Ikp8SgbgbEo)

## Approaches

Implementation:

### Implementation

Optimized approach, rather than updating the rating of the food we will add another food object in the priority queue while getting the highest rated queue we will

```java
private static void type1() {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        foodRatings.highestRated("korean"); // return "kimchi"
        // "kimchi" is the highest rated korean food with a rating of 9.
        foodRatings.highestRated("japanese"); // return "ramen"
        // "ramen" is the highest rated japanese food with a rating of 14.
        foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "sushi"
        // "sushi" is the highest rated japanese food with a rating of 16.
        foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
        foodRatings.highestRated("japanese"); // return "ramen"
        // Both "sushi" and "ramen" have a rating of 16.
        // However, "ramen" is lexicographically smaller than "sushi".
    }
```

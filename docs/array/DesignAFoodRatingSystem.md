# DesignAFoodRatingSystem

**Topic:** `array`  
**Tags:** Array, hashing

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-a-food-rating-system/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=Ikp8SgbgbEo)

## 📝 Problem Statement

Design a food rating system with cuisines and ratings.

## 💡 Approaches

This problem can be solved in **1** different ways, each improving upon the previous:

### Approach: Implementation

optimized approach, rather than updating the rating of the food we will add another food object in the priority queue while getting the highest rated queue we will "kimchi" is the highest rated korean food with a rating of 9. "ramen" is the highest rated japanese food with a rating of 14.

"sushi" is the highest rated japanese food with a rating of 16. Both "sushi" and "ramen" have a rating of 16. However, "ramen" is lexicographically smaller than "sushi". Map food with its rating. Map food with the cuisine it belongs to. Store all food of a cuisine in a priority queue (to sort them on ratings/name) Priority queue element -> Food: (foodRating, foodName) Store 'rating' and 'cuisine' of the current 'food' in 'foodRatingMap' and 'foodCuisineMap' maps.

Insert the '(rating, name)' element into the current cuisine's priority queue. Update food's rating in the 'foodRating' map. Insert the '(new food rating, food name)' element into the respective cuisine's priority queue. rather updating the existing food object we will add another one Get the highest rated 'food' of 'cuisine'.

If the top food rating does not match with the rating from foodRatingMap then it is an old rating we can just poll it from the food rating max heap Return the name of the highest-rated 'food' of 'cuisine'. Store the food's rating. Store the food's name.

Implement the compareTo method for comparison If food ratings are the same, sort based on their names (lexicographically smaller name food will be on top) Sort based on food rating (bigger rating food will be on top)

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

    static class FoodRatings {
        // Map food with its rating.
        Map<String, Integer> foodRatingMap = new HashMap<>();
        // Map food with the cuisine it belongs to.
        Map<String, String> foodCuisineMap = new HashMap<>();

        // Store all food of a cuisine in a priority queue (to sort them on ratings/name)
        // Priority queue element -> Food: (foodRating, foodName)
        Map<String, PriorityQueue<Food>> cuisineFoodMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; ++i) {
                // Store 'rating' and 'cuisine' of the current 'food' in 'foodRatingMap' and 'foodCuisineMap' maps.
                String food = foods[i];
                int rating = ratings[i];
                String cuisine = cuisines[i];
                foodRatingMap.put(food, rating);
                foodCuisineMap.put(food, cuisine);
                // Insert the '(rating, name)' element into the current cuisine's priority queue.
                cuisineFoodMap.computeIfAbsent(cuisine, k -> new PriorityQueue<>()).add(new Food(rating, food));
            }
        }

        public void changeRating(String food, int newRating) {
            // Update food's rating in the 'foodRating' map.
            foodRatingMap.put(food, newRating);
            // Insert the '(new food rating, food name)' element into the respective cuisine's priority queue.
            String cuisine = foodCuisineMap.get(food);
            // rather updating the existing food object we will add another one
            cuisineFoodMap.get(cuisine).add(new Food(newRating, food));
        }

        public String highestRated(String cuisine) {
            // Get the highest rated 'food' of 'cuisine'.
            PriorityQueue<Food> foodRatingMaxHeap = cuisineFoodMap.get(cuisine);
            Food highestRated = foodRatingMaxHeap.peek();

            // If the top food rating does not match with the rating from foodRatingMap then it is an old rating
            // we can just poll it from the food rating max heap
            while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
                foodRatingMaxHeap.poll();
                highestRated = foodRatingMaxHeap.peek();
            }
            // Return the name of the highest-rated 'food' of 'cuisine'.
            return highestRated.foodName;
        }
    }

    static class Food implements Comparable<Food> {
        // Store the food's rating.
        public int foodRating;
        // Store the food's name.
        public String foodName;

        public Food(int foodRating, String foodName) {
            this.foodRating = foodRating;
            this.foodName = foodName;
        }

        // Implement the compareTo method for comparison
        @Override
        public int compareTo(Food other) {
            // If food ratings are the same, sort based on their names (lexicographically smaller name food will be on top)
            if (foodRating == other.foodRating) {
                return foodName.compareTo(other.foodName);
            }
            // Sort based on food rating (bigger rating food will be on top)
            return -1 * Integer.compare(foodRating, other.foodRating);
        }
    }
}
```

package com.problems.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/*
 * Problem link:
 * https://leetcode.com/problems/design-a-food-rating-system/description/
 *
 * Solution link:
 * https://www.youtube.com/watch?v=Ikp8SgbgbEo
 *
 * https://neetcode.io/solutions/design-a-food-rating-system
 */


// Tags: Array, hashing
public class DesignAFoodRatingSystem {
    public static void main(String[] args) {
        type1();
    }


    private static void type1() {
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
                foodRatingMap.put(foods[i], ratings[i]);
                foodCuisineMap.put(foods[i], cuisines[i]);
                // Insert the '(rating, name)' element into the current cuisine's priority queue.
                cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
            }
        }

        public void changeRating(String food, int newRating) {
            // Update food's rating in the 'foodRating' map.
            foodRatingMap.put(food, newRating);
            // Insert the '(new food rating, food name)' element into the respective cuisine's priority queue.
            String cuisineName = foodCuisineMap.get(food);
            cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
        }

        public String highestRated(String cuisine) {
            // Get the highest rated 'food' of 'cuisine'.
            Food highestRated = cuisineFoodMap.get(cuisine).peek();

            // If the latest rating of 'food' doesn't match the 'rating' on which it was sorted in the priority queue,
            // then we discard this element from the priority queue.
            while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
                cuisineFoodMap.get(cuisine).poll();
                highestRated = cuisineFoodMap.get(cuisine).peek();
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

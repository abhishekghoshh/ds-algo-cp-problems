package com.ds.stack;

import com.util.PrintUtl;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/asteroid-collision/description/
 * https://www.codingninjas.com/studio/problems/asteroid-collision_977232
 *
 * Solution link :
 * https://www.youtube.com/watch?v=LN7KjRszjk4
 *
 * */
public class AsteroidCollision {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
        type4();
    }

    // it could be simplified more
    // but it is ok
    // it can be done anytime

    // better approach
    // Explains it in the interview
    private static void type4() {
        int[] asteroids = {10, 2, -5};
        Stack<Integer> stack = new Stack<>();
        // intuition is only a left side positive asteroid can collide with current negative asteroid
        // because positive will go left and negative will go right
        // and thats how they will collide
        for (int asteroid : asteroids) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroid > 0) stack.push(asteroid);
            else {
                boolean isCurrentDestroyed = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int last = stack.pop();
                    if (last >= -asteroid) {
                        isCurrentDestroyed = true;
                        if (last > -asteroid) stack.push(last);
                        break;
                    }
                }
                if (!isCurrentDestroyed) stack.push(asteroid);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) answer[i] = stack.pop();
        PrintUtl.print(answer);
    }

    // same as type2,
    // but here we will not use stack data structure directly
    // we will use array as stack
    private static void type3() {
        int[] asteroids = {10, 2, -5};
        int n = asteroids.length;
        int top = -1;
        int[] stack = new int[n];
        int last, current;
        for (int asteroid : asteroids) {
            stack[++top] = asteroid;
            // at least there are two asteroids
            while (top >= 1) {
                current = stack[top];
                last = stack[top - 1];
                if (last > 0 && current < 0) {
                    if (last > -current) stack[--top] = last;
                    else if (last < -current) stack[--top] = current;
                    else top -= 2;
                } else break;
            }
        }
        int[] answer = new int[top + 1];
        for (int i = answer.length - 1; i >= 0; i--) answer[i] = stack[top--];
        PrintUtl.print(answer);
    }

    // optimized approach
    // using stack,
    // we will add the asteroids one by one to the stack
    // and pop the top two items and check if they will collide or not,
    // we can only destroy the asteroids if there are at least 2 asteroids,
    // and depending on the top 2 asteroids weight and sign, we either push one or none
    private static void type2() {
        int[] asteroids = {10, 2, -5};
        Stack<Integer> stack = new Stack<>();
        int last, current;
        for (int asteroid : asteroids) {
            stack.push(asteroid);
            while (stack.size() >= 2) {
                current = stack.pop();
                last = stack.pop();
                if (last > 0 && current < 0) {
                    if (last > -current) stack.push(last);
                    else if (last < -current) stack.push(current);
                } else {
                    stack.push(last);
                    stack.push(current);
                    break;
                }
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) answer[i] = stack.pop();
        PrintUtl.print(answer);
    }

    // brute force approach
    private static void type1() {

    }
}

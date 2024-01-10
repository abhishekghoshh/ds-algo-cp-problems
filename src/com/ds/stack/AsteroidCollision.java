package com.ds.stack;

import com.util.ArrayUtil;

import java.util.Stack;

/*
 * Problem link :
 * https://leetcode.com/problems/asteroid-collision/description/
 * https://www.codingninjas.com/studio/problems/asteroid-collision_977232
 *
 * Solution link :
 * */
public class AsteroidCollision {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // same as type2
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
        ArrayUtil.print(answer);
    }

    // optimized approach
    // using stack,
    // we will add the asteroids one by one to the stack
    // and pop the top two items and check if they will collide or not

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
        ArrayUtil.print(answer);
    }

    // brute force approach
    private static void type1() {

    }
}

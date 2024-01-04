package com.ds.stack;

import com.util.ArrayUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 *
 * problem links :
 * https://leetcode.com/problems/next-greater-element-i/description/
 * https://www.codingninjas.com/studio/problems/next-greater-element_670312
 *
 * Solution link :
 * https://www.youtube.com/watch?v=Du881K7Jtk8
 *
 * https://takeuforward.org/data-structure/next-greater-element-using-stack/
 * */
public class NextGreaterElementForDifferentArray {
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }

    // same as type2
    // just to make it leetcode optimized
    // we will replace map to array as we know the boundary
    // we will replace the stack with array
    private static void type3() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int n1 = nums1.length;
        int n2 = nums2.length;

        // first, we will store the item and index in the map
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        for (int i = 0; i < n1; i++) map[nums1[i]] = i;

        // now we will calculate next greater element using a stack
        // and store it in another array
        int[] nge = new int[n1];
        int top = -1;
        int[] stack = new int[n2];
        int item;
        for (int i = n2 - 1; i >= 0; i--) {
            item = nums2[i];
            while (top != -1 && stack[top] <= item) top--;
            if (map[item] != -1)
                nge[map[item]] = top == -1 ? -1 : stack[top];
            stack[++top] = nums2[i];
        }
        ArrayUtil.print(nge);
    }

    // this is the most optimal solution
    // using stack
    private static void type2() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int n1 = nums1.length;
        int n2 = nums2.length;

        // first, we will store the item and index in the map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n1; i++) map.put(nums1[i], i);

        // now we will calculate next greater element using a stack
        // and store it in another array
        int[] nge = new int[n1];
        Stack<Integer> stack = new Stack<>();
        int item;
        for (int i = n2 - 1; i >= 0; i--) {
            item = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= item) stack.pop();
            if (map.containsKey(item))
                nge[map.get(item)] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        ArrayUtil.print(nge);
    }

    // brute force approach
    // time complexity O(n^2)
    // space complexity O(1)
    public static void type1() {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nge = new int[n2];

    }
}

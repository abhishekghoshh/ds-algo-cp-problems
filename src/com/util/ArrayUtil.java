package com.util;

import java.util.List;

public class ArrayUtil {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void print2D(int[][] matrix) {
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void print(List<Integer> arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void print(int[] arr) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void print(int[]... arrays) {
        for (int[] array : arrays) {
            for (int num : array) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    public static void print(char[] arr) {
        for (char item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int maxN(int... arr) {
        int max = Integer.MIN_VALUE;
        for (int item : arr)
            if (item > max)
                max = item;
        return max;
    }
    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int item : arr) max = Math.max(item, max);
        return max;
    }

    public static int minN(int... arr) {
        int min = Integer.MAX_VALUE;
        for (int item : arr)
            if (item < min)
                min = item;
        return min;
    }

    public static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int item : arr) min = Math.min(item, min);
        return min;
    }

    public static void copy(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) array1[i] = array2[i];
    }

    public static int[] copy(int[] array) {
        int[] copy = new int[array.length];
        copy(copy, array);
        return copy;
    }
}

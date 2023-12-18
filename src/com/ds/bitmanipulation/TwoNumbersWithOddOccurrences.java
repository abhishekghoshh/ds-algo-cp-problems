package com.ds.bitmanipulation;

import java.util.HashSet;
import java.util.Set;

import static com.util.ArrayUtil.print;

/*
 * Problem link :
 * https://www.codingninjas.com/studio/problems/two-numbers-with-odd-occurrences_8160466
 *
 * Solution link :
 *
 *
 */
public class TwoNumbersWithOddOccurrences {
    public static void main(String[] args) {
        type1();
        type2();
    }

    // check repeat and missing number problem
    private static void type2() {
        int[] arr = {2, 4, 1, 3, 2, 4};
        int xor = 0;
        for (int num : arr) xor = xor ^ num;
        // if the xor is 0001010100
        // then x ^ y => 0001010100
        // because all other numbers have the even count
        int rightestSetBit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int num : arr) {
            if ((num ^ rightestSetBit) == 0) x = x ^ num;
            else y = y ^ num;
        }
        int[] answer = null;
        if (x > y) answer = new int[]{x, y};
        else answer = new int[]{y, x};
        print(answer);
    }

    private static void type1() {
        int[] arr = {2, 4, 1, 3, 2, 4};
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        int[] answer = new int[2];
        int i = 0;
        for (int num : set) answer[i++] = num;
        if (answer[0] < answer[1]) {
            int temp = answer[1];
            answer[1] = answer[0];
            answer[0] = temp;
        }
        print(answer);
    }

}

package com.ds.bitmanipulation;

import static com.util.ArrayUtil.print;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/bit-manipulation_8142533
 *
 * Solution link :
 *
 *
 *
 * */
public class BitManipulation {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int num = 25, i = 3;
        int mask = 1 << (i - 1);
        int kthBit = (num & mask) > 0 ? 1 : 0;
        int setBit = num | mask;
        int clearBit = num & (~mask);
        int[] answer = {kthBit, setBit, clearBit};
        print(answer);
    }
}

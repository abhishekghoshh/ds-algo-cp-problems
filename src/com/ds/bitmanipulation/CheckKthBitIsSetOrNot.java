package com.ds.bitmanipulation;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/check-whether-k-th-bit-is-set-or-not_5026446
 *
 * Solution link :
 *
 *
 *
 * */
public class CheckKthBitIsSetOrNot {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
        int n = 5, k = 1;
        int sol = n >> (k - 1);
        int kthBit = (sol & 1) == 1 ? 1 : 0;
        System.out.println(kthBit);
    }

    private static void type1() {
        int n = 5, k = 1;
        int mask = 1 << (k - 1);
        int kthBit = (n & mask) > 0 ? 1 : 0;
        System.out.println(kthBit);
    }
}

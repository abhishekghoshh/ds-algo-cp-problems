package com.ds.bitmanipulation;
/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/swap-two-numbers_1380853
 *
 * Solution link :
 *
 *
 *
 * */
public class SwapTwoNumbers {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int x = 5;
        int y = 8;
        x = x ^ y;
        y = x ^ y; // this line is now same ase x ^ y ^ y which is x => now y has the value of x
        x = x ^ y; // this line is now same as x ^ y ^ x which is y => now x has the value of y
        System.out.println(x);
        System.out.println(y);
    }
}

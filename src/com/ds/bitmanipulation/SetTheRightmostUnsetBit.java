package com.ds.bitmanipulation;

/*
 *
 * problem links :
 * https://www.codingninjas.com/studio/problems/set-the-rightmost-unset-bit_8160456
 *
 * Solution link :
 *
 *
 *
 * */
public class SetTheRightmostUnsetBit {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        int copy = n;
        int mask = 1;
        while (copy > 0) {
            if ((copy & 1) == 0) break;
            copy = copy >> 1;
            mask = mask << 1;

        }
        int answer = n | mask;
        System.out.println(answer);
    }
}

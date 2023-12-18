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
public class SetTheRightMostUnsetBit {
    public static void main(String[] args) {
        type1();
    }

    private static void type1() {
        int n = 10;
        System.out.println(Integer.toBinaryString(n));
        int answer = setRightMostUnsetBit(n);
        System.out.println(answer);
        System.out.println(Integer.toBinaryString(answer));
    }

    public static int setRightMostUnsetBit(int n) {
        // Write your code here.
        int copy = n;
        int mask = 1;
        while (copy != 0 && (copy & 1) == 1) {
            mask = (mask << 1);
            copy = copy >> 1;
        }
        return copy == 0 ? n : (n | mask);
    }
}

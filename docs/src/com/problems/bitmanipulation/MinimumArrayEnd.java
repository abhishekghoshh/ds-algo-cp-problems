package com.problems.bitmanipulation;

/*
 * Problem link :
 * https://leetcode.com/problems/minimum-array-end/description/
 *
 * Solution link :
 * https://www.youtube.com/watch?v=4pP-0UpEok4
 * https://neetcode.io/solutions/minimum-array-end
 *
 * https://leetcode.com/problems/minimum-array-end/solutions/6007257/minimum-array-end/
 */
public class MinimumArrayEnd {


    // todo there is one common intuition for all the solution
    //  lets say the we have 10 numbers and the and operation x
    //  that means the x must be present in all the numbers
    //  now coming to the question and operation is x and we have generate the n numbers in increasing manner
    //  the first question is what will be first number, the minimum number will be x
    //  and number lesser than x will not have all bit surely
    //  any number greater than x will may have or may not have the bits
    //  lets say AND result is 1001 then we could generate the numbers 1001, 1011, 1101, 1111, 11001
    //  and the and of the numbers will be 1001
    public static void main(String[] args) {
        type1();
        type2();
        type3();
    }


    // todo please check the previous approach
    //  one possible optimization we could do is we can club all the loop in one loop
    //  so we could reduce the time complexity and remove the array
    //  we will iterate through x
    //  if the bit is 1 then we will directly add it to the answer, as it is required
    //  but if it is 0 then we will take the bit from n and add it to the answer
    //
    private static void type3() {
        int n = 3, x = 4;
        long ans = minEnd3(n, x);
        System.out.println(ans);
    }

    private static long minEnd3(int n, int x) {
        // decreasing by one as x is the starting number, and we need to generate n-1 numbers more
        n--;
        long ans = 0L;
        for (int i = 0; x != 0 || n != 0; i++) {
            int bit = (x & 1);
            x = x >> 1;
            // the bit from x is 1, so taking from that
            if (bit == 1) {
                ans += (1L << i);
            } else {
                // the bit from x is 0, so taking from n
                long bit1 = n & 1;
                ans += (bit1 << i);
                n = n >> 1;
            }
        }
        return ans;
    }

    // todo optimized approach
    //  lets say AND result is 1001 then we could generate the numbers 1001, 1011, 1101, 1111, 11001
    //  and the and of the numbers will be 1001
    //  lets take the and result is 1100 and we have to generate 4 numbers more
    //  so the numbers will be 1101, 1110, 1111, 11100
    //  see we are not touching anything which already have set bit initially
    //  see what is the last minimum number which is 11100, if we take out the set bits of the AND
    //  then the num will be 100 which is nothing 4
    //  if we take out set bits from all the generated numbers then it will be 01, 10, 11, 100
    //  so we are just adding bits(0,1) which has 0 bit initially
    //  so now the problem boils down to
    //  if we have to generate n numbers in total, so we have to generate n-1 numbers more, as x will be the starting
    //  we will transform the the n-1 into binary and place its bits to the vacant positions of the original number(x)
    //  in this we will not have to
    private static void type2() {
        int n = 3, x = 4;
        long ans = minEnd2(n, x);
        System.out.println(ans);
    }

    public static long minEnd2(int n, int x) {
        // decreasing by one as x is the starting number, and we need to generate n-1 numbers more
        n--;
        // if it is long then we will have 64 bits, so making a 64-bit array
        int N = 64;
        // converting the x into binary form (adding bits in the num array from last to first)
        int[] num = new int[N];
        for (int i = N - 1; i >= 0 && x != 0; i--) {
            num[i] = (x & 1);
            x = x >> 1;
        }
        // now we will place n to the 0 bit of the x (adding bits in the num array from last to first)
        for (int i = N - 1; i >= 0 && n != 0; i--) {
            // if it is already 1 then we can skip
            if (num[i] == 1) continue;
            num[i] = n & 1;
            n = n >> 1;
        }
        long ans = 0L;
        // now again converting the num array to the number
        for (int i = N - 1, j = 0; i >= 0; i--, j++) {
            int bit = num[i];
            ans += ((long) bit << j);
        }
        return ans;
    }

    // todo brute force approach
    //  as per the problem solve the problem in brute force is useless as the range is 10^8
    //  which is out of range of O(n) solution
    //  but anyway we will solve it
    //  lets break the problem
    //  we have to generate a increasing numbers and the common bits should be x
    //  if the starting number is num then the next number will be num+1
    //  but num+1 might not have all the bits required
    //  like if num is 1011 then num+1 will be 1100 but target AND is 1001
    //  so we could do a OR operation with target AND which will fill the missing bits
    //  if we do a OR operation it will certainly do not decrease the number
    //  it might increase the number or might not, but it won't decrease the number
    //  so the next number will be (num+1) | x
    private static void type1() {
        int n = 3, x = 4;
        long ans = minEnd1(n, x);
        System.out.println(ans);
    }

    private static long minEnd1(int n, int x) {
        long res = x;
        for (int i = 0; i < n - 1; i++) {
            res = (res + 1) | x;
        }
        return res;
    }


}

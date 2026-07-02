package com.problems.hashing;

/*
 * Problem link :
 * https://leetcode.com/problems/calculate-score-after-performing-instructions/description/
 *
 * Solution link :
 *
 *
 * */
public class CalculateScoreAfterPerformingInstructions {
    public static void main(String[] args) {
        type1();
        type2();
    }


    private static void type2() {
        String[] instructions = {"jump", "add", "add", "jump", "add", "jump"};
        int[] values = {2, 1, 3, 1, -2, -3};
        long ans = calculateScore2(instructions, values);
        System.out.println(ans);
    }

    public static long calculateScore2(String[] instructions, int[] values) {
        long sum = 0;
        int i = 0;
        int n = instructions.length;
        boolean[] visited = new boolean[n];
        while (0 <= i && i < n && !visited[i]) {
            visited[i] = true;
            if (instructions[i].charAt(0) == 'j') {
                i += values[i];
            } else {
                sum += values[i];
                i++;
            }
        }
        return sum;
    }

    // optimized approach
    private static void type1() {
        String[] instructions = {"jump", "add", "add", "jump", "add", "jump"};
        int[] values = {2, 1, 3, 1, -2, -3};
        long ans = calculateScore1(instructions, values);
        System.out.println(ans);
    }

    public static long calculateScore1(String[] instructions, int[] values) {
        long score = 0;
        int n = instructions.length;
        int i = 0;
        boolean[] visited = new boolean[n];
        while (0 <= i && i < n) {
            if (visited[i]) break;
            visited[i] = true;
            if ("add".equals(instructions[i])) {
                score += values[i++];
            } else {
                i += values[i];
            }
        }
        return score;
    }
}

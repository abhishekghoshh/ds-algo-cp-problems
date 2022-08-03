package problems.dynamicprogramming.matrixchainmultiplication;



public class MatrixChainMultiplicationMemoization {
    private static Integer count = 0;
    private static int[][] memo;

    public static void main(String[] args) {
        int matrices[] = { 40, 20, 30, 10, 30, 25 };
        int length = matrices.length;
        initialize(length);
        int minCost = minCost(matrices, 1, length - 1);
        System.out.println(minCost);
        System.out.println(count);
    }

    private static void initialize(int length) {
        memo = new int[length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= length; j++) {
                memo[i][j] = -1;
            }
        }
    }

    private static int minCost(int[] matrices, int i, int j) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i >= j) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempCost = minCost(matrices, i, k) + minCost(matrices, k + 1, j)
                    + matrices[i - 1] * matrices[k] * matrices[j];
            if (minCost > tempCost) {
                minCost = tempCost;
            }
        }
        count++;
        memo[i][j] = minCost;
        return minCost;
    }
}

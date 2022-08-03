package problems.dynamicprogramming.matrixchainmultiplication;

public class PalindromePartitioningRecursive {
    public static void main(String[] args) {
        String str = "xnitinjk";
        int length = str.length();
        int minCost = minCost(str, 0, length - 1);
        System.out.println(minCost);
    }

    private static int minCost(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(str, i, j)) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = 1 + minCost(str, i, k) + minCost(str, k + 1, j);
            if (minCost > cost) {
                minCost = cost;
            }
        }
        return minCost;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}

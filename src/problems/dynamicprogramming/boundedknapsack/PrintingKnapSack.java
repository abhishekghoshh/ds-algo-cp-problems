package problems.dynamicprogramming.boundedknapsack;
import java.util.*;
public class PrintingKnapSack {
    public static void main(String args[]){
        int[][] items = {{1, 2},{4, 3},{5, 6},{6, 7}};
        int capacity = 10;
        System.out.println(knapsackProblem(items,capacity));
    }
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int length = items.length;
            int[] val = new int[length];
            int[] wt = new int[length];
            for (int i = 0; i < length; i++) {
                val[i] = items[i][0];
                wt[i] = items[i][1];
            }
            int[][] memo = new int[length+1][capacity+1];
            for(int i=1;i<=length;i++){
                for(int j=1; j<=capacity;j++){
                    if(wt[i-1]<=j){
                        memo[i][j] = Math.max(val[i-1]+memo[i-1][j-wt[i-1]],memo[i-1][j]);
                    }else{
                        memo[i][j]=memo[i-1][j];
                    }
                }
            }
            int profit = memo[length][capacity];
            int maxProfit = memo[length][capacity];
            int w = capacity;
            List<Integer> indices = new ArrayList<>();
            for(int i=length;i>0 && w>0;i--){
                if(maxProfit!=memo[i-1][w]){
                    indices.add(i-1);
                    maxProfit = maxProfit - val[i-1];
                    w=w-wt[i-1];
                }
            }
            Collections.reverse(indices);
            return Arrays.asList(Arrays.asList(profit),indices);
      }
}

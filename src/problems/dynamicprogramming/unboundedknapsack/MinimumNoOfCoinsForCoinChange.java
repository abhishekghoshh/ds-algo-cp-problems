package problems.dynamicprogramming.unboundedknapsack;

public class MinimumNoOfCoinsForCoinChange {
    private static int[][] memo=null;
    public static void main(String[] args){
        int wt[] = {1,2,3,4,5,9,11};
        int n= wt.length;
        int w=12; 
        memo=initialize(n,w,wt);
        int minCount = maxNoOfWaysCoinChange(wt,n,w);
        System.out.println(minCount);
    }
    private static int maxNoOfWaysCoinChange(int[] wt, int n, int w) {
        for(int i=2;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    memo[i][j]= Math.min(1+memo[i][j-wt[i-1]],memo[i-1][j]);
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        return memo[n][w];
    }
    private static int[][] initialize(int n, int w, int[] wt) {
        int[][] memo = new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            memo[i][0]=0;
        }
        for(int j=1;j<=w;j++){
            memo[0][j]=Integer.MAX_VALUE-1;
        }
        memo[0][0]=Integer.MAX_VALUE-1;
        for(int i=1;i<=w;i++){
            if(i % wt[0]==0){
                memo[1][i]=i/wt[0];
            }else{
                memo[1][i]=Integer.MAX_VALUE-1;
            }
        }
        return memo;
    }
}

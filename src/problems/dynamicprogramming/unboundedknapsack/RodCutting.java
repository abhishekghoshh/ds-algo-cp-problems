package problems.dynamicprogramming.unboundedknapsack;

public class RodCutting {
    private static int[][] memo=null;
    public static void main(String args[]){
        int wt[] = {2,3,4,5,9,12};
        int val[]={3,5,7,8,15,20};
        int n= wt.length;
        int w=14;
        memo=initialize(n,w);
        int profit = rodCutting(wt,val,n,w);
        System.out.println(profit);
    }
    private static int rodCutting(int[] wt, int[] val, int n, int w) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    memo[i][j]=Math.max(val[i-1]+memo[i][j-wt[i-1]],memo[i-1][j]);
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        return memo[n][w];
    }
    private static int[][] initialize(int n, int w) {
        int[][] memo= new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            memo[i][0]=0;
        }
        for(int i=1;i<=w;i++){
            memo[0][i]=0;
        }
        memo[0][0]=0;
        return memo;
    }
}

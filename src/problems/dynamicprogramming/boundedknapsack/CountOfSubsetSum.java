package problems.dynamicprogramming.boundedknapsack;

public class CountOfSubsetSum {
    private static int[][] memo;
    public static void main(String args[]){
        int wt[] = {1,3,4,5,9,12};
        int n= wt.length;
        int w=25;
        memo=initialize(n, w);
        System.out.println(countOfSubsetSum(wt, w, n));
       }
    private static int[][] initialize(int n, int w) {
        int[][] memo= new int[n+1][w+1];
        for(int i=0;i<=w;i++){
            memo[0][i]=0;
        }
        for(int i=0;i<=n;i++){
            memo[i][0]=1;
        }
        return memo;
    }
    private static int countOfSubsetSum(int[] wt, int w, int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    memo[i][j]=memo[i-1][j-wt[i-1]]+memo[i-1][j];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        return memo[n][w];
    }
}

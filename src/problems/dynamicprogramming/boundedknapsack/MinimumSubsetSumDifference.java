package problems.dynamicprogramming.boundedknapsack;

public class MinimumSubsetSumDifference {
    private static boolean[][] memo;
    public static void main(String args[]){
        int wt[] = {2, 2,2, 2,2};
        int n= wt.length;
        int sum=arraySum(wt);
        memo=initialize(n, sum);
        System.out.println(subsetSum(wt, sum, n));
    }
    private static int subsetSum(int[] wt, int sum, int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(wt[i-1]<=j){
                    memo[i][j]=memo[i-1][j-wt[i-1]]||memo[i-1][j];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        int diff= sum;
        int half=sum/2;
        for(int j=1;j<=half;j++){
            if(memo[n][j]){
                diff = diff > sum-2*j ? sum-2*j : diff;
            }
        }
        return diff;
    }
    private static int arraySum(int[] wt){
        int n=wt.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+wt[i];
        }
        return sum;
    }
    private static boolean[][] initialize(int n, int w) {
        boolean[][] memo= new boolean[n+1][w+1];
        for(int i=0;i<=w;i++){
            memo[0][i]=false;
        }
        for(int i=0;i<=n;i++){
            memo[i][0]=true;
        }
        return memo;
    }
}

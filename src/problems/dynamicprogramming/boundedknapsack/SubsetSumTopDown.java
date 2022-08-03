package problems.dynamicprogramming.boundedknapsack;

public class SubsetSumTopDown {
    private static boolean[][] memo;
    public static void main(String args[]){
        int wt[] = {1,3,4,5,9,12};
        int n= wt.length;
        int w=25;
        memo=initialize(n, w);
        System.out.println(subsetSum(wt, w, n));
       }
       private static boolean subsetSum(int[] wt,int w,int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    memo[i][j]=memo[i-1][j-wt[i-1]]||memo[i-1][j];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        return memo[n][w];
       }
       private static boolean[][] initialize(int n, int w) {
        boolean[][] memo= new boolean[n+1][w+1];
        for(int j=0;j<=w;j++){
            memo[0][j]=false;
        }
        for(int i=0;i<=n;i++){
            memo[i][0]=true;
        }
        return memo;
    } 
}

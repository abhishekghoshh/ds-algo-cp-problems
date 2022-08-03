package problems.dynamicprogramming.boundedknapsack;

public class BinaryKnapSackTopDown {
    private static int[][] memo;
    public static void main(String args[]){
        int wt[] = {1,3,4,5,9,12};
        int val[]={1,4,5,7,12,16};
        int n= val.length;
        int w=13;
        memo=initialize(n, w);
        System.out.println(knapsack(val, wt, w, n));
       } 
       public static int knapsack(int[] val,int[] wt,int w,int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    memo[i][j]=Math.max(val[i-1]+memo[i-1][j-wt[i-1]], memo[i-1][j]);
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        return memo[n][w];
       }  
       private static int[][] initialize(int n, int w) {
        int[][] memo= new int[n+1][w+1];
        for(int i=0;i<=n;i++){
            memo[i][0]=0;
        }
        for(int j=0;j<=w;j++){
            memo[0][j]=0;
        }
        return memo;
    } 
}

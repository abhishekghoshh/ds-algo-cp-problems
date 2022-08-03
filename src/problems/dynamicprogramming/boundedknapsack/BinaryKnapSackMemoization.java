package problems.dynamicprogramming.boundedknapsack;

public class BinaryKnapSackMemoization{
    private static int[][] memo;
    public static void main(String args[]){
     int wt[] = {1,3,4,5,9,12};
     int val[]={1,4,5,7,12,10};
     int n= val.length;
     int w=20;
     memo=initialize(n, w);
     Long start = System.nanoTime();
     System.out.println(knapsack(val, wt, w, n));
     Long end = System.nanoTime();
     System.out.println(end-start);
    }
    
    public static int knapsack(int[] val,int[] wt,int w,int n){
        if(w==0 || n==0){
            return 0;
        }
        if(memo[n][w]!=-1){
            return memo[n][w];
        }
        if(wt[n-1]<=w){
            memo[n][w]=  Math.max(val[n-1] + knapsack(val, wt, w-wt[n-1], n-1), knapsack(val, wt, w, n-1));
        }else{
            memo[n][w]= knapsack(val, wt, w, n-1);
        }
        return memo[n][w];
    }
    private static int[][] initialize(int n, int w) {
        int[][] memo= new int[n+1][w+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                memo[i][j]=-1;
            }
        }
        return memo;
    } 
 }
 
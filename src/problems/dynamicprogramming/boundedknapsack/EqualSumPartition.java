package problems.dynamicprogramming.boundedknapsack;

public class EqualSumPartition {
    private static boolean[][] memo;
    public static void main(String args[]){
        int wt[] = {1,3,4,5,9,12};
        int n= wt.length;
        int sum = arraySum(wt);
        if(sum%2==0){
            int target = sum/2;
            memo=initialize(n, target);
            System.out.println(equalSumParition(wt, target, n));
        }else{
            System.out.println("Not possible");
        }
    }
    private static boolean equalSumParition(int[] wt,int target,int n){
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                if(wt[i-1]<=j){
                    memo[i][j]=memo[i-1][j-wt[i-1]]|| memo[i-1][j];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        return memo[n][target];
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
        for(int j=0;j<=w;j++){
            memo[0][j]=false;
        }
        for(int i=0;i<=n;i++){
            memo[i][0]=true;
        }
        return memo;
    } 
}

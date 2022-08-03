package problems.dynamicprogramming.boundedknapsack;

public class TargetSum {
    private static int[][] memo;
    public static void main(String args[]){
        int diff = 2;
        int[] wt ={1,1,1,3};
        int n=wt.length;
        int sum = arraySum(wt,n);
        if((sum+diff)%2==0){
            int target =(sum+diff)/2;
            memo=initialize(n,target);
            int targetSum = targetSum(wt,target,n);
            System.out.println(targetSum);
        }else{
            System.out.println("No possible");
        }
    }
    private static int targetSum(int[] wt, int target, int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(wt[i-1]<=j){
                    memo[i][j]=memo[i-1][j-wt[i-1]]+memo[i-1][j];
                }else{
                    memo[i][j]=memo[i-1][j];
                }
            }
        }
        return memo[n][target];
    }
    private static int[][] initialize(int n, int target) {
        int[][] memo = new int[n+1][target+1]; 
        for(int i=0;i<=target;i++){
            memo[0][i]=0;
        }
        for(int i=0;i<=n;i++){
            memo[i][0]=1;
        }
        return memo;
    }
    private static int arraySum(int[] wt, int n) {
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+wt[i];
        }
        return sum;
    }
}

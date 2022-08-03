package problems.dynamicprogramming.boundedknapsack;

public class CountOfSubsetSumDifference {
    private static int[][] memo;
   public static void main(String[] args){
    int diff = 2;
    int[] arr = {1,1,1,2,3};
    int n=arr.length;
    int sum =arraySum(arr,n);
    if((sum+diff)%2==0){
        int target= (sum+diff)/2;
        memo = initilize(n,target);
        int count=countOfSubsetSum(arr,n,target);
        System.out.print(count);
    }else{
        System.out.println("not possible");
    }
    
   }
private static int countOfSubsetSum(int[] arr, int n, int target) {
    for(int i=1;i<=n;i++){
        for(int j=1;j<=target;j++){
            if (arr[i-1]<=j){
                memo[i][j]=memo[i-1][j-arr[i-1]]+memo[i-1][j];
            }else{
                memo[i][j]=memo[i-1][j];
            }
        }
    }
    return memo[n][target];
}
private static int[][] initilize(int n, int target) {
    int[][] memo = new int[n+1][target+1];
    for (int i=1;i<target;i++){
        memo[0][i]=0;
    }
    for(int i=0;i<n;i++){
        memo[i][0]=1;
    }
    return memo;
}
private static int arraySum(int[] arr, int n) {
    int sum =0;
    for(int i=0;i<n;i++){
        sum=sum+arr[i];
    }
    return sum;
}
}

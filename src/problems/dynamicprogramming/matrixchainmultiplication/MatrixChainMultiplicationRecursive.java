package problems.dynamicprogramming.matrixchainmultiplication;


public class MatrixChainMultiplicationRecursive {
    private static Integer count = 0;
    public static void main(String[] args){
        int matrices[] = {40, 20, 30, 10, 30,25};
        int length=matrices.length;
        int minCost = minCost(matrices,1,length-1);
        System.out.println(minCost);
        System.out.println(count);
    }

    private static int minCost(int[] matrices, int i, int j) {
        
        if(i>=j){
            return 0;
        }
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int tempCost = minCost(matrices,i,k)+minCost(matrices,k+1,j)+matrices[i-1]*matrices[k]*matrices[j];
            if(minCost>tempCost){
                minCost=tempCost;
            }
        }
        count++;
        return minCost;
    }
}

package problems.dynamicprogramming.longestcommonsubsequence;

public class LongestRepeatingSubsequence {
    public static void main(String[] args){
        String firstString = "abbccabd";
        String secondString = firstString;
        int length1 = firstString.length();
        int length2 = secondString.length();
        int[][] memo = initialize(length1, length2);
        int count = longestCommonSubsequence(firstString,secondString,length1,length2,memo);
        System.out.println(count);
    }

    private static int[][] initialize(int length1, int length2) {
        int[][] memo = new int[length1+1][length2+1];
        for(int i=0;i<=length1;i++){
            memo[i][length2]=0;
        }
        for(int j=0;j<=length2;j++){
            memo[length1][j]=0;
        }
        return memo;
    }

    private static int longestCommonSubsequence(String firstString, String secondString, int length1, int length2, int[][] memo) {
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(firstString.charAt(i-1)==secondString.charAt(j-1) && i!=j){
                    memo[i][j]=1+memo[i-1][j-1];
                }else{
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return memo[length1][length2];
    }
}

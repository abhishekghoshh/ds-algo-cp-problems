package problems.dynamicprogramming.longestcommonsubsequence;

public class LongestCommonSubsequenceMemoization {
    public static void main(String[] args){
        String firstString = "xabcmagg";
        String secondString = "abcdamg";
        int length1 = firstString.length();
        int length2 = secondString.length();
        int[][] memo = initialize(length1, length2);
        int count = longestCommonSubsequence(firstString,secondString,length1,length2,memo);
        System.out.println(count);
    }

    private static int[][] initialize(int length1, int length2) {
        int[][] memo = new int[length1+1][length2+1];
        for(int i=0;i<=length1;i++){
            for(int j=0;j<=length2;j++){
                memo[i][j]=-1;
            }
        }
        return memo;
    }

    private static int longestCommonSubsequence(String firstString, String secondString, int length1, int length2, int[][] memo) {
        if(memo[length1][length2]!=-1){
            return memo[length1][length2];
        }
        if(length1==0 || length2==0){
            return 0;
        }
        if(firstString.charAt(length1-1) == secondString.charAt(length2-1)){
            memo[length1][length2]= 1+longestCommonSubsequence(firstString,secondString,length1-1,length2-1,memo);
        }else{
            memo[length1][length2]= Math.max(longestCommonSubsequence(firstString,secondString,length1,length2-1,memo), 
                            longestCommonSubsequence(firstString,secondString,length1-1,length2,memo));
        }
        return memo[length1][length2];
    }
}

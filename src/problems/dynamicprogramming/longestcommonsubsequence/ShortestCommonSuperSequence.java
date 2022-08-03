package problems.dynamicprogramming.longestcommonsubsequence;

public class ShortestCommonSuperSequence {
    public static void main(String[] args){
        String str1 = "abcdefg";
        String str2 = "xbcyefmnop";
        int length1=str1.length();
        int length2=str2.length();
        int[][] memo = new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    memo[i][j]=1+memo[i-1][j-1];
                }else{
                    memo[i][j]=Math.max(memo[i-1][j],memo[i][j-1]);
                }
            }
        }
        int maxSubSequenceLength = memo[length1][length2];
        int totalLength = length1+length2;
        int shortestCommonSuperSequenceLength= totalLength-maxSubSequenceLength;
        System.out.println(shortestCommonSuperSequenceLength);
    }    
}

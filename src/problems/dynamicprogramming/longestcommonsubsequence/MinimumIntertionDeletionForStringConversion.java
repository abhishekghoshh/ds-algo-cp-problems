package problems.dynamicprogramming.longestcommonsubsequence;

public class MinimumIntertionDeletionForStringConversion {
    public static void main(String[] args){
        String str1 = "abcdef";
        String str2 = "xbcdmn";
        int length1=str1.length();
        int length2 = str2.length();
        int[][] memo= new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    memo[i][j]=1+memo[i-1][j-1];
                }else{
                    memo[i][j]=Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        int subStringLength = memo[length1][length2];
        int deletionCount = length1-subStringLength;
        int insertionCount= length2-subStringLength;
        int totalCount = deletionCount+insertionCount;
        System.out.println(totalCount);
    }
}

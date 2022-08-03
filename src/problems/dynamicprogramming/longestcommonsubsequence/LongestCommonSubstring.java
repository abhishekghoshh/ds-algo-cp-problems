package problems.dynamicprogramming.longestcommonsubsequence;

public class LongestCommonSubstring {
   public static void main(String[] args){
    String str1 = "abcdefmno";
    String str2 = "mabcxmn";
    int length1= str1.length();
    int length2= str2.length();
    int[][] memo = new int[length1+1][length2+1];
    int maxCount = 0;
    String maxString = null;
    for(int i=1;i<=length1;i++){
        for(int j=1;j<=length2;j++){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                memo[i][j]=1+memo[i-1][j-1];
                if(maxCount<memo[i][j]){
                    maxCount=memo[i][j];
                    maxString = str1.substring(i-maxCount, i);
                }
            }else{
                memo[i][j]=0;
            }
        }
    }
    System.out.println(maxCount);
    System.out.println(maxString);
   } 
}

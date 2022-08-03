package problems.dynamicprogramming.longestcommonsubsequence;

public class PrintLongestCommonSubsequence {
    public static void  main(String[] args){
        String str1 ="abcfe";
        String str2="abcdef";
        int length1=str1.length();
        int length2 = str2.length();
        int[][] memo=new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    memo[i][j]=1+memo[i-1][j-1];
                }else{
                    memo[i][j]=Math.max(memo[i-1][j-1], memo[i-1][j-1]);
                }
            }
        }
        String longestSubString="";
        while(length1!=0 || length2!=0){
           if(str1.charAt(length1-1)==str2.charAt(length2-1)){
            longestSubString=str1.charAt(length1-1)+longestSubString;
            length1--;
            length2--;
           }else{
               if(memo[length1-1][length2]>memo[length1][length2-1]){
                length1--;
               }else{
                length2--;
               }
           }
        }
        System.out.println(longestSubString);
    }
}

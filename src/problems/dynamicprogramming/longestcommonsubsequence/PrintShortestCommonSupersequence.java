package problems.dynamicprogramming.longestcommonsubsequence;

public class PrintShortestCommonSupersequence {
    public static void  main(String[] args){
        String str1 ="abmcfe";
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
        String shortestSupersequence="";
        while(length1!=0 || length2!=0){
           if(str1.charAt(length1-1)==str2.charAt(length2-1)){
            shortestSupersequence=str1.charAt(length1-1)+shortestSupersequence;
            length1--;
            length2--;
           }else{
               if(memo[length1-1][length2]>memo[length1][length2-1]){
                shortestSupersequence=str1.charAt(length1-1)+shortestSupersequence;
                length1--;
               }else{
                shortestSupersequence=str2.charAt(length2-1)+shortestSupersequence;
                length2--;
               }
           }
        }
        while(length1!=0){
            shortestSupersequence=str1.charAt(length1-1)+shortestSupersequence;
            length1--;
        }
        while(length2!=0){
            shortestSupersequence=str2.charAt(length2-1)+shortestSupersequence;
            length1--;
        }
        System.out.println(shortestSupersequence);
    }
}

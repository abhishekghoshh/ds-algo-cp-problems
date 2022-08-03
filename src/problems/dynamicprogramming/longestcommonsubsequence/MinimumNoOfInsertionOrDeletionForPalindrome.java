package problems.dynamicprogramming.longestcommonsubsequence;

public class MinimumNoOfInsertionOrDeletionForPalindrome {
    
    public static void main(String [] args){
        String str= "abcbcxcbe";
        String reverese = new StringBuilder().append(str).reverse().toString();
        int length1= str.length();
        int length2=reverese.length();
        int[][] memo= new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(str.charAt(i-1)==reverese.charAt(j-1)){
                    memo[i][j] =1+memo[i-1][j-1];
                }else{
                    memo[i][j]= Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        int maxCount = memo[length1][length1];
        System.out.println(length1-maxCount);
    }
}

package problems.dynamicprogramming.longestcommonsubsequence;

public class LongestPalindromicSubsequence {
    public static void main(String[] args){
        String string = "ynabcdbxmn";
        String reverse = new StringBuilder().append(string).reverse().toString();
        int length1 = string.length();
        int length2=reverse.length();
        int[][] memo = new int[length1+1][length2+1];
        for(int i=1;i<=length1;i++){
            for(int j=1;j<=length2;j++){
                if(string.charAt(i-1)==reverse.charAt(j-1)){
                    memo[i][j] = 1 + memo[i-1][j-1];
                }else{
                    memo[i][j]= Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        int count = memo[length1][length2];
        System.out.println(count);
        String palindromicString = "";
        while(length1!=0 && length2!=0){
            if(string.charAt(length1-1)==reverse.charAt(length2-1)){
                palindromicString = string.charAt(length1-1) + palindromicString;
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
        System.out.println(palindromicString);
    }
}

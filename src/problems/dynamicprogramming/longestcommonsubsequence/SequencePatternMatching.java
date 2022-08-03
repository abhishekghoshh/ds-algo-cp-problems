package problems.dynamicprogramming.longestcommonsubsequence;

public class SequencePatternMatching {
    public static void main(String[] args){
        String str="abcdefgh";
        String substring ="bcfgh";
        boolean isPossible= false;
        isPossible=sequencePatternMatchingDP(str,substring,str.length(),substring.length());
        System.out.println(isPossible);
        isPossible=sequencePatternMatching(str,substring,str.length(),substring.length());
        System.out.println(isPossible);
    }

    private static boolean sequencePatternMatching(String str, String substring, int length, int length2) {
        int index=0;
        for(int i=0;i<length;i++){
            if(str.charAt(i)==substring.charAt(index)){
                index++;
            }
        }
        return index==length2;
    }

    private static boolean sequencePatternMatchingDP(String str, String substring, int length, int length2) {
        int[][] memo= new int[length+1][length2+1];
        for(int i=1;i<=length;i++){
            for(int j=1;j<=length2;j++){
                if(str.charAt(i-1)==substring.charAt(j-1)){
                    memo[i][j]=1+memo[i-1][j-1];
                }else{
                    memo[i][j]=Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return memo[length][length2]==length2; 
    }
}

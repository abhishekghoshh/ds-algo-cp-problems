package problems.dynamicprogramming.longestcommonsubsequence;

public class LongestCommonSubsequenceRecursive {
    public static void main(String[] args){
        String firstString = "xabcma";
        String secondString = "abcda";
        int length1 = firstString.length();
        int length2 = secondString.length();
        int count = longestCommonSubsequence(firstString,secondString,length1,length2);
        System.out.println(count);
    }

    private static int longestCommonSubsequence(String firstString, String secondString, int length1, int length2) {
        if(length1==0 || length2==0){
            return 0;
        }
        if(firstString.charAt(length1-1) == secondString.charAt(length2-1)){
            return 1+longestCommonSubsequence(firstString,secondString,length1-1,length2-1);
        }else{
            return Math.max(longestCommonSubsequence(firstString,secondString,length1,length2-1), 
                                longestCommonSubsequence(firstString,secondString,length1-1,length2));
        }
    }
}

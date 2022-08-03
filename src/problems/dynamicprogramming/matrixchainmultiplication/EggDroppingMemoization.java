package problems.dynamicprogramming.matrixchainmultiplication;

import java.util.HashMap;
import java.util.Map;

public class EggDroppingMemoization {
    public static void main(String args[]){
        int floors =10;
        int eggs =2;
        Map<String,Integer> memo = new HashMap<>();
        int minAttempts = solve(floors,eggs,memo);
        System.out.println(minAttempts);
    }

    private static int solve(int floors, int eggs, Map<String, Integer> memo) {
        String key = floors+ "_"+eggs;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(floors<=1){
            return floors;
        }
        if(eggs==1){
            return floors;
        }
        int minAttempts = Integer.MAX_VALUE;
        for(int i=1;i<=floors;i++){
            int tempWorstAttemps = Math.max(solve(i-1, eggs-1,memo), solve(floors-i, eggs,memo));
            if(tempWorstAttemps<minAttempts){
                minAttempts=tempWorstAttemps;
            }
        }
        memo.put(key,minAttempts+1);
        return minAttempts+1;
    }
}

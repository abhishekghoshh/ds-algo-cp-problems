package problems.dynamicprogramming.matrixchainmultiplication;

public class EggDroppingRecursive {
    public static void main(String args[]){
        int floors =10;
        int eggs =2;
        int minAttempts = solve(floors,eggs);
        System.out.println(minAttempts);
    }

    private static int solve(int floors, int eggs) {
        if(floors<=1){
            return floors;
        }
        if(eggs==1){
            return floors;
        }
        int minAttempts = Integer.MAX_VALUE;
        for(int i=1;i<=floors;i++){
            int tempWorstAttemps = Math.max(solve(i-1, eggs-1), solve(floors-i, eggs));
            if(tempWorstAttemps<minAttempts){
                minAttempts=tempWorstAttemps;
            }
        }
        return minAttempts+1;
    }
}

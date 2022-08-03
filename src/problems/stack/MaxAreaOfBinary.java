package problems.stack;

public class MaxAreaOfBinary {
    public static void main(String args[]){
        Integer[][] arr = { {0 ,1 ,1 ,0},
                            {1 ,1 ,1 ,1},
                            {1, 1, 1, 1},
                            {1 ,1 ,0 ,0}};
        Integer[] histogram = {0,0,0,0};
        int maxArea =0;
        for(int i=0; i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0){
                    histogram[j]=0;
                }else{
                    histogram[j]=histogram[j]+arr[i][j];
                }
            }
            maxArea = Math.max(maxArea, MaximumAreaOfHistogram.maxAreaOfHistogram(histogram, histogram.length));
        }
        System.out.println(maxArea);
    }
}

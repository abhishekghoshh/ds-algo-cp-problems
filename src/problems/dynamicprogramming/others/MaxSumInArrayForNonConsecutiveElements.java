package DynamicProgrammingQuestions.others;

import java.util.ArrayList;
import java.util.List;

public class MaxSumInArrayForNonConsecutiveElements {
    public static void main(String[] args) {
        int[] arr = {5,5,10,100,10,5};
        System.out.println(FindMaxSum(arr,arr.length));
        
    }
    public static int FindMaxSum(int arr[], int n){
        if(n==1) return arr[0];
        if(n==2) return arr[0]>arr[1]?arr[0]:arr[1];
        List<Integer> list = new ArrayList<>();
        list.add(0);list.add(arr[0]);list.add(arr[1]);
        for(int i=2;i<n;i++){
            int highestLoot = Math.max(list.get(list.size()-2),list.get(list.size()-3));
            list.add(arr[i]+highestLoot);
        }
        return Math.max(list.get(list.size()-1),Math.max(list.get(list.size()-2),list.get(list.size()-3)));
    }
}

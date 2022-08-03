package HeapProblems;

import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
       int arr[] = {6, 5, 3, 2, 8, 10, 9};
       int k = 3;
       sortKSortedArray(arr, k);
       print(arr);
    }

    private static void sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
           int index=0;
           for(int item:arr){
            System.out.println(item+" "+queue);
            if(queue.size()<=k){
                queue.offer(item);
            }else{
                arr[index++]=queue.poll();
                queue.offer(item);
            }
           }
           while(index<arr.length){
            arr[index++]=queue.poll();
           }
    }

    private static void print(int[] arr) {
        for(int item:arr){
            System.out.print(item+" ");
           }
    }
    
}

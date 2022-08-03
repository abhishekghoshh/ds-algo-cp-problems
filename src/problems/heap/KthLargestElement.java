package HeapProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] array = {1,4,6,2,8,5,3,9,0,7};
        int k =3;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.naturalOrder());
        for(int item:array){
            if(pQueue.size() < k){
                pQueue.offer(item);
            }else{
                if(pQueue.peek() < item ){
                    pQueue.poll();
                    pQueue.offer(item);
                }
            }
        }
        System.out.println(pQueue.peek());
    }
}

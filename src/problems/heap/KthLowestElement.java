package HeapProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLowestElement {
    public static void main(String[] args) {
        int[] array = {1,4,6,2,8,5,3,9,0};
        int k =6;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int item:array){
            if(pQueue.size() < k){
                pQueue.offer(item);
            }else{
                if(pQueue.peek()>item){
                    pQueue.poll();
                    pQueue.offer(item);
                }
            }
        }
        System.out.println(pQueue.peek());
    }
}

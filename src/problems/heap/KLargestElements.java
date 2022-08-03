package HeapProblems;

import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] array = {1,4,6,2,8,5,3,9,0,7};
        int k =3;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int item:array){
            if(queue.size()<k){
                queue.offer(item);
            }else{
                if(queue.peek()<item){
                    queue.poll();
                    queue.offer(item);
                }
            }
        }
        System.out.println(queue);
    }
}

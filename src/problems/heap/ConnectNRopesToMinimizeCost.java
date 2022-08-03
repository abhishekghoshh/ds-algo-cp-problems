package HeapProblems;

import java.util.PriorityQueue;

public class ConnectNRopesToMinimizeCost {
    public static void main(String[] args) {
        int ropes[] = { 4, 3, 2, 6 };
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int item:ropes){
            queue.offer(item);
        }
        while(queue.size()!=1){
            int firstTop = queue.poll();
            int secondTop = queue.poll();
            queue.offer(firstTop+secondTop);
        }
        System.out.println(queue.poll());
    }
}

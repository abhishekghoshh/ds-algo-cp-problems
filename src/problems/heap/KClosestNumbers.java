package HeapProblems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestNumbers {
    public static void main(String[] args) {
        int k = 4, number = 35;
        int arr[] = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56};

        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair::getFirst).reversed());//max heap
        for(int item:arr){
            int distance = Math.abs(item-number);
            if(distance==0) continue;
            if(queue.size()<k){
                queue.offer(new Pair(distance,item));
            }else{
                if(queue.peek().getFirst()> distance){
                    queue.poll();
                    queue.offer(new Pair(distance,item));
                }
            }
        }
        System.out.println(queue.stream().map(Pair::getSecond).collect(Collectors.toList()));
    }
}

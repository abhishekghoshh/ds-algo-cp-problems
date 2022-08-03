package HeapProblems;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int points[][] = { { 3, 3 }, { 5, -1 }, { -2, 4 }, { -3, 3 }, { 1, 3 } };
        int k = 3;
        PriorityQueue<GenericPair<Integer,GenericPair<Integer,Integer>>> queue = new PriorityQueue<>((pair1,pair2)->Integer.compare(pair2.getFirst(), pair1.getFirst()));//max heap
        for(int[] point:points){
            int distanceSquared = point[0]*point[0]+point[1]*point[1];
            if(queue.size()<k){
                queue.offer(new GenericPair<>(distanceSquared, new GenericPair<>(point[0], point[1])));
            }else{
                if(distanceSquared<queue.peek().getFirst()){
                    queue.poll();
                    queue.offer(new GenericPair<>(distanceSquared, new GenericPair<>(point[0], point[1])));
                }
            }
        }
        System.out.println(queue);
    }
}

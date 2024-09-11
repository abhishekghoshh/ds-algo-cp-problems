import java.util.PriorityQueue;

public class HeapExample {
    public static void main(String args[]){
        int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int item : ia) {
            maxHeap.add(item);
        }
        System.out.println(maxHeap);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(10,(a,b)->b-a);
        for (int item : ia) {
            minHeap.add(item);
        }
        System.out.println(minHeap);
    }
    
}

package HeapProblems;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeap {


    public static void main(String[] args) {
        usingPriorityQueue();
    }

    private static void usingPriorityQueue() {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Comparator.naturalOrder());
        pQueue.add(10);
        pQueue.add(5);
        pQueue.add(7);
        pQueue.add(30);
        System.out.println("Head value using peek function: " + pQueue.peek());
        Iterator<Integer> itr = pQueue.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("poll value using poll function: " + pQueue.poll());
        pQueue.offer(15);
        System.out.println("Head value using peek function: " + pQueue.peek());
        System.out.println("remove value using remove function: " + pQueue.remove());
    }
}

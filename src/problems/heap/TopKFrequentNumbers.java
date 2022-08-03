package HeapProblems;

import java.util.*;

public class TopKFrequentNumbers {
    public static void main(String[] args) {
        int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;
        Map<Integer, Integer> frequencyMap = frequencyMap(arr);
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair::getSecond));//Min heap
        for(Map.Entry<Integer,Integer> entry:frequencyMap.entrySet()){
            //System.out.println(entry.getKey() +" : "+ entry.getValue()+" "+queue);
            if(queue.size()<k){
                queue.offer(new Pair(entry.getKey(), entry.getValue())); 
            }else{
                if(entry.getValue() > queue.peek().getSecond()){
                    queue.poll();
                    queue.offer(new Pair(entry.getKey(), entry.getValue()));
                }
            }
        }
        List<Pair> list = buildPairList(queue);
        System.out.println(list);

    }

    private static List<Pair> buildPairList(PriorityQueue<Pair> queue) {
        LinkedList<Pair> list = new LinkedList<>();
        while(queue.size()>0){
            list.addFirst(queue.poll());
        }
        return list;
    }

    private static Map<Integer, Integer> frequencyMap(int[] arr) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int item:arr){
            if(!frequencyMap.containsKey(item)){
                frequencyMap.put(item, 1);
            }else{
                frequencyMap.put(item, frequencyMap.get(item)+1);
            }
        }
        return frequencyMap;
    }
}

package HeapProblems;
import java.util.*;
public class FrequencySort {
    public static void main(String[] args) {
        int arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;
        Map<Integer, Integer> frequencyMap = frequencyMap(arr);
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair::getSecond));
        for(Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()){
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        List<Integer> list = new ArrayList<>();
        while(queue.size()!=0){
            Pair pair = queue.poll();
            for(int i=0;i<pair.getSecond();i++){
                list.add(pair.getFirst());
            }
        }
        System.out.println(list);
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

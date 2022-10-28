package problems.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import util.Pair;

/*
 * Problem link :
 * https://leetcode.com/problems/top-k-frequent-elements
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=7VoJn544QrM&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=6
 * 
 * */
public class TopKFrequentNumbers {
	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	@SuppressWarnings("unchecked")
	private static void type3() {
		int nums[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int k = 4;
		int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (min > i) min = i;
            if(i > max) max = i;
        }
        int[] freq = new int[max - min + 1];
        for (int i : nums) 
            freq[i - min]++;
        List<Integer>[] buckets = new List[nums.length + 1];
        int max_freq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (buckets[freq[i]] == null) 
                    buckets[freq[i]] = new ArrayList<>();
                buckets[freq[i]].add(i + min);
                
                max_freq = Math.max(freq[i], max_freq);
            }
        }
        int[] res = new int[k];
        for (int i = max_freq, idx = 0; i > 0 && idx < k; i--)
            if (buckets[i] != null)
                for (int num : buckets[i]) {
                    if (idx == k) break;
                    res[idx++] = num;
                }
		print(res);

	}

	private static void type2() {
		int nums[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int k = 4;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			if (min > i)
				min = i;
			if (i > max)
				max = i;
		}
		int[] freq = new int[max - min + 1];
		for (int i : nums)
			freq[i - min]++;
		PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
				(pair1, pair2) -> Integer.compare(pair1.second, pair2.second));
		for (int i = 0; i < freq.length; i++) {
			if (minHeap.size() < k) {
				minHeap.offer(new Pair<>(i, freq[i]));
			} else {
				if (freq[i] > minHeap.peek().second) {
					minHeap.poll();
					minHeap.offer(new Pair<>(i, freq[i]));
				}
			}
		}
		int[] answer = new int[k];
		int i = 0;
		while (i < k) {
			answer[i++] = minHeap.poll().first + min;
		}
		print(answer);
	}

	private static void type1() {
		int nums[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		int k = 4;
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int item : nums) {
			if (!frequencyMap.containsKey(item)) {
				frequencyMap.put(item, 1);
			} else {
				frequencyMap.put(item, frequencyMap.get(item) + 1);
			}
		}
		PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(
				(pair1, pair2) -> Integer.compare(pair1.second, pair2.second));
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			// System.out.println(entry.getKey() +" : "+ entry.getValue()+" "+queue);
			if (minHeap.size() < k) {
				minHeap.offer(new Pair<>(entry.getKey(), entry.getValue()));
			} else {
				if (entry.getValue() > minHeap.peek().second) {
					minHeap.poll();
					minHeap.offer(new Pair<>(entry.getKey(), entry.getValue()));
				}
			}
		}
		int[] answer = new int[k];
		int i = 0;
		while (i < k) {
			answer[i++] = minHeap.poll().first;
		}
		print(answer);
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}

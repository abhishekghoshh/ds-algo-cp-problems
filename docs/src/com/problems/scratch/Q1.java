package com.problems.scratch;

import java.util.*;

// https://leetcode.com/contest/weekly-contest-444/problems/minimum-pair-removal-to-sort-array-i/
// https://leetcode.com/problems/minimum-pair-removal-to-sort-array-i/


// Segment tree
// https://leetcode.com/contest/weekly-contest-444/problems/implement-router/
// https://leetcode.com/problems/implement-router/

public class Q1 {
    public static void main(String[] args) {
//        int[] nums = {2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1};
//        int result = minimumPairRemoval(nums);
//        System.out.println("Result: " + result);


        int p = 2;
        char ch = (char) ('a' + p);
        System.out.println(ch);

//        Router router = new Router(3); // Initialize Router with memoryLimit of 3.
//        router.addPacket(4, 5, 1); // Packet is added. Return True.
//        System.out.println(router.getCount(5, 1, 1)); // Count of packets with destination 5 between timestamps 1 and 2. Return 1.
    }

    public static int minimumPairRemoval(int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1[1] != p2[1])
                return Integer.compare(p1[1], p2[1]);
            return Integer.compare(p1[0], p2[0]);
        });
        int n = nums.length;
        int cnt = 0;
        while (!nonDecreasing(nums, n)) {
            System.out.println("n is " + n);
            cnt++;
            for (int i = 0; i < n - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                pq.offer(new int[]{i, sum});
            }
            int[] pair = pq.poll();
            nums[pair[0]] = pair[1];
            // shifting nums
            for (int i = pair[0] + 1; i < n - 1; i++) {
                nums[i] = nums[i + 1];
            }
            // decreasing the length
            n--;
            for (int i = 0; i < n; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
        }
        return cnt;
    }

    static boolean nonDecreasing(int[] nums, int n) {
        if (n == 1) return true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }


    static class Router {
        int memoryLimit;
        int memoryUsed = 0;
        TreeSet<Integer> timestamps = new TreeSet<>();
        Map<Integer, Packets> packetsMap = new HashMap<>();

        public Router(int memoryLimit) {
            this.memoryLimit = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Packet packet = new Packet(source, destination);
            if (packetsMap.containsKey(timestamp)) {
                Packets packets = packetsMap.get(timestamp);
                if (!packets.add(packet)) return false;
            } else {
                timestamps.add(timestamp);
                Packets packets = new Packets();
                packets.add(packet);
                packetsMap.put(timestamp, packets);
            }
            if (memoryUsed == memoryLimit) {
                int minTimestamp = timestamps.first();
                Packets packets = packetsMap.get(minTimestamp);
                packets.pollFirst();
                if (packets.size() == 0) {
                    timestamps.pollFirst();
                    packetsMap.remove(minTimestamp);
                }
            } else {
                memoryUsed++;
            }
            return true;
        }

        public int[] forwardPacket() {
            if (memoryUsed == 0) return new int[3];
            int minTimestamp = timestamps.first();
            Packets packets = packetsMap.get(minTimestamp);
            Packet packet = packets.pollFirst();
            if (packets.size() == 0) {
                timestamps.pollFirst();
                packetsMap.remove(minTimestamp);
            }
            memoryUsed--;
            return new int[]{packet.source, packet.destination, minTimestamp};
        }

        public int getCount(int destination, int startTime, int endTime) {
            SortedSet<Integer> range = timestamps.subSet(startTime, endTime + 1);
            int count = 0;
            for (Integer timestamp : range) {
                LinkedList<Packet> packets = packetsMap.get(timestamp).packets;
                for (Packet packet : packets) {
                    if (packet.destination == destination) count++;
                }
            }
            return count;
        }
    }

    static class Packets {
        LinkedList<Packet> packets = new LinkedList<>();
        Set<Packet> set = new HashSet<>();

        boolean add(Packet packet) {
            if (set.contains(packet)) return false;
            packets.add(packet);
            set.add(packet);
            return true;
        }

        public Packet pollFirst() {
            Packet packet = packets.pollFirst();
            set.remove(packet);
            return packet;
        }

        public int size() {
            return packets.size();
        }
    }

    record Packet(int source, int destination) {
    }

}

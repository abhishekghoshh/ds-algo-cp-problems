package com.ds.string;

import java.util.Arrays;

/*
 * Problem link :
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * https://www.codingninjas.com/studio/problems/sorting-characters-by-frequency_1263699
 *
 * Solution link :
 *
 *
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        type1();
        type2();
    }

    private static void type2() {
        String s = "cccaaa";
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] freq = new int[128];
        for (char ch : arr) freq[ch]++;

        char[] res = new char[n];
        for (int i = 0; i < n; ) {
            int max = 0;
            int index = 0;
            // we will find the current max
            for (int j = 0; j < 128; j++) {
                if (freq[j] > max) {
                    max = freq[j];
                    index = j;
                }
            }
            // after finding, we will add those characters and
            // decrement their frequencies
            while (freq[index] > 0) {
                res[i++] = (char) index;
                freq[index]--;
            }
        }
        String answer = new String(res);
        System.out.println(answer);
    }

    private static void type1() {
        String s = "cccaaa";
        char[] arr = s.toCharArray();
        Node[] nodes = new Node[128];
        for (int i = 0; i < nodes.length; i++) nodes[i] = new Node();
        for (char ch : arr) {
            nodes[ch].ch = ch;
            nodes[ch].freq++;
        }
        Arrays.sort(nodes, (node1, node2) -> Integer.compare(node2.freq, node1.freq));
        int index = 0;
        for (Node node : nodes) {
            for (int i = 0; i < node.freq; i++) {
                arr[index++] = node.ch;
            }
        }
        String answer = new String(arr);
        System.out.println(answer);
    }

    private static class Node {
        public char ch;
        public int freq;

        public Node() {
            this.freq = 0;
        }

        public Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}

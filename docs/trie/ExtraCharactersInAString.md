# ExtraCharactersInAString

**Topic:** `trie` | **File:** `com/problems/trie/ExtraCharactersInAString.java`

**Tags:** Arrays, String, Recursion, Trie, Dynamic Programming

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/extra-characters-in-a-string/description/)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ONstwO1cD7c)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Same as previous but here will use trie to match the words here also we have 2 cases, either to consider the character or not but here we can directly use trie to find if the current char is in the dictionary or not because trie has the knowledge of all the words so we do not need to check for any individual words

```java
private static void type2() {
        String s = "dwmodizxvvbosxxw";
        String[] dictionary = {"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"};
        int ans = minExtraChar2(s, dictionary);
        System.out.println(ans);
    }
    private static int minExtraChar2(String s, String[] dictionary) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // initializing the dp array with -1
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        Node trie = new Node();
        for (String word : dictionary) {
            addWord(word.toCharArray(), trie);
        }
        // now using trie, do the search
        return minExtraChar(arr, 0, dp, trie);
    }
    private static int minExtraChar(char[] arr, int start, int[] dp, Node trie) {
        int n = arr.length;
        if (start >= n) return 0;
        if (dp[start] != -1) return dp[start];
        // not considering the current character
        int min = 1 + minExtraChar(arr, start + 1, dp, trie);
        Node node = trie;
        for (int i = start; i < n; i++) {
            int pos = arr[i] - 'a';
            // if the character is not in the trie, then break
            // else goes to the next node till we do not find a word end
            if (node.nodes[pos] == null) break;
            node = node.nodes[pos];
            // if we find any word end, we will start a new recursion call from that point
            if (node.isEnd) {
                min = Math.min(min, minExtraChar(arr, i + 1, dp, trie));
            }
        }
        return dp[start] = min;
    }
    public static void addWord(char[] word, Node trie) {
        Node node = trie;
        for (char ch : word) {
            int pos = ch - 'a';
            if (node.nodes[pos] == null) {
                node.nodes[pos] = new Node();
            }
            node = node.nodes[pos];
        }
        node.isEnd = true;
    }
```

### Approach 1 — Brute Force

Simple recursion but it will fail with simple recursion, so we will apply DP here this problem might look complicated but its just time consuming we can just simple recursion with simple dp, we do not need to use trie here there are two cases either to consider the character or not

```java
private static void type1() {
        String s = "dwmodizxvvbosxxw";
        String[] dictionary = {"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"};
        int ans = minExtraChar1(s, dictionary);
        System.out.println(ans);
    }
    public static int minExtraChar1(String s, String[] dictionary) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        // initializing the dp array with -1
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        // creating a cache to store which word starts with which character
        List<char[]>[] map = new List[26];
        for (int i = 0; i < 26; i++) {
            map[i] = new ArrayList<>();
        }
        for (String word : dictionary) {
            map[word.charAt(0) - 'a'].add(word.toCharArray());
        }
        return minExtraChar1(arr, 0, map, dp);
    }
```

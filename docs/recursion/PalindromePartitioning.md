# PalindromePartitioning

**Topic:** `recursion`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/palindrome-partitioning/description/)
- [📄 NeetCode](https://neetcode.io/problems/palindrome-partitioning)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/799931)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/palindrome-partitioning_626181)
- [📄 InterviewBit](https://www.interviewbit.com/problems/palindrome-partitioning/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=WBgsABoClE0)
- [📄 takeUforward](https://takeuforward.org/data-structure/palindrome-partitioning/)
- [▶ YouTube](https://www.youtube.com/watch?v=3jvWodd7ht0)

## 📝 Problem Statement

Given a string s, return all possible palindrome partitioning of s.

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution

again with dynamic programming but here we will precompute the palindromes for one character, it is always a palindrome now we will do for the 2 length strings now we will do generalization for the strings of length 3 and more then it is not palindrome

```java
    private static void type3() {
        String s = "aabc";
        List<List<String>> answer = partition3(s);
        System.out.println(answer);
    }


    private static List<List<String>> partition3(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> bucket = new ArrayList<>();
        int n = s.length();
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[n][n]; // dp table
        String[][] palindromes = new String[n][n]; // to store the palindromes
        // for one character, it is always a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            palindromes[i][i] = s.substring(i, i + 1);
        }
        // now we will do for the 2 length strings
        for (int i = 0; i + 1 < n; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
                palindromes[i][i + 1] = s.substring(i, i + 2);
            }
        }
        // now we will do generalization for the strings of length 3 and more
        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    palindromes[i][j] = s.substring(i, j + 1);
                }
            }
        }
        partition3(0, n, new ArrayList<>(), answer, palindromes);
        return answer;
    }

    private static void partition3(int start, int n, List<String> bucket, List<List<String>> answer, String[][] palindromes) {
        if (start == n) {
            answer.add(new ArrayList<>(bucket));
            return;
        }
        for (int i = start; i < n; i++) {
            // then it is not palindrome
            if (palindromes[start][i] == null) continue;
            bucket.add(palindromes[start][i]);
            partition3(i + 1, n, bucket, answer, palindromes);
            bucket.remove(bucket.size() - 1);
        }
    }
```

### Approach 2

same as previous with little optimization here we will use a dp table to store if a substring is palindrome or not from the start of the index, we will check for every substring that it is a palindrome or not. if it is a palindrome then we will add the substring into the buckets do the next recursion call from the next index if the (start,i) is not a palindrome, then we will skip that if its already calculated then return the result else we will calculate for the current range

```java
    private static void type2() {
        String s = "aabc";
        List<List<String>> answer = partition2(s);
        System.out.println(answer);
    }

    private static List<List<String>> partition2(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> bucket = new ArrayList<>();

        int n = s.length();
        int[][] dp = new int[n + 1][n + 1]; // dp table
        for (int i = 0; i <= n; i++) dp[i][i] = 1;
        partition2(s, 0, bucket, answer, dp);
        return answer;
    }

    private static void partition2(String str, int start, List<String> bucket, List<List<String>> answer, int[][] dp) {
        int n = str.length();
        if (start == n) {
            answer.add(new ArrayList<>(bucket));
            return;
        }
        // from the start of the index, we will check for every substring that it is a palindrome or not.
        // if it is a palindrome then we will add the substring into the buckets do the next recursion call from the next index
        for (int i = start; i < n; i++) {
            // if the (start,i) is not a palindrome, then we will skip that
            if (!isPalindrome2(str, start, i, dp)) continue;
            bucket.add(str.substring(start, i + 1));
            partition2(str, i + 1, bucket, answer, dp); // we will start from i+1
            bucket.remove(bucket.size() - 1);
        }
    }

    private static boolean isPalindrome2(String s, int l, int r, int[][] dp) {
        // if its already calculated then return the result
        if (dp[l][r] != 0) return (dp[l][r] == 1);
        // else we will calculate for the current range
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                dp[l][r] = -1;
                return false;
            }
            l++;
            r--;
        }
        dp[l][r] = 1;
        return true;
    }
```

### Approach 1: 🔨 Brute Force

with basic recursion and backtracking from the start of the index, we will check for every substring that it is a palindrome or not. if it is a palindrome, then we will add that substring into the bucket do the next recursion call from the next index

```java
    private static void type1() {
        String s = "aabc";
        List<List<String>> answer = partition1(s);
        System.out.println(answer);
    }

    private static List<List<String>> partition1(String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> bucket = new ArrayList<>();
        partition1(s, 0, bucket, answer);
        return answer;
    }

    private static void partition1(String str, int start, List<String> bucket, List<List<String>> answer) {
        int n = str.length();
        if (start == n) {
            answer.add(new ArrayList<>(bucket));
            return;
        }
        // from the start of the index, we will check for every substring
        // that it is a palindrome or not.
        // if it is a palindrome, then we will add that substring into the bucket
        // do the next recursion call from the next index
        for (int i = start; i < n; i++) {
            if (isPalindrome(str, start, i)) {
                bucket.add(str.substring(start, i + 1));
                partition1(str, i + 1, bucket, answer);
                bucket.remove(bucket.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

}
```

# PrintAllWordBreaks

**Topic:** `recursion` | **File:** `com/problems/recursion/PrintAllWordBreaks.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/983635)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

Easy problem of recursion and back tracking check one more time if you find it difficult type2 and type3 is same just that we have used string builder here

```java
private static void type3() {
		String s = "godisnowherenowhere";
		List<String> dictionary = List.of("god", "is", "now", "no", "where", "here");
		Set<String> set = new HashSet<>(dictionary);
		List<String> answer = new ArrayList<>();
		wordBreak3(s, 0, set, answer, new StringBuilder());
		System.out.println(answer);
	}
	private static void wordBreak3(String s, int start, Set<String> set, List<String> answer, StringBuilder prev) {
		int right = start + 1;
		while (right <= s.length()) {
			String word = s.substring(start, right);
			if (set.contains(word)) {
				if (right == s.length()) {
					answer.add(prev.append(word).toString());
					prev.delete(prev.length() - word.length(), prev.length());
				} else {
					wordBreak3(s, right, set, answer, prev.append(word).append(" "));
					prev.deleteCharAt(prev.length() - 1);
					prev.delete(prev.length() - word.length(), prev.length());
				}
			}
			right++;
		}
	}
```

### Approach 2

Improved approach

```java
private static void type2() {
		String s = "godisnowherenowhere";
		List<String> dictionary = List.of("god", "is", "now", "no", "where", "here");
		Set<String> dictionarySet = new HashSet<>(dictionary);
		List<String> answer = new ArrayList<>();
		wordBreak3(s, 0, dictionarySet, answer, "");
		System.out.println(answer);
	}
	private static void wordBreak3(String s, int start, Set<String> set, List<String> answer, String prev) {
		// we are using two pointers
		int right = start + 1;
		while (right <= s.length()) {
			String word = s.substring(start, right);
			// if the word is in the dictionary, then we have two options
			// either to include that word and check words in remaining part else we can
			// wait for a bigger word
			if (set.contains(word)) {
				if (right == s.length()) {
					answer.add(prev + word);
				} else {
					wordBreak3(s, right, set, answer, prev + word + " ");
				}
			}
			right++;
		}
	}
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
		String s = "godisnowherenowhere";
		List<String> dictionary = List.of("god", "is", "now", "no", "where", "here");
		Set<String> dictSet = new HashSet<>(dictionary);
		List<String> answer = wordBreak1(s, 0, dictSet, s.length());
		System.out.println(answer);
	}
	public static List<String> wordBreak1(String s, int start, Set<String> set, int n) {
		// Base Condition
		if (start == n) return List.of("");

		List<String> sentences = new ArrayList<>();
		String word = "";
		// Start exploring the sentence from the index until we wouldn't find 'j' such
		// that substring [index,j] exists in the dictionary as a word
		for (int j = start; j < n; j++) {
			word += s.charAt(j);
			// if word is not in the dictionary then we will skip
			if (!set.contains(word)) continue;
			// Get the answer for rest of sentence from 'j' to s.size()
			List<String> sentencesWithRemaining = wordBreak1(s, j + 1, set, n);
			// Append "word" with all the answer that we got
			for (String sentence : sentencesWithRemaining) {
				if (!sentence.isEmpty()) {
					sentences.add(word + " " + sentence);
				} else {
					sentences.add(word);
				}
			}
		}
		return sentences;
	}
```

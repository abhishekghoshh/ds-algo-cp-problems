# WordDictionary

**Topic:** `trie` | **File:** `com/problems/trie/WordDictionary.java`

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-add-and-search-words-data-structure/description/)
- [📄 NeetCode](https://neetcode.io/problems/design-word-search-data-structure)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=h-F2jRUzpBo -> Tech Dose)
- [▶ YouTube](https://www.youtube.com/watch?v=6O73KA53ayY -> Codebix)
- [▶ YouTube](https://www.youtube.com/watch?v=BTf05gs_8iU -> NeetCode)
- [▶ YouTube](https://www.youtube.com/watch?v=T0Cml8tb9UA -> Pepcoding)

## Approaches

Implementation:

### Implementation

Using trie

```java
private static void type1() {
		Trie trie = new Trie();
		trie.addWord("bad");
		trie.addWord("dad");
		trie.addWord("mad");
		System.out.println(trie.search("pad"));
		System.out.println(trie.search("bad"));
		System.out.println(trie.search(".ad"));
		System.out.println(trie.search("b.."));
	}
```

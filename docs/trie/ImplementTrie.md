# ImplementTrie

**Topic:** `trie` | **File:** `com/problems/trie/ImplementTrie.java`

## Problem Statement

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker. It's a tree like structure where each node represents a single character of a string. The root node represents an empty string. In the real world, we can create the Trie implementation with proper method names and implementations. However, here or in a normal coding exam we can skip it, in a coding interview it's worth mentioning everything with a proper structure and methods

## Problem Links

- [📄 LeetCode](https://leetcode.com/problems/implement-trie-prefix-tree/description/)
- [📄 NeetCode](https://neetcode.io/problems/implement-prefix-tree)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/implement-trie_631356)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/trie-implementation_1062581)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=dBGUmUQhjaM&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-trie-1/)
- [▶ YouTube](https://www.youtube.com/watch?v=oobqoCJlHA0)

## Approaches

This problem has **3** approaches, progressing from brute force to optimal:

### Approach 3 — Optimal

All the approaches at core are same, just the way of implementation is different

```java
private static void type3() {
        Trie3 trie = new Trie3();
        trie.insert("abhishek");
        trie.insert("abhishikta");
        trie.insert("nasim");
        System.out.println(trie.search("abhishek"));
        System.out.println(trie.startsWith("abhi"));
        System.out.println(trie.search("buddhu"));
    }
```

### Approach 2

If there is no child, then we will create a new node on that position if it is the last char, then we will mark it as the end of the word and return if there is no child, then the current character is not present, so we will return false if it is the last char, and it is the end of the word, then return true else recursively go to the next char if there is no child, then the current character is not present, so we will return false if it is the last of the prefix, then return true else recursively go to the next char

```java
private static void type2() {
        Trie2 trie = new Trie2();
        trie.insert("Abhishek");
        trie.insert("Abhishikta");
        trie.insert("Nasim");
        System.out.println(trie.search("Abhishek"));
        System.out.println(trie.startsWith("Abhi"));
        System.out.println(trie.search("Buddhu"));
    }
```

### Approach 1 — Brute Force

Brute force approach

```java
private static void type1() {
        Trie1 trie = new Trie1();
        trie.insert("Abhishek");
        trie.insert("Abhishikta");
        trie.insert("Nasim");
        System.out.println(trie.search("Abhishek"));
        System.out.println(trie.startsWith("Abhi"));
        System.out.println(trie.search("Buddhu"));
        System.out.println(trie.prefixSearch("Ab"));
    }
```

# ImplementTrie2

**Topic:** `trie` | **File:** `com/problems/trie/ImplementTrie2.java`

## Problem Links

- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/implement-trie_1387095)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/trie-delete-operation_1062663)

## Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=K5pcpkEMCN0&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=2)
- [📄 takeUforward](https://takeuforward.org/data-structure/implement-trie-ii/)

## Approaches

This problem has **2** approaches, progressing from brute force to optimal:

### Approach 2 — Optimal

Optimal approach

```java
private static void type2() {
        Trie2 trie = new Trie2();
        trie.insert("samsung");
        trie.insert("samsung");
        System.out.println(trie.countWordsEqualTo("samsung"));
        System.out.println(trie.countWordsStartingWith("samsung"));
        trie.erase("samsung");
        System.out.println(trie.countWordsEqualTo("samsung"));
        System.out.println(trie.countWordsStartingWith("sams"));
    }
```

### Approach 1 — Brute Force

We will only erase a word if it is present at the last if there is any word which is ending then only we will delete endsWith variable and return true as we are not deleting the links, so we have to check if the count prefix is greater than 0 or not erase will only return true if the there is the word found if the word is found then we will decrement count prefix and return true

```java
private static void type1() {
        Trie1 trie = new Trie1();
        trie.insert("samsung");
        trie.insert("samsung");
        System.out.println(trie.countWordsEqualTo("samsung"));
        System.out.println(trie.countWordsStartingWith("samsung"));
        trie.erase("samsung");
        System.out.println(trie.countWordsEqualTo("samsung"));
        System.out.println(trie.countWordsStartingWith("sams"));
    }
```

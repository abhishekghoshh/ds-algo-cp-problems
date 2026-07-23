# DesignHashSet

**Topic:** `hashing`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/design-hashset/description/)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=VymjPQUXjL8)

## 📝 Problem Statement

but it is a waste of space

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

we can create a actual implementation of hash set using a bucket of nodes of size 100 and every node will point to a balanced binary search tree which have actual values, and we will use a good hashing function so that all the element will be spread properly

```java
    private static void type2() {
    }
```

### Approach 1: 🔨 Brute Force

brute force approach as we know the range that we will be given we have created an array beforehand, but it is a waste of space

```java
    private static void type1() {
        MyHashSet1 set = new MyHashSet1();
        set.add(2);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }

    static class MyHashSet1 {

        boolean[] set;
        int N = 1000000;

        public MyHashSet1() {
            set = new boolean[N + 1];
        }

        public void add(int key) {
            set[key] = true;
        }

        public void remove(int key) {
            set[key] = false;
        }

        public boolean contains(int key) {
            return set[key];
        }
    }
}
```

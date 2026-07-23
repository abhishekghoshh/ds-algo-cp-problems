# JosephusProblem

**Topic:** `recursion`  

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=ULUNeD0N9yI&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=19)
- [▶ YouTube](https://www.youtube.com/watch?v=dzYq5VEMZIg)
- [📄 LeetCode](https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1152474/Josephus-Problem)

## 📝 Problem Statement

n people in a circle, eliminate every k-th person. Find the position to survive.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

study it later

**Time Complexity:** `O(n)`
**Space Complexity:** `O(1)`

```java
	private static void type2() {
		int n = 7;
		int k = 3;
		System.out.println("The chosen place is " + findWinner(n, k));
	}

	static int findWinner(int n, int k) {
		if (n == 1) {
			return 1;
		} else {
			/*
			 * The position returned by josephus(n - 1, k) is adjusted because the recursive
			 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
			 */
			return (findWinner(n - 1, k) + k - 1) % (n + 1);
		}
	}
```

### Approach 1: 🔨 Brute Force

if there is only one person alive, then return the person find the person who is to be killed, by going to the next kth person as they are standing in a circle, so we will use modulus kill the person and remove from the list as the person is killed now so the next person will take their place, we can again start counting from that index

**Time Complexity:** `O(n^2)`
**Space Complexity:** `O(n)`

```java
	private static void type1() {
		int n = 7;
		int k = 3;
		List<Integer> persons = new ArrayList<>();
		for (int i = 1; i <= n; i++) persons.add(i);

		int index = findWinner(persons, k, 0);
		System.out.println(index);
	}

	private static int findWinner(List<Integer> persons, int k, int start) {
		// if there is only one person alive, then return the person
		if (persons.size() == 1) return persons.get(0);
		// find the person who is to be killed, by going to the next kth person
		// as they are standing in a circle, so we will use modulus
		start = (start + k - 1) % persons.size();
		// kill the person and remove from the list
		persons.remove(start);
		// as the person is killed now so the next person will take their place,
		// we can again start counting from that index
		return findWinner(persons, k, start);
	}

}
```

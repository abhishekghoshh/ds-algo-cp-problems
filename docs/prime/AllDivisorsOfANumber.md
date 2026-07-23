# AllDivisorsOfANumber

**Topic:** `prime`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/number-of-factors1435/1)
- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/print-all-divisors-of-a-number_1164188)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=1xNbjMdbjug&t=1s)
- [📄 takeUforward](https://takeuforward.org/data-structure/print-all-divisors-of-a-given-number/)

## 📝 Problem Statement

Find the number of factors for a given integer n.&nbsp;Examples:
Input: n = 5
Output: 2
Explanation: 5 has 2 factors 1 and 5
Input: n = 25
Output: 3
Explanation: 25 has 3 factors 1, 5, 25&nbsp;
Constraints:1 &le; n &le; 105

## 💡 Approaches

This problem can be solved in **3** different ways, each improving upon the previous:

### Approach 3: 🏆 Optimal Solution




```java
	private static void type3() {
		int n = 120;
		Node head = new Node(-1);
		Node copy = head;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				head = head.add(i);
				if (n / i != i) head.add(n / i);
			}
		}
		head = copy.next;
		while (null != head) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	private static void type2_() {
		int n = 120;
		int count = 0;
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				count++;
				if (n / i != i) count++;
			}
		}
		System.out.println(count);
	}
```

### Approach 2




```java
	private static void type2() {
		int n = 120;
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				answer.add(i);
				if (n / i != i) answer.add(n / i);
			}
		}
		Collections.sort(answer);
		System.out.println(answer);
	}
```

### Approach 1: 🔨 Brute Force




```java
	private static void type1() {
		int n = 120;
		List<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++)
			if (n % i == 0) answer.add(i);
		System.out.println(answer);
	}
}
```

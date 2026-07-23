# AlienDictionary

**Topic:** `graph`  

## 🔗 Problem Links

- [📄 GeeksforGeeks](https://practice.geeksforgeeks.org/problems/alien-dictionary/1)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/alien-dictionary_630423)
- [📄 LeetCode](https://leetcode.com/problems/alien-dictionary)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=U3N_je7tWAs&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=26)
- [📄 takeUforward](https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/)

## 📝 Problem Statement

This a classic problem of topological sort.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

using dfs and topological sort all the strings are in lexicographic order, so the first string has lower value than the second, so we need to find the characters for which the difference arises we will increment the j till there is a different character we will convert the character to a zero-index integer as the words are in lexicographical order, so character in the first word will be lesser than the second word, and we will draw edge from first[j] to second[j] we will start the dfs for all unvisited nodes and after this the stack will be prepared we will loop through the stack and add the letters into the ans we need to translate the node value to character again simple topological sort using dfs we will loop through all its unvisited adjacent nodes and after that we will add that to the stack

```java
	private static void type2() {
		String[] dict = {
				"baa",
				"abcd",
				"abca",
				"cab",
				"cad"
		};
		int n = 5;
		int k = 4;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < k; i++) adjList.add(new ArrayList<>());

		// all the strings are in lexicographic order,
		// so the first string has lower value than the second,
		// so we need to find the characters for which the difference arises
		for (int i = 0; i < n - 1; i++) {
			char[] first = dict[i].toCharArray();
			char[] second = dict[i + 1].toCharArray();
			int j = 0, n2 = second.length, n1 = first.length;
			// we will increment the j till there is a different character
			while (j < n1 && j < n2 && first[j] == second[j]) j++;
			// we will convert the character to a zero-index integer
			if (j < n1 && j < n2) {
				// as the words are in lexicographical order,
				// so character in the first word will be lesser than the second word,
				// and we will draw edge from first[j] to second[j]
				int start = first[j] - 'a';
				int end = second[j] - 'a';
				adjList.get(start).add(end);
			}
		}

		// we will start the dfs for all unvisited nodes and after this the stack will be prepared
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[k];
		for (int i = 0; i < k; i++)
			if (!visited[i])
				dfs(i, visited, adjList, stack);

		// we will loop through the stack and add the letters into the ans
		StringBuilder dictionary = new StringBuilder();
		while (!stack.isEmpty()) {
			int start = stack.pop();
			// we need to translate the node value to character again
			char letter = (char) (start + 'a');
			dictionary.append(letter);
		}

		System.out.println(dictionary);
	}

	// simple topological sort using dfs
	private static void dfs(int start, boolean[] visited, List<List<Integer>> adjList, Stack<Integer> stack) {
		visited[start] = true;
		// we will loop through all its unvisited adjacent nodes
		for (int node : adjList.get(start))
			if (!visited[node])
				dfs(node, visited, adjList, stack);
		// and after that we will add that to the stack
		stack.push(start);
	}
```

### Approach 1: 🔨 Brute Force

using bfs and kahn algorithm all the strings are in lexicographic order, so the first string has lower value than the second, so we need to find the characters for which the difference arises we will increment the j till there is a different character we will convert the character to a zero-index integer as the words are in lexicographical order, so character in the first word will be lesser than the second word, and we will draw edge from first[j] to second[j] we will calculate all the indegree from the adjacency list and add starting nodes to the queue we will poll from the queue and store it to the string builder we need to translate the node value to character again we will loop through all its adjacent nodes

```java
	private static void type1() {
		String[] dict = {
				"baa",
				"abcd",
				"abca",
				"cab",
				"cad"
		};
		int n = 5;
		int k = 4;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < k; i++) adjList.add(new ArrayList<>());

		// all the strings are in lexicographic order,
		// so the first string has lower value than the second,
		// so we need to find the characters for which the difference arises
		for (int i = 0; i < n - 1; i++) {
			char[] first = dict[i].toCharArray();
			char[] second = dict[i + 1].toCharArray();
			int j = 0, n2 = second.length, n1 = first.length;
			// we will increment the j till there is a different character
			while (j < n1 && j < n2 && first[j] == second[j]) j++;
			// we will convert the character to a zero-index integer
			if (j < n1 && j < n2) {
				// as the words are in lexicographical order,
				// so character in the first word will be lesser than the second word,
				// and we will draw edge from first[j] to second[j]
				int start = first[j] - 'a';
				int end = second[j] - 'a';
				adjList.get(start).add(end);
			}
		}

		// we will calculate all the indegree from the adjacency list
		// and add starting nodes to the queue
		int[] indegree = new int[k];
		for (List<Integer> nodes : adjList)
			for (int node : nodes) indegree[node]++;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < k; i++)
			if (indegree[i] == 0) queue.offer(i);

		// we will poll from the queue and store it to the string builder
		StringBuilder dictionary = new StringBuilder();
		while (!queue.isEmpty()) {
			int start = queue.poll();
			// we need to translate the node value to character again
			char letter = (char) (start + 'a');
			dictionary.append(letter);
			// we will loop through all its adjacent nodes
			for (int end : adjList.get(start)) {
				indegree[end]--;
				if (indegree[end] == 0) queue.offer(end);
			}
		}
		System.out.println(dictionary);
	}

}
```

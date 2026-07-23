# StockSpan

**Topic:** `stack`  

## 🔗 Problem Links

- [📄 LeetCode](https://leetcode.com/problems/online-stock-span/description/)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/span-of-ninja-coin_1475049)
- [📄 Coding Ninjas](https://www.naukri.com/code360/problems/stock-span_5243295)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6)
- [▶ YouTube](https://www.youtube.com/watch?v=slYh0ZNEqSw)

## 📝 Problem Statement

The span of the stock's price today is defined as the maximum number of

## 💡 Approaches

This problem can be solved in **5** different ways, each improving upon the previous:

### Approach 5: 🏆 Optimal Solution

here we are using an array as stack

```java
	private static void type5() {
		StockSpanner2 stockSpanner = new StockSpanner2();
		System.out.print(stockSpanner.next(100) + " ");
		System.out.print(stockSpanner.next(80) + " ");
		System.out.print(stockSpanner.next(60) + " ");
		System.out.print(stockSpanner.next(70) + " ");
		System.out.print(stockSpanner.next(60) + " ");
		System.out.print(stockSpanner.next(75) + " ");
		System.out.print(stockSpanner.next(85) + " ");
		System.out.println();
	}

	private static class StockSpanner2 {
		final int N = 10010;
		int[] stack, prices;
		int top, i;

		public StockSpanner2() {
			stack = new int[N];
			prices = new int[N];
			top = 0;
			i = 0;
		}

		// here we are using an array as stack
		public int next(int price) {
			prices[i] = price;
			while (top > 0 && prices[stack[top]] <= price)
				top--;
			int res = (top == 0) ? (i + 1) : (i - stack[top]);
			stack[++top] = i++;
			return res;
		}
	}
```

### Approach 4

same as previous type3 Asymptotically it is an O(1) operation the it's not like the stack will be popped entirely on each next method

```java
	private static void type4() {
		StockSpanner1 stockSpanner = new StockSpanner1();
		System.out.print(stockSpanner.next(100) + " ");
		System.out.print(stockSpanner.next(80) + " ");
		System.out.print(stockSpanner.next(60) + " ");
		System.out.print(stockSpanner.next(70) + " ");
		System.out.print(stockSpanner.next(60) + " ");
		System.out.print(stockSpanner.next(75) + " ");
		System.out.print(stockSpanner.next(85) + " ");
		System.out.println();
	}

	private static class StockSpanner1 {
		List<Integer> list;
		Stack<Integer> stack;

		public StockSpanner1() {
			list = new ArrayList<>();
			stack = new Stack<>();
		}

		// Asymptotically it is an O(1) operation
		// the it's not like the stack will be popped entirely on each next method
		public int next(int price) {
			list.add(price);
			int n = list.size();
			int span;
			while (!stack.isEmpty() && list.get(stack.peek()) <= price)
				stack.pop();
			span = (!stack.isEmpty()) ? (n - 1 - stack.peek()) : n;
			stack.add(n - 1);
			return span;
		}
	}
```

### Approach 3

here we are computing the span in the same loop itself

**Time Complexity:** `O(2n)`
**Space Complexity:** `O(n)`

```java
	private static void type3() {
		int[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
		int n = stocks.length;
		int[] span = new int[n];
		Stack<Integer> stack = new Stack<>();
		int j = 0;
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stocks[stack.peek()] <= stocks[i]) stack.pop();
			span[i] = (!stack.isEmpty()) ? (i + 1) : (i - stack.peek());
			stack.push(i);
		}
		print(span);
	}
```

### Approach 2

here we are first computing the previous greater element and then from that we are deriving the span we will maintain a monotonic decreasing stack we are removing all the previous lesser or equal to elements it will pop until there is a large element in stack

**Time Complexity:** `O(3n)`
**Space Complexity:** `O(2n)`

```java
	private static void type2() {
		int[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
		int n = stocks.length;
		Stack<Integer> stack = new Stack<>();
		int[] indices = new int[n];
		int[] span = new int[n];
		// we will maintain a monotonic decreasing stack
		for (int i = 0; i < n; i++) {
			// we are removing all the previous lesser or equal to elements
			// it will pop until there is a large element in stack
			while (!stack.isEmpty() && stocks[stack.peek()] <= stocks[i])
				stack.pop();
			indices[i] = (!stack.isEmpty()) ? stack.peek() : -1;
			stack.add(i);
		}
		// print(indices);
		for (int i = 0; i < n; i++) span[i] = i - indices[i];
		print(span);
	}
```

### Approach 1: 🔨 Brute Force

brute force

```java
	private static void type1() {
		int[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
		print(stocks);
	}
}
```

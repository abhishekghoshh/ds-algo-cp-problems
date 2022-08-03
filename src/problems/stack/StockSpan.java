package problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockSpan {
	public static void main(String args[]) {
		Integer[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
		int length = stocks.length;
		List<Integer> answer = stockSpan(stocks, length);
		System.out.println(Arrays.asList(stocks));
		System.out.println(answer);
	}

	private static List<Integer> stockSpan(Integer[] stocks, int length) {
		Stack<Integer> stack = new Stack<>();
		List<Integer> vertices = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			if (stack.size() == 0) {
				vertices.add(-1);
			} else {
				if (stocks[stack.peek()] > stocks[i]) {
					vertices.add(stack.peek());
				} else {
					while (stack.size() > 0 && stocks[stack.peek()] <= stocks[i]) {
						stack.pop();
					}
					if (stack.size() == 0) {
						vertices.add(-1);
					} else {
						vertices.add(stack.peek());
					}
				}
			}
			stack.add(i);
		}
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			answer.add(i - vertices.get(i));
		}
		return answer;
	}
}

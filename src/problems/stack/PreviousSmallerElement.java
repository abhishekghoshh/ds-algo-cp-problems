package problems.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreviousSmallerElement {
	public static void main(String args[]) {
		type2();
	}

	private static void type2() {
		Integer[] arr = { 1, 3, 2, 4, 3, 3 };
		int n = arr.length;
		Stack<Integer> stack = new Stack<>();
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (stack.size() == 0) {
				answer.add(-1);
			} else {
				if (stack.peek() < arr[i]) {
					answer.add(stack.peek());
				} else {
					while (stack.size() > 0 && stack.peek() >= arr[i]) {
						stack.pop();
					}
					if (stack.size() == 0) {
						answer.add(-1);
					} else {
						answer.add(stack.peek());
					}
				}
			}
			stack.add(arr[i]);
		}
		System.out.println(Arrays.asList(arr));
		System.out.println(answer);
	}
}

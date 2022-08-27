package problems.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

class ArrayPositionHolder {
	int top;
	int arrayPosition;
	int index;

	public ArrayPositionHolder(int top, int arrayPosition, int index) {
		super();
		this.top = top;
		this.arrayPosition = arrayPosition;
		this.index = index;
	}

	@Override
	public String toString() {
		return "ArrayPositionHolder [top=" + top + ", arrayPosition=" + arrayPosition + ", index=" + index + "]";
	}

}

public class MergeNOrderedArrays {
	public static void main(String[] args) {
		int[][] arrays = { { 2, 6, 12, 34 }, { 3 }, { 1, 3, 9, 10, 20 }, { 23, 34, 36, 40 }, { 4, 5, 7, 8 } };
		int size = Arrays.stream(arrays).mapToInt(array -> array.length).reduce(0, (a, b) -> Integer.sum(a, b));
		int[] sortedArray = new int[size];

		PriorityQueue<ArrayPositionHolder> queue = new PriorityQueue<>(
				(first, second) -> Integer.compare(first.top, second.top));
		int j = 0;
		for (int[] array : arrays) {
			queue.offer(new ArrayPositionHolder(array[0], j++, 0));
		}
		// System.out.println(queue);
		int index = 0;
		while (queue.size() != 0) {
			ArrayPositionHolder topArrayPositionHolder = queue.poll();
			int topItemIndex = topArrayPositionHolder.index;
			int topArrayIndex = topArrayPositionHolder.arrayPosition;
			if (queue.size() != 0) {
				ArrayPositionHolder currentTopArrayPositionHolder = queue.peek();
				int currentTopItemIndex = currentTopArrayPositionHolder.index;
				int currentTopArrayIndex = currentTopArrayPositionHolder.arrayPosition;
				int i;
				for (i = topItemIndex; i < arrays[topArrayIndex].length
						&& arrays[topArrayIndex][i] <= arrays[currentTopArrayIndex][currentTopItemIndex]; i++) {
					sortedArray[index++] = arrays[topArrayIndex][i];
				}
				if (i != arrays[topArrayIndex].length) {
					topArrayPositionHolder.top = arrays[topArrayIndex][i];
					topArrayPositionHolder.arrayPosition = topArrayIndex;
					topArrayPositionHolder.index = i;
					queue.offer(topArrayPositionHolder);
				}
			} else {
				for (int i = topItemIndex; i < arrays[topArrayIndex].length; i++) {
					sortedArray[index++] = arrays[topArrayIndex][i];
				}
			}
		}
		for (int item : sortedArray) {
			System.out.print(item + " ");
		}
	}

}

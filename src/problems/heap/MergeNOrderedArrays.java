package problems.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class ArrayPositionHolder {
	private int top;
	private int arrayPosition;
	private int index;

	public ArrayPositionHolder(int top, int arrayPosition, int index) {
		super();
		this.top = top;
		this.arrayPosition = arrayPosition;
		this.index = index;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getArrayPosition() {
		return arrayPosition;
	}

	public void setArrayPosition(int arrayPosition) {
		this.arrayPosition = arrayPosition;
	}

	public ArrayPositionHolder top(int top) {
		this.setTop(top);
		return this;
	}

	public ArrayPositionHolder arrayPosition(int arrayPosition) {
		this.setArrayPosition(arrayPosition);
		return this;
	}

	public ArrayPositionHolder index(int index) {
		this.setIndex(index);
		return this;
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
				Comparator.comparing(ArrayPositionHolder::getTop));
		int j = 0;
		for (int[] array : arrays) {
			queue.offer(new ArrayPositionHolder(array[0], j++, 0));
		}
		// System.out.println(queue);
		int index = 0;
		while (queue.size() != 0) {
			ArrayPositionHolder topArrayPositionHolder = queue.poll();
			int topItemIndex = topArrayPositionHolder.getIndex();
			int topArrayIndex = topArrayPositionHolder.getArrayPosition();
			if (queue.size() != 0) {
				ArrayPositionHolder currentTopArrayPositionHolder = queue.peek();
				int currentTopItemIndex = currentTopArrayPositionHolder.getIndex();
				int currentTopArrayIndex = currentTopArrayPositionHolder.getArrayPosition();
				int i;
				for (i = topItemIndex; i < arrays[topArrayIndex].length
						&& arrays[topArrayIndex][i] <= arrays[currentTopArrayIndex][currentTopItemIndex]; i++) {
					sortedArray[index++] = arrays[topArrayIndex][i];
				}
				if (i != arrays[topArrayIndex].length) {
					queue.offer(
							topArrayPositionHolder.top(arrays[topArrayIndex][i]).arrayPosition(topArrayIndex).index(i));
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

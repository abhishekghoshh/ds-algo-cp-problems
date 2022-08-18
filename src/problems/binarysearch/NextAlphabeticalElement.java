package problems.binarysearch;

public class NextAlphabeticalElement {

	public static void main(String[] args) {
		char[] elements = { 'a', 'b', 'm', 'n', 'x', 'y', 'z' };
		int low = 0;
		int high = elements.length - 1;
		char key = 'z';
		int index = search(elements, low, high, key);
		char result = index!=elements.length?elements[index]:'#';
		System.out.println(result);

	}

	private static int search(char[] elements, int low, int high, char key) {
		int index = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (elements[mid] == key) {
				return mid + 1;
			} else if (elements[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
				index = mid;
			}
		}
		return index;
	}

}

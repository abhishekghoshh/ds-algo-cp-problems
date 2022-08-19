package problems.findminningandduplicate;

public class FindMissingAndDuplicateWithMap {

	public static void main(String[] args) {
		int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
		int n = arr.length;
		int[] frequency = new int[n];
		for (int item : arr) {
			frequency[item - 1]++;
		}
		for (int i = 0; i < n; i++) {
			if (frequency[i] == 0) {
				System.out.println("Missing element is " + (i + 1));
			}
			if (frequency[i] > 1) {
				System.out.println("Duplicate element is " + (i + 1));
			}
		}
	}

}

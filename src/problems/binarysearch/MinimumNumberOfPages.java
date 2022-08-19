package problems.binarysearch;

public class MinimumNumberOfPages {

	public static void main(String[] args) {
		int arr[] = { 12, 34, 67, 90 }; // Number of pages in books
		int students = 2;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int item : arr) {
			if (max < item) {
				max = item;
			}
			sum = sum + item;
		}
		int answer = findMinimumNumberOfPages(arr, students, max, sum);
		System.out.println(answer);

	}

	private static int findMinimumNumberOfPages(int[] arr, int students, int low, int high) {
		int minimumNumber = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (isValid(arr, students, mid)) {
				minimumNumber = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return minimumNumber;
	}

	private static boolean isValid(int[] arr, int students, int maxPagesAssigned) {
		int tempStudents = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum > maxPagesAssigned) {
				sum = arr[i];
				tempStudents++;
			}
			if (i == arr.length - 1) {
				tempStudents++;
			}
			if (tempStudents > students)
				return false;
		}
		return tempStudents == students;
	}

}

package sort;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://takeuforward.org/data-structure/quick-sort-algorithm/
 * https://www.geeksforgeeks.org/quick-sort/
 * 
 */
public class QuickSort {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;
		quickSort_(arr, 0, n - 1);
	}

	static void quickSort_(int[] arr, int low, int high) {
		if (low < high) {
			// partionIndex is partitioning index, arr[p] is now at right place
			int partionIndex = partition_(arr, low, high);
			// Separately sort elements before
			// partition and after partition
			quickSort_(arr, low, partionIndex - 1);
			quickSort_(arr, partionIndex + 1, high);
		}
	}

	/*
	 * This function takes last element as pivot, places the pivot element at its
	 * correct position in sorted array, and places all smaller (smaller than pivot)
	 * to left of pivot and all greater elements to right of pivot
	 */
	static int partition_(int[] arr, int low, int high) {
		// we are setting last item as pivot
		int pivot = arr[high];
		// Index of smaller element and indicates
		// the right position of pivot found so far
		int i = (low - 1);
		for (int j = low; j <= high - 1; j++) {
			// If current element is smaller
			// than the pivot
			if (arr[j] < pivot) {
				// Increment index of smaller element
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i + 1, high);
		return (i + 1);
	}

	private static void type1() {
		int arr[] = { 12, 10, 11, 13, 21, 24, 25, 20, 9 };
		int n = arr.length;
		quicksort(arr, 0, n - 1);
		print(arr);
	}

	private static void quicksort(int arr[], int low, int high) {
		if (low < high) {
			// after each partition method one item is placed in its actual position
			// and on its left every item is smaller
			// and on its right every item is greater
			int partionIndex = partition(arr, low, high);
			// after partionIndex element is placed on so we can do the same for
			// low to partionIndex-1 and partionIndex+1 to high
			quicksort(arr, low, partionIndex - 1);
			quicksort(arr, partionIndex + 1, high);
		}
	}

	private static int partition(int arr[], int low, int high) {
		// we are setting first item as pivot
		int pivot = arr[low];
		int i = low;
		int j = high;
		while (i < j) {
			// this loop will break once there is item greater than pivot
			while (arr[i] <= pivot && i <= high - 1) {
				i++;
			}
			// this loop will break once there is item lesser than pivot
			while (arr[j] > pivot && j >= low) {
				j--;
			}
			// once we found two indices we will swap two items
			// i > j means there are two partitions already made
			if (i < j) {
				swap(arr, i, j);
			}
		}
		// after the iteration low+1 to j is lesser than pivot
		swap(arr, j, low);
		return j;
	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	private static void print(int[] arr) {
		for (int item : arr) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

}

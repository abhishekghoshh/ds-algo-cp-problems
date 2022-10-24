package problems.binarysearch;
/*
 * Problem link :
 * 
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9
 * 
 * */
public class SearchingInNearlySortedArray {
    public static void main(String args[]) {
        type2();
    }

	private static void type2() {
		int arr[] = { 10, 3, 40, 20, 50, 80, 70 };
        int length = arr.length;
        int key = 3;
        int index = search(arr, 0, length - 1, length, key);
        System.out.println(index);
	}

    private static int search(int[] arr, int low, int high, int length, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (mid - 1 >= 0 && arr[mid - 1] == key) {
                return mid - 1;
            } else if (mid + 1 <= length - 1 && arr[mid + 1] == key) {
                return mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;
    }
}

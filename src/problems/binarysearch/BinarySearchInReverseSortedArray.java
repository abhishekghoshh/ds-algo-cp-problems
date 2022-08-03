package BinarySearchQuestions;

public class BinarySearchInReverseSortedArray {
    public static void main(String args[]) {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int low = 0;
        int high = arr.length - 1;
        int key = 2;
        int index = search(arr, low, high, key);
        System.out.println(index);
    }

    private static int search(int[] arr, int low, int high, int key) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (key < arr[mid]) {
                low = mid + 1;
            } else if (key > arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;
    }
}

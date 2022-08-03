package BinarySearchQuestions;

public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
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
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }
}

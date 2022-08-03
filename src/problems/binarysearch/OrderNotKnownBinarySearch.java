package BinarySearchQuestions;

public class OrderNotKnownBinarySearch {

    public static void main(String args[]) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int key = 8;
        int index = search(arr, key);
        System.out.println(index);
    }

    private static int search(int[] arr, int key) {
        if (arr.length == 1) {
            return arr[0] == key ? key : -1;
        }
        int low = 0;
        int high = arr.length - 1;
        if (arr[low] < arr[high]) {
            return increasingOrderSearch(arr, low, high, key);
        } else {
            return decreasingOrderSearch(arr, low, high, key);
        }
    }

    private static int increasingOrderSearch(int[] arr, int low, int high, int key) {
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

    private static int decreasingOrderSearch(int[] arr, int low, int high, int key) {
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

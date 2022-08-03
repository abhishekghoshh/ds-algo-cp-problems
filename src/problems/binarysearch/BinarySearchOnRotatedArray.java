package BinarySearchQuestions;

public class BinarySearchOnRotatedArray {

    public static void main(String args[]) {
        int[] arr = { 7, 8, 9, 10, 11, 12, 0, 1, 2, 3, 4, 5, 6 };
        int length = arr.length;
        int high = arr.length - 1;
        int offset = searchOffset(arr, 0, high, length);
        int key = 5;
        int left = search(arr, 0, offset - 1, key);
        int right = search(arr, offset, high, key);
        printAnswer(left, right);
    }

    private static void printAnswer(int left, int right) {
        if (left == -1 && right == -1) {
            System.out.println(-1);
        } else if (left == -1) {
            System.out.println(right);
        } else {
            System.out.println(left);
        }
    }

    private static int searchOffset(int[] arr, int low, int high, int length) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + length) % length;
            int next = (mid + 1) % length;
            if (arr[prev] > arr[mid] && arr[mid] < arr[next]) {
                return mid;
            }
            if (arr[mid] < arr[high]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
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

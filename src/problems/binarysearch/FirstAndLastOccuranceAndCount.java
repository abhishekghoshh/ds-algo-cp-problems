package BinarySearchQuestions;

public class FirstAndLastOccuranceAndCount {
    public static void main(String args[]) {
        int[] arr = { 0, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 7, 8, 9, 10, 11 };
        int low = 0;
        int high = arr.length - 1;
        int key = 3;
        int firstOccurance = firstOccurance(arr, low, high, key);
        int lastOccurance = lastOccurance(arr, low, high, key);
        System.out.println(firstOccurance);
        System.out.println(lastOccurance);
        System.out.println(lastOccurance - firstOccurance + 1);
    }

    private static int firstOccurance(int[] arr, int low, int high, int key) {
        int index = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                index = mid;
                high = mid;
            } else if (key <= arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            }
        }
        return index;
    }

    private static int lastOccurance(int[] arr, int low, int high, int key) {
        int index = -1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (key == arr[mid]) {
                index = mid;
                low = mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            }
        }
        return index;
    }
}

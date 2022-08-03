package BinarySearchQuestions;

public class NoOfTimesSortedArrayRotated {
    public static void main(String args[]) {
        int[] array = { 7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6 };
        int length = array.length;
        int high = array.length - 1;
        int offset = searchOffset(array, 0, high, length);
        System.out.println(offset);
    }

    private static int searchOffset(int[] arr, int low, int high, int length) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            int prev = (mid - 1 + length) % length;
            int next = (mid + 1) % length;
            if (arr[prev] > arr[mid] && arr[mid] < arr[next]) {
                return mid;
            }
            if (arr[low] <= arr[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

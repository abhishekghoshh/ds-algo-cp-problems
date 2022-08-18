package problems.slidingwindow;

public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
		int k = 4;
		System.out.println(maxSum(arr, arr.length, k));
	}

	private static int maxSum(int[] arr, int length, int k) {
		int sum = 0;
		int j = 0;
		while (j < k) {
			sum = sum + arr[j++];
		}
		int maxSum = sum;
		while (j < length) {
			sum = sum + arr[j] - arr[j - k];
			j++;
			maxSum = Integer.max(maxSum, sum);
		}
		return maxSum;
	}

}

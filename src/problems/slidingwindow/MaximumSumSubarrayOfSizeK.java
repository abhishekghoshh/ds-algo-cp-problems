package problems.slidingwindow;

public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int arr[] = { 1, 1, 2, 10, 2, 3, 1, 0, 10 };
		int k = 4;
		int maxSum = Integer.MIN_VALUE, sum = 0;
		int left = 0, right = 0;
		// we are letting the window until the the window size becomes k
		while (right < k) {
			sum = sum + arr[right++];
		}
		// once it become k, in the next iteration it's coming to else
		// so if the window size is 4
		// then now left will be 0 and right will be 4
		// and sum is arr[0]+arr[1]+arr[2]+arr[3]
		while (right < arr.length) {
			// so now we are adding arr[4] and subtracting arr[0]
			// and sum is arr[1]+arr[2]+arr[3]+arr[4]
			sum = sum + arr[right++] - arr[left++];
			maxSum = Integer.max(maxSum, sum);
		}
		System.out.println(maxSum);
	}

}

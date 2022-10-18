package problems.string;

public class LongestPalindromInAString {

	public static void main(String[] args) {
		type1();
	}

	// optimal approach
	// time complexity O(n^2)
	// space complexity O(1)
	private static void type1() {
		String s = "babad";
		int maxSize = 0, start = 0, end = 0, left, right, n = s.length();
		// if you are using java
		// don't directly operate on string
		// rather create one array of character
		// otherwise it will long time
		char[] arr = s.toCharArray();
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				left = i;
				right = i + 1;
				while (left >= 0 && right < n && arr[left] == arr[right]) {
					left--;
					right++;
				}
				left++;
				right--;
				if (right - left + 1 > maxSize) {
					maxSize = right - left + 1;
					start = left;
					end = right;
				}
			}
			left = i;
			right = i;
			while (left >= 0 && right < n && arr[left] == arr[right]) {
				left--;
				right++;
			}
			left++;
			right--;
			if (right - left + 1 > maxSize) {
				maxSize = right - left + 1;
				start = left;
				end = right;
			}
		}
		s = s.substring(start, end + 1);
		System.out.println(s);
	}

}

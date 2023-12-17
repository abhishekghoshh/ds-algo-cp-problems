package string;

/*
 * 
 * problem links :
 * https://leetcode.com/problems/valid-palindrome/
 * 
 * Solution link : 
 * 
 * */
public class ValidPalindrome {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String s = "A man, a plan, a canal: Panama";
		char[] arr = s.toCharArray();
		int n = arr.length;
		int left = 0, right = n - 1;
		boolean isPalindrome = true;
		while (left < right) {
			// skipping left and right until we find any digit or letter
			while (left < n && !Character.isLetterOrDigit(arr[left])) left++;
			while (right >= 0 && !Character.isLetterOrDigit(arr[right])) right--;
			if (left < right && Character.toLowerCase(arr[left]) != Character.toLowerCase(arr[right])) {
				isPalindrome = false;
				break;
			}
			left++;
			right--;
		}
		System.out.println(isPalindrome);
	}

	private static void type1() {
		String s = "A man, a plan, a canal: Panama";
		boolean isPalindrome = isPalindrome(s);
		System.out.println(isPalindrome);
	}

	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i)))
				sb.append(Character.toLowerCase(s.charAt(i)));
			if (Character.isDigit(s.charAt(i)))
				sb.append(s.charAt(i));
		}
		StringBuilder sbc = new StringBuilder(sb);
		sbc.reverse();
		return sb.toString().contentEquals(sbc);
	}

}

package recursion;

public class StringIsPalindrome {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		String str = "aabbccbbaa";
		boolean isPalindrome = isPalindrome(str.toCharArray(), 0, str.length() - 1);
		System.out.println(isPalindrome);
	}

	private static boolean isPalindrome(char[] str, int left, int right) {
		if (left >= right)
			return true;
		if (str[left] == str[right])
			return isPalindrome(str, left + 1, right - 1);
		return false;
	}

}

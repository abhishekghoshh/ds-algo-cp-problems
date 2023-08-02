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

	}

	private static void type1() {
		String s = "A man, a plan, a canal: Panama";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				sb.append(Character.toLowerCase(s.charAt(i)));
			}
		}
		StringBuffer sbc = new StringBuffer(sb);
		sbc.reverse();
		boolean isPalindrome = sb.toString().equals(sbc.toString());
		System.out.println(isPalindrome);
	}

}

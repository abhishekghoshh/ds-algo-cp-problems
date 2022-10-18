package problems.string;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		type1();
		type2();
	}

	private static void type2() {
		String[] strs = { "flower", "flow", "flight" };
		StringBuilder sb = new StringBuilder();
		int minLength = Integer.MAX_VALUE;
		String commonPrefix = null;
		for (int i = 0; i < strs.length; i++) {
			minLength = Math.min(minLength, strs[i].length());
		}
		for (int i = 0; i < minLength; i++) {
			char c = strs[0].charAt(i);
			for (int j = 0; j < strs.length; j++) {
				if (strs[j].charAt(i) != c) {
					commonPrefix = sb.toString();
				}
			}
			if (null != commonPrefix) {
				break;
			} else {
				sb.append(c);
			}
		}
		System.out.println(commonPrefix);
	}

	private static void type1() {
		String[] strs = { "flower", "flow", "flight" };
		char ch;
		String commonPrefix = null;
		String pivot = strs[0];
		int n = pivot.length();
		for (int index = 0; index <= n; index++) {
			if (index < n) {
				ch = pivot.charAt(index);
			} else {
				commonPrefix = pivot;
				break;
			}
			for (int i = 1; i < strs.length; i++) {
				if (index == strs[i].length() || ch != strs[i].charAt(index)) {
					commonPrefix = pivot.substring(0, index);
					break;
				}
			}
			if (null != commonPrefix) {
				break;
			}
		}
		System.out.println(commonPrefix);
	}

}

package problems.slidingwindow;

public class CountOfAnagrams {

	public static void main(String[] args) {
		type1();
		type2();
	}

	public static void type2() {
		String text = "forxxorfxdofr";
		String pattern = "for";

		int textSize = text.length();
		int patternSize = pattern.length();
		int[] patternArray = new int[26];
		int[] textArray = new int[26];
		int left = 0, right = 0, count = 0;
		while (right < patternSize) {
			patternArray[pattern.charAt(right) - 'a']++;
			textArray[text.charAt(right) - 'a']++;
			right++;
		}
		while (left < textSize - patternSize + 1) {
			if (equals(patternArray, textArray)) {
				count++;
			}
			if (left + patternSize == textSize) {
				break;
			}
			textArray[text.charAt(left) - 'a']--;
			textArray[text.charAt(left + patternSize) - 'a']++;
			left++;
		}
		System.out.print(count);
	}

	private static void type1() {

	}

	private static boolean equals(int[] patternArray, int[] textArray) {
		for (int i = 0; i < patternArray.length; i++) {
			if (patternArray[i] != textArray[i]) {
				return false;
			}
		}
		return true;
	}

}

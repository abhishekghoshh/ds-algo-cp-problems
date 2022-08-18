package problems.slidingwindow;

public class CountOfAnagrams {

	public static void main(String[] args) {
		String text = "forxxorfxdofr";
		String pattern = "for";
		System.out.print(countAnagrams(text, pattern));
	}

	public static int countAnagrams(String text, String pattern) {
		int[] patternArray = new int[26];
		int[] textArray = new int[26];
		int count = 0;
		int textSize = text.length();
		int patternSize = pattern.length();
		int i = 0;
		while (i < textSize) {
			if (i < patternSize) {
				patternArray[pattern.charAt(i) - 'a']++;
				textArray[text.charAt(i) - 'a']++;
			} else {
				if (equals(patternArray, textArray)) {
					count++;
				}
				textArray[text.charAt(i) - 'a']++;
				textArray[text.charAt(i - patternSize) - 'a']--;
			}
			i++;
		}
		if (equals(patternArray, textArray)) {
			count++;
		}
		return count;
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

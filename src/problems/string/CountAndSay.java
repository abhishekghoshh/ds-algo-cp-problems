package problems.string;
/*
 * Problem link :
 * https://leetcode.com/problems/count-and-say/
 * https://www.codingninjas.com/codestudio/problems/1090543?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * https://www.youtube.com/watch?v=9fI_26Dl1IA
 * 
 */

public class CountAndSay {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int n = 30;
		String answer = countAndSay(n);
		System.out.println(answer);
	}

	private static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String prev = countAndSay(n - 1);
		char[] arr = prev.toCharArray();
		StringBuilder sb = new StringBuilder();
		int currentNum = toInt(arr, 0);
		int count = 1;
		for (int i = 1; i < arr.length; i++) {
			if (toInt(arr, i) != currentNum) {
				sb.append(count).append(currentNum);
				currentNum = toInt(arr, i);
				count = 1;
			} else {
				count++;
			}
		}
		// for the last iteration
		sb.append(count).append(currentNum);
		return sb.toString();
	}

	private static int toInt(char[] arr, int i) {
		return arr[i] - '0';
	}

}

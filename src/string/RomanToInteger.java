package string;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem link : 
 * https://leetcode.com/problems/roman-to-integer/
 * https://www.codingninjas.com/codestudio/problems/981308?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=dlATMslQ6Uc
 * https://www.youtube.com/watch?v=3jdxYj3DD98
 * */
public class RomanToInteger {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
		type4();
		type5();
	}

	private static void type5() {
		String s = "MCMXCIV";
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
		char[] c = s.toCharArray();
		int[] n = new int[c.length];
		for (int i = 0; i < n.length; i++)
			n[i] = m.get(c[i]);
		int sum = 0;
		for (int i = 0; i < n.length; i++)
			sum = i == c.length - 1 || n[i] >= n[i + 1] ? sum + n[i] : sum - n[i];
		System.out.println(sum);
	}

	private static void type4() {
		String s = "MCMXCIV";
		int ans = 0, num = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'I':
				num = 1;
				break;
			case 'V':
				num = 5;
				break;
			case 'X':
				num = 10;
				break;
			case 'L':
				num = 50;
				break;
			case 'C':
				num = 100;
				break;
			case 'D':
				num = 500;
				break;
			case 'M':
				num = 1000;
				break;
			}
			if (4 * num < ans)
				ans -= num;
			else
				ans += num;
		}
		System.out.println(ans);
	}

	private static void type3() {
		String s = "MCMXCIV";
		int n = s.length() - 1;
		int ans = 0;
		int prev = 0;
		int sum = 0;
		for (int i = n; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'I':
				ans = 1;
				break;
			case 'V':
				ans = 5;
				break;
			case 'X':
				ans = 10;
				break;
			case 'L':
				ans = 50;
				break;
			case 'C':
				ans = 100;
				break;
			case 'D':
				ans = 500;
				break;
			case 'M':
				ans = 1000;
				break;
			default:
				break;
			}
			if (ans < prev) {
				sum = sum - ans;
			} else {
				sum = sum + ans;
			}
			prev = ans;
		}
		System.out.println(sum);
	}

	private static void type2() {
		String s = "MCMXCIV";
		char[] arr = s.toCharArray();
		int n = arr.length;
		int result = get(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			// if the number is IV
			// so result = V - I
			// if the number is VI
			// so result = V + I
			int current = get(arr[i]);
			int previous = get(arr[i + 1]);
			if (current < previous) {
				result -= current;
			} else {
				// greater than equal to
				result += current;
			}
		}
		System.out.println(result);
	}

	private static int get(char ch) {
		if (ch == 'I')
			return 1;
		else if (ch == 'V')
			return 5;
		else if (ch == 'X')
			return 10;
		else if (ch == 'L')
			return 50;
		else if (ch == 'C')
			return 100;
		else if (ch == 'D')
			return 500;
		else if (ch == 'M')
			return 1000;
		return 0;
	}

	private static void type1() {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		String s = "MCMXCIV";
		char[] arr = s.toCharArray();
		int n = arr.length;
		int seed = map.get(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			// if the number is IV
			// so result = V - I
			if (map.get(arr[i]) < map.get(arr[i + 1])) {
				seed -= map.get(arr[i]);
			} else {
				seed += map.get(arr[i]);
			}
		}
		System.out.println(seed);
	}

}

package problems.string;
/*
 * Problem link :
 * https://leetcode.com/problems/compare-version-numbers/
 * https://www.codingninjas.com/codestudio/problems/1062582?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * 
 * Solution link :
 * 
 * 
 */

public class CompareVersionNumber {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// same as previous one
	// just here we are using character array insted of string
	private static void type2() {
		System.out.println(compareVersion2("1.01", "1.001"));
	}

	private static int compareVersion2(String version1, String version2) {
		char[] arr1 = version1.toCharArray(), arr2 = version2.toCharArray();
		int i = 0, j = 0, n1 = arr1.length, n2 = arr2.length;
		int v1 = 0, v2 = 0;
		while (i < n1 || j < n2) {
			if (i < n1) {
				while (i < n1 && arr1[i] != '.') {
					v1 = v1 * 10 + (arr1[i++] - '0');
				}
				if (i < n1)
					i++;
			}
			if (j < n2) {
				while (j < n2 && arr2[j] != '.') {
					v2 = v2 * 10 + (arr2[j++] - '0');
				}
				if (j < n2)
					j++;
			}
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			}
			v1 = v2 = 0;
		}
		return 0;
	}

	// optimized approach
	private static void type1() {
		System.out.println(compareVersion1("1.01", "1.001"));
	}

	public static int compareVersion1(String version1, String version2) {
		String[] arr1 = version1.split("[.]"), arr2 = version2.split("[.]");
		int i = 0, n1 = arr1.length, n2 = arr2.length;
		int v1, v2;
		while (i < n1 || i < n2) {
			v1 = i < n1 ? Integer.parseInt(arr1[i]) : 0;
			v2 = i < n2 ? Integer.parseInt(arr2[i]) : 0;
			if (v1 > v2) {
				return 1;
			} else if (v1 < v2) {
				return -1;
			} else {
				i++;
			}
		}
		return 0;
	}
}

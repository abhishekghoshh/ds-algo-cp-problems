package string;

/*
 * Problem link : 
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * 
 * Solution link:
 * https://www.youtube.com/watch?v=ohBNdSJyLh8
 * https://www.youtube.com/watch?v=Rsq1ObYg6ak
 * 
 * */
public class IntegerToRoman {

	public static void main(String[] args) {
		type1();
	}

	// we have added all the points
	// and also some of the other points
	// We have some standard values that we will be adding
	// Symbol Value
	// I 1
	// V 5
	// X 10
	// L 50
	// C 100
	// D 500
	// M 1000
	// but apart from this we have to think about some other consideration
	// like for 4 the Roman representation is IV not IIII
	// so we have to add some the points in between
	// so for every point we will be adding one less than the number
	// like 4 for 5
	// 40 for 50
	// 90 for 100
	// 400 for 500
	private static Point[] points = { new Point("I", 1), new Point("IV", 4), new Point("V", 5), new Point("IX", 9),
			new Point("X", 10), new Point("XL", 40), new Point("L", 50), new Point("XC", 90), new Point("C", 100),
			new Point("C", 100), new Point("CD", 400), new Point("D", 500), new Point("CM", 900),
			new Point("M", 1000) };

	private static void type1() {
		int num = 2994;
		StringBuilder sb = new StringBuilder();
		for (int i = points.length - 1; i >= 0; i--) {
			if (points[i].value <= num) {
				for (int j = 0; j < num / points[i].value; j++) {
					sb.append(points[i].key);
				}
				num = num % points[i].value;
			}
		}
		System.out.println(sb);
	}

	private static class Point {
		public String key;
		public int value;

		public Point(String key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}

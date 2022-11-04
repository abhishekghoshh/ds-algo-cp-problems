package problems.bitmanipulation;

/*
 * Problem link :
 * 
 * 
 * Solution link :
 * 
 * 
 */
public class SwapTwoNumbers {

	public static void main(String[] args) {
		type1();
	}

	// let's day a =5 b=7
	// a = 5^7
	// b= 5^7^7 => 5
	// a = 5^7^5 => 7
	// swap two variables without using third variable
	private static void type1() {
		int a = 5, b = 7;
		System.out.println("a = " + a + " b = " + b);
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
		System.out.println("a = " + a + " b = " + b);
	}

}

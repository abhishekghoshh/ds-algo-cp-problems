package bitmanipulation;

public class ExtractTheRightMostSetBit {

	public static void main(String[] args) {
		type1();
		type2();
	}

	// optimized approach
	// time complexity O(1)
	// suppose n = 101100
	// so our ans will be 000100
	// this problem is similar to remove the last set bit
	// n-1 will be 101011
	// if we see here the bit in left is same in bit in right changes to 1
	// and the right most set bit became 0
	// if we reverse it then it will 010100
	// in ~(n-1) all bits are different except the right set bit
	// so if we so do a and operation then we will get our mask
	private static void type2() {
		int n = 104;
		int mask = n & (~(n - 1));
		System.out.println(mask);
	}

	// brute force approach
	// time complexity O(log(n))
	// suppose n = 101100
	// so our ans will be 000100
	// so we can create a mask and perform and operation until it's value become
	// other than 0
	private static void type1() {
		int n = 104;
		int mask = 1;
		while ((n & mask) == 0) {
			// we have not found the 1 bit yet
			// we have to go to left by one bit
			mask = mask << 1;
		}
		System.out.println(mask);
	}

}

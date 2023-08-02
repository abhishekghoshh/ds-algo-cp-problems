package array;
/*
 * problem link:
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * Solution link :
 * 
 * Blog :
 * 
 * */
public class ContainerWithMostWater {

	
	public static void main(String[] args) {
		type1();
		type2();
		
	}

	// TODO check it later
	// there is an greedy approach which can be achieved by next greater element technique
	private static void type2() {
		// TODO Auto-generated method stub
		
	}

	private static void type1() {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		int left = 0;
		int right = height.length - 1;
		int max = Integer.MIN_VALUE;
		while (left < right) {
			if (height[right] > height[left]) {
				max = Math.max(max, (right - left) * height[left]);
				left++;
			} else {
				max = Math.max(max, (right - left) * height[right]);
				right--;
			}
		}
		System.out.println(max);

	}

}

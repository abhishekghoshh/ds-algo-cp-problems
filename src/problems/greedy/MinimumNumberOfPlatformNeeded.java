package problems.greedy;

import java.util.Arrays;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/799400?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=dxVcMDI7vyI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=47
 * 
 * */
/*
 * Given arrival and departure times of all trains that reach a railway station.
 * Find the minimum number of platforms required for the railway station so that
 * no train is kept waiting. Consider that all the trains arrive on the same day
 * and leave on the same day. Arrival and departure time can never be the same
 * for a train but we can have arrival time of one train equal to departure time
 * of the other. At any given instance of time, same platform can not be used
 * for both departure of a train and arrival of another train. In such cases, we
 * need different platforms.
 */

public class MinimumNumberOfPlatformNeeded {
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int n = 6;
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		Arrays.sort(arr);
		Arrays.sort(dep);
	}

}

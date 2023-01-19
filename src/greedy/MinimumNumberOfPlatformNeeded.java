package greedy;

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
 * Link : https://takeuforward.org/data-structure/minimum-number-of-platforms-required-for-a-railway/
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
		type2();
	}

	// 2 pointer approach
	// time complexity O(2n*log(n))+O(2n)
	// space complexity O(1)
	// this is quite similar to n meeting problem
	// but there is an option to skip some of the meeting
	// as room size 1
	// but here we have to accommodate all the trains as we have n number of
	// platform
	// we have to make sure that no train collide
	private static void type2() {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = 6;
		// first we will sort the arriving train timings
		Arrays.sort(arr);
		// if we think closely at a certain point we just need what is the least
		// departure time of any train
		// that's why we also sort the departure timing
		// a train who is coming at 10 can only go after 10
		// so if a train arriving at 10.00 and departing at 18.00
		// and in arrival array and its index is 5,
		// in the departure array 18.00 index is 0
		// that means first train will be going at 18.00 and
		// for all 5 previous trains we have to allocate separate platform
		// and for this 6th train also
		Arrays.sort(dep);
		int arrivingTrain = 0, departingTrain = 0;
		// we are assuming that first train already arrived
		// and we need one platform right now
		arrivingTrain++;
		int platformNeeded = 1, maxPlatformNeed = 1;
		while (arrivingTrain < n && departingTrain < n) {
			if (arr[arrivingTrain] <= dep[departingTrain]) {
				// if the current train is arriving but the least train will be departing after
				// that or in that same time
				platformNeeded++;
				arrivingTrain++;
			} else {
				platformNeeded--;
				departingTrain++;
			}
			maxPlatformNeed = Math.max(maxPlatformNeed, platformNeeded);
		}
		// loop will stop when arrivingTrain = n
		// so we will not need any new platform
		System.out.println("max platform needed " + maxPlatformNeed);
	}

	private static void type1() {

	}
}

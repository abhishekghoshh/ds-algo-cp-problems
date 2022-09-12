package problems.greedy;

import java.util.Arrays;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/job-sequencing-problem_1169460?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48
 * 
 * */
public class JobSchedulingProblem {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		Job[] arr = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
		int n = arr.length;
		Arrays.sort(arr, (job1, job2) -> Integer.compare(job2.profit, job1.profit));
		int highestDeadline = 0;
		for (Job job : arr) {
			if (highestDeadline < job.deadline) {
				highestDeadline = job.deadline;
			}
		}
		boolean[] slots = new boolean[highestDeadline + 1];
		int profit = 0, deadline, jobsTaken = 0;
		for (int i = 0; i < n; i++) {
			deadline = arr[i].deadline;
			while (deadline >= 1 && slots[deadline]) {
				deadline--;
			}
			if (deadline != 0) {
				slots[deadline] = true;
				profit = profit + arr[i].profit;
				jobsTaken++;
			}
		}
		System.out.println("Jobs taken " + jobsTaken);
		System.out.println("profit is " + profit);
	}

	public static class Job {
		int id, deadline, profit;

		Job(int id, int deadline, int profit) {
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public String toString() {
			return "Job [id=" + id + ", profit=" + profit + ", deadline=" + deadline + "]";
		}
	}
}

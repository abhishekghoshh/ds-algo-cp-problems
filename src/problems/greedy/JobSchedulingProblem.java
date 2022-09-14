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

	// time complexity is O(n*log(n))+ O(n^2)
	// space complexity is O(n)
	private static void type1() {
		Job[] arr = { new Job(1, 4, 20), new Job(2, 1, 10), new Job(3, 1, 40), new Job(4, 1, 30) };
		int n = arr.length;
		// we will sort the jobs by their profit in descending
		// so the highest profit job can be taken at the first
		Arrays.sort(arr, (job1, job2) -> Integer.compare(job2.profit, job1.profit));
		// intuition is
		// if the job has a deadline k that means the job can be done at kth time or
		// less than that
		// but the will try to do that job at kth then 1..k-1 will be vacant
		// which can be filled by the later jobs
		// we are making sure that the higher profit jobs has the better chance of
		// picking than the lower profits
		// out of the all the jobs if a job has T deadline which is greater than all
		// others then at max we can take T jobs
		int maxDeadline = 0;
		for (Job job : arr) {
			if (maxDeadline < job.deadline) {
				maxDeadline = job.deadline;
			}
		}
		// for simplicity we are taking T+1
		// so that we don't have to think about 0 index
		boolean[] slots = new boolean[maxDeadline + 1];
		int profit = 0, deadline, jobsTaken = 0;
		for (int i = 0; i < n; i++) {
			deadline = arr[i].deadline;
			// we can take the job if that time slot is vacant if false
			// we are checking that from the deadline'th time to 1th time if there is any
			// vacant slot
			while (deadline >= 1 && slots[deadline]) {
				deadline--;
			}
			// if deadline is not 0 then we have a vacant position to fill in
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
		int jobId, deadline, profit;

		Job(int id, int deadline, int profit) {
			this.jobId = id;
			this.deadline = deadline;
			this.profit = profit;
		}

		@Override
		public String toString() {
			return "Job [jobId=" + jobId + ", profit=" + profit + ", deadline=" + deadline + "]";
		}
	}
}

# ShortestJobFirstSchedulingAlgorithm

**Topic:** `greedy`  

## 🔗 Problem Links

- [📄 Coding Ninjas](https://www.codingninjas.com/studio/problems/sjf_1172165)

## 🎥 Solution Links

- [▶ YouTube](https://www.youtube.com/watch?v=9PDUOx4MtKo)
- [📄 GeeksforGeeks](https://www.geeksforgeeks.org/program-for-shortest-job-first-or-sjf-cpu-scheduling-set-1-non-preemptive/)

## 📝 Problem Statement

Implement Shortest Job First CPU scheduling.

## 💡 Approaches

This problem can be solved in **2** different ways, each improving upon the previous:

### Approach 2: 🏆 Optimal Solution

optimized approach this can be improved if we store the index alongside, then we can get the jobs sequence also jobs will be sorted by their arrival time then their burst time min heap will be used to get the jobs by their burst time we are starting the clock from the arrival of the first job the clock will be started from the arrival of the first job and the wait time is initialized from 0 we poll the job with the least burst time total wait time will be current time - job's arrival time now the current time will be current time + job's burst time we start from the last job and go till the job's arrival time is less than the current time there can be one edge case here that is if the remaining jobs are coming pretty late then our program will not go to this loop to avoid this edge case we can initialize the current time with the next jobs we can code it like this i is not equal to n that mean we have not gone till last item still the queue is empty so we will take the next job from array and initialize the current time with the arrival time of the ne

```java
    private static void type2() {
        int n = 3;
        int[] arrivalTime = {0, 0, 0};
        int[] burstTime = {3, 1, 2};
        int[][] jobs = new int[n][2];
        // if we store the index alongside, then we can get the jobs sequence also
        for (int i = 0; i < n; i++) {
            jobs[i][0] = arrivalTime[i];
            jobs[i][1] = burstTime[i];
        }
        // jobs will be sorted by their arrival time then their burst time
        Arrays.sort(jobs, (j1, j2) -> {
            if (j1[0] != j2[0]) return Integer.compare(j1[0], j2[0]);
            return Integer.compare(j1[1], j2[1]);
        });
        // min heap will be used to get the jobs by their burst time
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(j -> j[1]));
        int i = 0;
        // we are starting the clock from the arrival of the first job
        int[] job = jobs[i++];
        minHeap.offer(job);
        // the clock will be started from the arrival of the first job
        int currentTime = job[0];
        // and the wait time is initialized from 0
        int totalWaitTime = 0;
        while (!minHeap.isEmpty()) {
            // we poll the job with the least burst time
            job = minHeap.poll();
            // total wait time will be current time - job's arrival time
            totalWaitTime += currentTime - job[0];
            // now the current time will be current time + job's burst time
            currentTime += job[1];
            // we start from the last job
            // and go till the job's arrival time is less than the current time
            for (; i < n && currentTime >= jobs[i][0]; i++)
                minHeap.offer(jobs[i]);
            // there can be one edge case here that is if the remaining jobs are coming
            // pretty late then our program will not go to this loop
            // to avoid this edge case we can initialize the current time with the next jobs
            // arrival time
            // we can code it like this
            // i is not equal to n that mean we have not gone till last item
            // still the queue is empty
            // so we will take the next job from array
            // and initialize the current time with the arrival time of the ne
            if (i != n && minHeap.isEmpty()) {
                job = jobs[i++];
                minHeap.offer(job);
                currentTime = job[0];
            }
        }
        float averageWaitTime = ((float) totalWaitTime) / n;
        System.out.println(averageWaitTime);

    }
```

### Approach 1: 🔨 Brute Force

brute force approach

```java
    private static void type1() {
        int n = 3;
        int[] arrivalTime = {0, 0, 0};
        int[] burstTime = {3, 1, 2};

    }
}
```

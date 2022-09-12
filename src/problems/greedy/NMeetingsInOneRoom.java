package problems.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/1062658?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=II6ziNnub1Q&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=46
 * 
 * */

/* 
 * There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) where start[i] 
 * is start time of meeting i and end[i] is finish time of meeting i.What is the maximum number of meetings 
 * that can be accommodated in the meeting room when only one meeting can be held in the meeting room at a particular time?
 * 
 * Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
 * */
public class NMeetingsInOneRoom {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int end[] = { 2, 4, 6, 7, 9, 9 };
		List<Meeting> meetings = new ArrayList<>();
		for (int i = 0; i < start.length; i++) {
			meetings.add(new Meeting(start[i], end[i]));
		}
		Collections.sort(meetings, Comparator.comparing(Meeting::end));
		int count = 1, endTime = meetings.get(0).end;
		for (int i = 1; i < meetings.size(); i++) {
			if (endTime < meetings.get(i).start) {
				count++;
				endTime = meetings.get(i).end;
			}
		}
		System.out.println("Total meeting count is " + count);
	}

	private static class Meeting {
		public int start;
		public int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int end() {
			return this.end;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
	}
}

package problems.binarysearch;

import java.util.List;

/*
 * Problem link : 
 * https://www.codingninjas.com/codestudio/problems/ayush-gives-ninjatest_1097574?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://www.interviewbit.com/problems/allocate-books/
 * 
 * Solution is :
 * https://www.youtube.com/watch?v=gYmWHvRHu-s&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=70
 * https://www.youtube.com/watch?v=2JSQIhPcHQg
 * https://takeuforward.org/data-structure/allocate-minimum-number-of-pages/
 * */
public class MinimumNumberOfPages {

	public static void main(String[] args) {
		type1();

	}

	private static void type1() {
		List<Integer> A = List.of(97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53,
				8, 44, 68, 90, 24);
		int B = 26;
		if (B > A.size())
			return;
		// at max one can take all the books so high will be sum of pages of all books
		// at min one can take only one book but if anyone is taking one book then also
		// one has to take the book with highest number of pages, so our low will be
		// maxPage(book)
		int low = Integer.MIN_VALUE;
		int high = 0;
		for (int item : A) {
			low = Math.max(low, item);
			high = high + item;
		}
		int answer = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			// we are checking that if mid number of pages can be allocated to all the
			// students or not, if possible then we are reducing our search space, but mid
			// is also one answer
			if (isValid(A, B, mid)) {
				answer = mid;
				high = mid - 1;
			} else {
				// if mid number pages can not be allocated then we have to increase the umber
				// of pages, so we are changing our low to mid+1
				low = mid + 1;
			}
		}
		System.out.println(answer);
	}

	private static boolean isValid(List<Integer> A, int students, int maxPages) {
		// we are initializing our students as 1 as we are starting with our first
		// student
		int studentsCalculated = 1;
		int sum = 0;
		for (int i = 0; i < A.size(); i++) {
			// if the student is able to take the book then we are giving
			if (sum + A.get(i) <= maxPages) {
				sum = sum + A.get(i);
			} else {
				// the student is unable to take the book
				// so we are giving the book t
				sum = A.get(i);
				studentsCalculated++;
			}
		}
		// this should be studentsCalculated == students
		// as all students have to have atleast one book
		return studentsCalculated <= students;
	}

}

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
			// we don't have enough book to give one book to every person
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
			int isValid = isValid(A, B, mid);
			if (isValid == 0) {
				answer = mid;
				high = mid - 1;
			} else if (isValid == 1) {
				high = mid - 1;
			} else {
				// if mid number pages can not be allocated then we have to increase the number
				// of pages, so we are changing our low to mid+1
				low = mid + 1;
			}
		}
		// the answer is -1 means we can not allocate low number of pages to everyone
		// but we have more books than students so we can allocate one book to every
		// person, so can give books to every person at least but the sum of the pages
		// of any individual will not exceed 97, otherwise answer will not be -1
		// we can give the book with 97 pages to anyone and rest of the books to give
		// simultaneously, so the maximum number of pages,that can be allocated will be
		// 97 (highest number of books or low variable)
		if (answer == -1)
			answer = low;
		System.out.println(answer);
	}

	private static int isValid(List<Integer> A, int students, int maxPages) {
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
				// so we are giving the book to a new student
				sum = A.get(i);
				studentsCalculated++;
			}
		}
		if (studentsCalculated == students) {
			return 0;
		} else if (studentsCalculated < students) {
			return 1;
		} else {
			return -1;
		}
	}

}

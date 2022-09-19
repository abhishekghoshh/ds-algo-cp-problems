package problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem links:
 * 
 * 
 * Solution link
 * https://www.youtube.com/watch?v=ULUNeD0N9yI&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=19
 * 
 * https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/discuss/1152474/Josephus-Problem
 * */
public class JosephusProblem {

	/*
	 * There are n people standing in a circle waiting to be executed. The counting
	 * out begins at some point in the circle and proceeds around the circle in a
	 * fixed direction. In each step, a certain number of people are skipped and the
	 * next person is executed. The elimination proceeds around the circle (which is
	 * becoming smaller and smaller as the executed people are removed), until only
	 * the last person remains, who is given freedom. Given the total number of
	 * person n and a number k which indicates that k-1 persons are skipped and the
	 * kth person is killed in a circle. The task is to choose the place in the
	 * initial circle so that you are the last one remaining and so survive. For
	 * example, if n = 5 and k = 2, then the safe position is 3. Firstly, the person
	 * at position 2 is killed, then the person at position 4 is killed, then the
	 * person at position 1 is killed. Finally, the person at position 5 is killed.
	 * So the person at position 3 survives. If n = 7 and k = 3, then the safe
	 * position is 4. The persons at positions 3, 6, 2, 7, 5, and 1 are killed in
	 * order, and the person at position 4 survives.
	 */
	public static void main(String[] args) {
		type1();
		type2();

	}

	/*
	 * The problem has the following recursive structure.
	 * 
	 * josephus(n, k) = (josephus(n - 1, k) + k-1) % n + 1 josephus(1, k) = 1 After
	 * the first person (kth from the beginning) is killed, n-1 persons are left. So
	 * we call Josephus(n – 1, k) to get the position with n-1 persons. But the
	 * position returned by Josephus(n – 1, k) will consider the position starting
	 * from k%n + 1. So, we must make adjustments to the position returned by
	 * Josephus(n – 1, k).
	 */
	private static void type2() {
		int n = 7;
		int k = 3;
		System.out.println("The chosen place is " + findWinner(n, k));
	}

	static int findWinner(int n, int k) {
		if (n == 1) {
			return 1;
		} else {
			/*
			 * The position returned by josephus(n - 1, k) is adjusted because the recursive
			 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
			 */
			return (findWinner(n - 1, k) + k - 1) % n + 1;
		}
	}

	// time complexity O(n^2)
	// space complexity O(n)
	private static void type1() {
		int n = 7;
		int k = 3;
		List<Integer> alivePersons = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			alivePersons.add(i);
		}
		int index = findWinner(alivePersons, k, 0);
		System.out.println(index);
	}

	private static int findWinner(List<Integer> alivePersons, int k, int start) {
		if (alivePersons.size() == 1) {
			return alivePersons.get(0);
		}
		start = (start + k - 1) % alivePersons.size();
		alivePersons.remove(start);
		return findWinner(alivePersons, k, start);

	}

}

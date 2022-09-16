package problems.recursion;

public class TowerOfHanoi {
	/*
	 * Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and
	 * C) and N disks. Initially, all the disks are stacked in decreasing value of
	 * diameter i.e., the smallest disk is placed on the top and they are on rod A.
	 * The objective of the puzzle is to move the entire stack to another rod (here
	 * considered C), obeying the following simple rules: (1)Only one disk can be
	 * moved at a time. (2)Each move consists of taking the upper disk from one of
	 * the stacks and placing it on top of another stack i.e. (3)a disk can only be
	 * moved if it is the uppermost disk on a stack. (4)No disk may be placed on top
	 * of a smaller disk.
	 */
	public static void main(String[] args) {
		type1();
	}

	// Our job is to move n disk from A disk to B disk and we have one extra C disk
	// we can divide the task in three parts
	// first move the n-1 from A -> C
	// then move nth disk from A-> B
	// then move that n-1 disks from C->B
	// time complexity is O(2^n)
	private static void type1() {
		int totalDisks = 3;
		char from_disk = 'A';
		char to_disk = 'B';
		char extra_disk = 'C';
		shift(totalDisks, from_disk, to_disk, extra_disk);
	}

	private static void shift(int totalDisks, char from_disk, char to_disk, char extra_disk) {
		// if there is no disk to move
		if (totalDisks == 0) {
			return;
		}
		// move the n-1 from A -> C
		shift(totalDisks - 1, from_disk, extra_disk, to_disk);
		// move nth disk from A-> B
		System.out.println(String.format("Moving %dth disk from %c disk to %c disk", totalDisks, from_disk, to_disk));
		// move that n-1 disks from C->B
		shift(totalDisks - 1, extra_disk, to_disk, from_disk);
	}

}

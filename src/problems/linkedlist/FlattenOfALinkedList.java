package problems.linkedlist;

/*
 * 
 * problem links :
 * https://www.codingninjas.com/codestudio/problems/1112655?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
 * https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
 * 
 * Solution video :
 * https://www.youtube.com/watch?v=ysytSSXpAI0&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=39
 * 
 * Read 
 * https://www.geeksforgeeks.org/flattening-a-linked-list/
 * */
public class FlattenOfALinkedList {

	public static void main(String[] args) {
		type1();
		type2();
		type3();
	}

	// using priority queue
	// same approach used in merge K sorted list into one list
	// time complexity O(n*m*log(n))
	// space complexity O(n) for priority queue
	private static void type3() {

	}

	// merge approach
	// recursively merge last and second last then merge it to previous and the
	// process goes on
	// let's say there is n right nodes and on each m bottom nodes
	// total time complexity O(n*n*m)
	// space complexity O(1)
	private static void type2() {

	}

	// brute force approach
	// let's say there is n right nodes and on each m bottom nodes
	// O(n*m) to put it in array
	// O((n*m)log(n*m)) to sort the array
	// O(n*m) to create new linked list
	// total time complexity
	private static void type1() {

	}

}

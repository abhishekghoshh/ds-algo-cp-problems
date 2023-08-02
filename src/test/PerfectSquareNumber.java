package test;

import java.util.Scanner;

public class PerfectSquareNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		
		int x =(int) Math.ceil((double)(n/m)) * b;
		
		System.out.println(x);
		
	}

	/*
	 * 
	 * Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int sqrt = (int) Math.sqrt(i);
			if (sqrt * sqrt == i) {
				count++;
			}
		}
		System.out.println(count);
	 * 
	 * */
}

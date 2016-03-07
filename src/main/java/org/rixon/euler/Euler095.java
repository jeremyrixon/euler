package org.rixon.euler;

public class Euler095 {
	public static int N = 1000001;
	public static int[] nexts = new int[N];
	
	public static void main(String[] args) {
		for (int i = 1; i < N; i++) {
			int n = amicableStep(i);
			if (n < N) {
				nexts[i] = n;
			}
		}
		System.out.println("Done precalculating");

		int longestLength = 0;
		int answer = 0;
		
		for (int i = 2; i < N; i++) {
			int current = i;
			for (int length = 1; length < 100; length++) {
				current = nexts[current];
				if (current == i) {
					if (length > longestLength) {
						longestLength = length;
						answer = i;
						System.out.println(i + " " + length);
					}
					break;
				}
			}
		}
	}
	
	static int amicableStep(int n) {
		int sum = 0;
		for (int l: Util.properDivisors(n)) {
			sum += l;
		}
		return sum;
	}
}

package org.rixon.euler;

public class Euler079 {
	static final int N = 1000000;
	static final int M = N * 3;
	
	static int[] factorials = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 }; 
	static int[] m = new int[M];
	
	public static void main(String[] args) {

		for (int i = 1; i <= 3; i++) {
			findLoops(i);
		}
		
		int updates = 1;
		while (updates > 0) {
			updates = 0;
			for (int i = 2; i < M; i++) {
				if (m[i] == 0) {
					int f = sumOfFactorialsOfDigits(i);
					if (f < M && m[f] > 0) {
						m[i] = m[f] + 1;
						updates++;
					}
				}
			}
		}

		
		for (int j = 0; j < 100; j++) {
			int count = 0;
			for (int i = 2; i < N; i++) {
				if (m[i] == j) {
					count++;
				}
			}
			System.out.format("%5d %7d%n",j, count);
		}
		
	}
	
	private static void findLoops(int n) {
		for (int i = 2; i < M; i++) {
			if (m[i] == 0) {
				int cc = i;
				for (int j = 0; j < n; j++) {
					cc = sumOfFactorialsOfDigits(cc);
				}
				if (cc == i) {
					m[i] = n;
					System.out.format("%d %d%n",i, n);
				}
			}
		}
	}

	
	public static int sumOfFactorialsOfDigits(int n) {
		int sum = 0;
		while (n > 0) {
			sum += factorials[n % 10];
			n /= 10;
		}
		return sum;
	}

}

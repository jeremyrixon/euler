package org.rixon.euler;

public class Euler078 {
	
	static final int N = 100000;
	
	static final int[][] cache = new int[N][];

	public static void main(String[] args) {
		for (int m = 1; m < N; m++) {
			cache[m] = new int[m + 1];
			cache[m][1] = 1;
			for (int n = 2; n < m; n++) {
				cache[m][n] = (cache[m][n-1] + cache[m-n][n < m-n ? n : m-n]) % 1000000;
			}
			cache[m][m] = (cache[m][m-1] + 1) % 1000000;
			if (cache[m][m] == 0) {
				System.out.format("%7d %20d%n", m, cache[m][m]);
			}
		}
	}
	
	
	public static void main1(String[] args) {
		for (int m = 1; m < N; m++) {
			cache[m] = new int[m + 1];
			cache[m][1] = 1;
			for (int n = 2; n < m; n++) {
				cache[m][n] = cache[m][n-1] + cache[m-n][n < m-n ? n : m-n];
			}
			cache[m][m] = cache[m][m-1] + 1;
		}
		for (int m = 1; m < N; m++) {
			System.out.format("%7d %20d%n", m, cache[m][m]);
		}
	}
}

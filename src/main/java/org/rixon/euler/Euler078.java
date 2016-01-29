package org.rixon.euler;

public class Euler078 {
	
	public static void main(String[] args) {
		for (long n = 2; n < 1000; n++) {
			System.out.format("%5d %5d%n", n, countRemaining(n, n));
		};
	}

	private static long countRemaining(long n, long m) {
		if (m > n) {
			m = n;
		}
		if (m <= 1) {
			return 1;
		}
		if (m == 2) {
			return n / 2 + 1;
		}

		int count = 0;
		for (long i = m; i >= 1; i--) {
			count += countRemaining(n - i, i);
		}
		return count;
	}
	
}

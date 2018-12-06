package org.rixon.euler;

public class Euler145 {
	private static long N = 1000000000;

	public static void main(String[] args) {
		long count = 0;
		for (long i = 10; i < N; i++) {
			if (i % 10 != 0) {
				long j = i;
				long k = 0;
				while (j > 0) {
					k = k * 10 + j % 10;
					j /= 10;
				}
				long l = i + k;
				long m = l;
				boolean odd = true;
				while (m > 0) {
					if (m % 2 == 0) {
						odd = false;
						break;
					}
					m /= 10;
				}
				if (odd) {
					count++;
					System.out.format("%10d %10d %10d %10d%n", count, i, k, l);
				}
			}
		}
	}
}

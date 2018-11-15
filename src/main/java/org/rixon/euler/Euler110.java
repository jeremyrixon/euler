package org.rixon.euler;

public class Euler110 {
	public static void main(String[] args) {
		long[] primes = new long[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41 };
		long max = 0;
		long n = 1;
		for (int p = 0; p < primes.length; p++) {
			n *= primes[p];
			long count = 0;
			for (long x = n + 1; x <= n * 2; x++) {
				if ((n * x) % (x - n) == 0) {
					count++;
				}
			}
			if (count > max) {
				max = count;
				System.out.format("n=%d solutions=%d%n",n,count);
			}
		}
	}
}

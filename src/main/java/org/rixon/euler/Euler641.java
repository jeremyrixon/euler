package org.rixon.euler;

public class Euler641 {
	public static void main(String[] args) {
		for (int i = 1; i < 100000001; i++) {
			long c = divisorCount(i);
			if (c % 6 == 1) {
				System.out.format("Number of divisors of %6d is %6d%n", i, divisorCount(i));
			}
		}
	}

	public static long divisorCount(long n) {
		if (n == 1) return 1;
		long count = 2;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				count++;
			}
		}
		return count;
	}

}

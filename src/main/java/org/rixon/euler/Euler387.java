package org.rixon.euler;

public class Euler387 {
	private static long N = 10000000000l;
	private static org.rixon.primes.Sieve sieve = new org.rixon.primes.Sieve(N);

	public static void main(String[] args) {

		for (long i = 1; i < 10; i++) {
			harshad(i, i);
		}
	}

	private static void harshad(long h, long s) {
		if (h < N && h % s == 0) {
			if (sieve.isPrime(h/s)) {
				System.out.println(h);
			}
			for (long i = 0; i < 10; i++) {
				harshad(h * 10 + i, s + i);
			}
		}
	}
}

package org.rixon.euler;

public class Euler046 {

	public static void main(String[] args) {
		Primes primes = new Primes();
		for(long n = 9; ; n += 2) {
			if (!primes.isPrime(n)) {
				if (!goldbach2(primes, n)) {
					System.out.println(n);
				}
			}
		}
	}

	private static boolean goldbach2(Primes primes, long n) {
		for (long s = 1; 2 * s * s < n; s++) {
			if (primes.isPrime(n - 2 * s * s)) {
				return true;
			}
		}
		return false;
	}
}

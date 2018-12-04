package org.rixon.euler;

public class Euler357 {
	private static Primes p = new Primes();
	public static void main(String[] args) {
		Primes p = new Primes();
		long sum = 0;
		for (long i = 1; i <= 100000000; i++) {
			if (test(i)) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

	public static boolean test(long n) {
		if (!p.isPrime(n+1)) {
			return false;
		}
		for (long i = 2; i * i <= n; i++) {
			if (i * i == n) {
				return false;
			}
			if (n % i == 0 && !p.isPrime(i + n / i)) {
				return false;
			}
		}
		return true;
	}

}

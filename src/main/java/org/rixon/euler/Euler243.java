package org.rixon.euler;

public class Euler243 {
	
	public static void main(String[] args) {
		int N = 1000000000;
		int[] primes = new Sieve(N).getPrimes();
		double lowest = 1;
		double target = 15499d / 94744d;
		for (int d = 2310; d <= N; d+=2310) {
			int numerator = Util.totient(d, primes);
			int denominator = d - 1;
			double r = numerator / (double) denominator;
			if (r < lowest) {
				lowest = r;
				System.out.format("%12d/%12d %f %f %b %12d%n", numerator, denominator, r, target, r < target, denominator+1);
			}
		}
	}
}

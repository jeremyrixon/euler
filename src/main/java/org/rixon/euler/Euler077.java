package org.rixon.euler;

public class Euler077 {
	
	public static void main(String[] args) {
		int N = 100;
		int[] primes = new Sieve(N).getPrimes();
		
		for (int n = 4; n < N; n++) {
			int maxPrimeIdx = Util.highestPrimeEqualOrLower(n - 1, primes);
			int count = count(n, maxPrimeIdx, primes);
			System.out.format("%5d %5d%n",n, count);
		}
	}

	private static int count(int n, int maxPrimeIdx, int[] primes) {
		int count = 0;
		for (; maxPrimeIdx >= 0; maxPrimeIdx--) {
			int prime = primes[maxPrimeIdx];
			if (prime == n) {
				count++;
			} else {
				if (prime < n) {
					count += count (n - prime, maxPrimeIdx, primes);
				}
			}
		}
		return count;
	}
	
}

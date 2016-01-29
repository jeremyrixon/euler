package org.rixon.euler;

public class Euler071 {
	private static final int N = 8;
	private static final int[] primes = new Sieve(N).getPrimes();
	
	public static void main(String[] args) {
		final int MAXFACTORS = 20;
		long count = countAll(new int[MAXFACTORS], 0, 1);
		System.out.println(count);
	}


	private static long countAll(int[] factors, int numfactors, long currentProduct) {
		long count = 0;
		int maxPrime = numfactors == 0 ? primes[primes.length - 1] : factors[numfactors - 1];
		for (int prime: primes) {
			if (prime > maxPrime || currentProduct * prime > N) {
				break;
			}
			count += prime - 1;
			if (numfactors < factors.length - 1) {
				factors[numfactors] = prime;
				count += countAll(factors, numfactors + 1, currentProduct * prime);
			}
		}
		return count;
	}
}

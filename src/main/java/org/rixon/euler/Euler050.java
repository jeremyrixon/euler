package org.rixon.euler;

public class Euler050 {
	
	public static void main(String[] args) {
		Primes primes = new Primes();
		final int max = 1000000;
		final int maxPrime = primes.getHighestPrimeEqualOrBelow(max);

		long maxPrimeSum = 0;
		int maxCount = 0;
		
		for (int a = 1; a < maxPrime; a++) {
			long sum = 0;
			int count = 1;
			for (int i = a; i <= maxPrime; i++) {
				sum += primes.getPrime(i);
				if (sum > max) {
					continue;
				}
				if (primes.isPrime(sum) && count > maxCount) {
					maxPrimeSum = sum;
					maxCount = count;
					System.out.println(maxPrimeSum + " " + maxCount);
				}
				count++;
			}
		}
	}
}

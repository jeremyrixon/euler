package org.rixon.primes;

public class Sieve {
	WheelBitSet primes;
	long size;

	public Sieve(long size) {
		this.size = size;
		primes = new WheelBitSet();
		sieve();
	}
	
	public boolean isPrime(long n) {
		return primes.get(n);
	}

	private void sieve() {
		for (long s = 11; s * s < size; s++) {
			if (primes.get(s)) {
				for (long t = s * 2; t < size; t += s) {
					primes.clear(t);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 10000000;
		long start = System.nanoTime();
		Sieve s = new Sieve(n);
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (s.isPrime(i)) {
				count++;
			}
		}
		long finish = System.nanoTime();
		
		System.out.format("%n%d %d%n", count, (finish - start) / 1000000);
	}

	public long nextPrime(long n) {
		return primes.nextPrime(n);
	}
}

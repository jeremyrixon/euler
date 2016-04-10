package org.rixon.primes;

public class Sieve {
	WheelBitSet primes;
	int size;

	public Sieve(int size) {
		this.size = size;
		primes = new WheelBitSet(size);
		sieve();
	}
	
	public boolean isPrime(int n) {
		return primes.get(n);
	}

	private void sieve() {
		for (int s = 5; s * s < size; s++) {
			if (primes.get(s)) {
				for (int t = s * 2; t < size; t += s) {
					primes.clear(t);
				}
			}
		}
	}

	public static void main(String[] args) {
		int n = 10000000;
		Sieve s = new Sieve(n);
		for (int i = 1; i < n; i++) {
			if (s.isPrime(i)) {
				System.out.format("%4d\n", i);
			}
		}
	}
}

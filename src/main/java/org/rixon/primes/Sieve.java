package org.rixon.primes;

public class Sieve {
	WheelBitSet primes;
	int size;

	public Sieve(int size) {
		this.size = size;
		primes = new WheelBitSet();
		sieve();
	}
	
	public boolean isPrime(int n) {
		return primes.get(n);
	}

	private void sieve() {
		for (int s = 11; s * s < size; s++) {
			if (primes.get(s)) {
				for (int t = s * 2; t < size; t += s) {
					primes.clear(t);
				}
			}
		}
		//primes.printWheel();
		//primes.printBits();
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
}

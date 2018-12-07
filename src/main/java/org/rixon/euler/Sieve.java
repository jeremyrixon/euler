package org.rixon.euler;
import java.util.BitSet;

public class Sieve {
	BitSet composites;
	int size;

	public Sieve(int size) {
		this.size = size;
		composites = new BitSet(size);
		sieve();
	}
	
	public boolean isPrime(int n) {
		return !composites.get(n);
	}

	private void sieve() {
		composites.set(0);
		composites.set(1);
		for (int s = 2; s * s < size; s++) {
			if (!composites.get(s)) {
				for (int t = s * 2; t < size; t += s) {
					composites.set(t);
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

	public int[] getPrimes() {
		int n = size - composites.cardinality();
		int[] primes = new int[n];
		int p = 0;
		for (int i = 2; i < size; i++) {
			if (!composites.get(i)) {
				primes[p++] = i;
			}
		}
		return primes;
		
	}

	public int nextPrime(int p) {
		return composites.nextClearBit(p);
	}
}

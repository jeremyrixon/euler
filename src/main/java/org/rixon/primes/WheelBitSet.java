package org.rixon.primes;

import java.util.Arrays;
import java.util.BitSet;

public class WheelBitSet {
	int wheelSize;
	short wheelInnerSize;
	BitSet composites;
	short[] lookup;
	long[] primes;

	public WheelBitSet() {
		this(2, 3, 5, 7, 11);
	}

	public WheelBitSet(long... primes) {
		this.primes = primes;
		composites = new BitSet();
		wheelSize = 1;
		for (long prime: primes) {
			wheelSize *= prime;
		}
		lookup = new short[wheelSize];
		lookup[0] = -1;
		for (long prime: primes) {
			for (long p = prime; p < wheelSize; p += prime) {
				lookup[(int)p] = -1;
			}
		}
		wheelInnerSize = 0;
		for (int n = 0; n < wheelSize; n++) {
			if (lookup[n] == 0) {
				lookup[n] = wheelInnerSize++;
			}
		}
		System.out.format("Outer: %d, Inner: %d, Percentage: %f%n", wheelSize, wheelInnerSize, wheelInnerSize * 100f / wheelSize);
	}


	public boolean get(long n) {
		if (n <= primes[primes.length - 1]) {
			return Arrays.binarySearch(primes, n) >= 0;
		}
		int l = lookup[(int)(n % wheelSize)];
		return l == -1 ? false : !composites.get((int)(n / wheelSize * wheelInnerSize + l));
	}

	public void clear(long n) {
		int l = lookup[(int)(n % (long)wheelSize)];
		if (l != -1) {
			composites.set((int)(n / wheelSize * wheelInnerSize + l));
		}
	}

	public long nextPrime(long n) {
		if (n < primes[primes.length - 1]) {
			for (int i = 0; i < primes.length - 1; i++) {
				if (primes[i] > n) {
					return primes[i];
				}
			}
		}
		for (; ; n++) {
			int l = lookup[(int)(n % wheelSize)];
			if (l != -1 && !composites.get((int)(n / wheelSize * wheelInnerSize + l))) {
				return n;
			}
		}
	}
}

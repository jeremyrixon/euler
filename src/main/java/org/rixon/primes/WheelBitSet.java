package org.rixon.primes;

import java.util.Arrays;
import java.util.BitSet;

public class WheelBitSet {
	int wheelSize;
	short wheelInnerSize;
	BitSet composites;
	short[] lookup;
	int[] primes;

	public WheelBitSet() {
		this(2, 3, 5, 7, 11);
	}

	public WheelBitSet(int... primes) {
		this.primes = primes;
		composites = new BitSet();
		wheelSize = 1;
		for (int prime: primes) {
			wheelSize *= prime;
		}
		lookup = new short[wheelSize];
		lookup[0] = -1;
		for (int prime: primes) {
			for (int p = prime; p < wheelSize; p += prime) {
				lookup[p] = -1;
			}
		}
		wheelInnerSize = 0;
		for (int n = 0; n < wheelSize; n++) {
			if (lookup[n] == 0) {
				lookup[n] = wheelInnerSize++;
			}
		}
		System.out.format("Outer: %d, Inner: %d, Percentage: %f%n", wheelSize, wheelInnerSize, wheelInnerSize * 100f / wheelSize);

//		for(int n = 1; n < wheelSize; n++) {
//			System.out.format("%6d : %6d  ---  %6d : %6d%n", n, lookup[n], wheelSize - n, lookup[wheelSize - n]);
//		}
	}
	
	
	public boolean get(int n) {
		if (n <= primes[primes.length - 1]) {
			return Arrays.binarySearch(primes, n) >= 0;
		}
		int l = lookup[n % wheelSize];
		return l == -1 ? false : !composites.get(n / wheelSize * wheelInnerSize + l);
	}

	public void clear(int n) {
		int l = lookup[n % wheelSize];
		if (l != -1) {
			composites.set(n / wheelSize * wheelInnerSize + l);
		}
	}
	
	public static void main(String[] argv) {
		WheelBitSet w = new WheelBitSet();
	}

	public void printBits() {
		for (int i = 0; i < wheelInnerSize; i++) {
			System.out.print(composites.get(i) ? '0' : '1');
		}
		System.out.println();
	}

	public void printWheel() {
		System.out.println(Arrays.toString(lookup));
	}
}

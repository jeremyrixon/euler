package org.rixon.euler;

import java.util.BitSet;

public class Euler087 {

	public static void main(String[] args) {
		int N = 50000000;
		int[] primes = new Sieve(N).getPrimes();
		BitSet bs = new BitSet(N);
		
		for (int i2 = 0, j2 = primes[i2] * primes[i2]; j2 < N; i2++, j2 = primes[i2] * primes[i2]) {
			for (int i3 = 0, j3 = primes[i3] * primes[i3] * primes[i3]; j2 + j3 < N; i3++, j3 = primes[i3] * primes[i3] * primes[i3]) {
				for (int i4 = 0, j4 = primes[i4] * primes[i4] * primes[i4] * primes[i4]; j2 + j3 + j4 < N; i4++, j4 = primes[i4] * primes[i4] * primes[i4] * primes[i4]) {
					bs.set(j2 + j3 + j4);
				}	
			}
		}
		System.out.println(bs.cardinality());
	}
}

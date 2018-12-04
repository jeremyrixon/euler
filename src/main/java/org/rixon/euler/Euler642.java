package org.rixon.euler;

import java.util.Arrays;

public class Euler642 {
	public static void main(String[] args) {
		long start = System.nanoTime();

		final int N  = 100;
		final int[] primes = new int[] {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};

		final int[] factors = new int[primes.length];
		factors[0]=1;

		for (int i = 0; i < 100; i++) {
			System.out.format("%s %d%n", Arrays.toString(factors), value(factors, primes));
			inc(factors);
		}

		long duration = System.nanoTime() - start;
		System.out.println(duration / 1E9);
	}

	public static int exp(int base, int exponent) {
		int result = 1;

		while(exponent > 0) {
			if ((exponent & 1l) == 1l) {
				result = result * base;
			}
			base = base * base;
			exponent >>= 1;
		}
		return result;
	}

	private static void inc(int[] factors) {
		for(int i = 0; i < factors.length - 1; i++) {
			if (factors[i] <= factors[i+1]) {
				factors[i]++;
				return;
			} else {
				factors[i] = 0;
			}
		}
	}

	public static long value(int[] factors, int[] primes) {
		long v = 1;
		for (int i = 0; i < factors.length; i++) {
			if (factors[i] > 0) {
				v *= exp(primes[i], factors[i]);
			}
		}
		return v;
	}


}

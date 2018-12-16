package org.rixon.euler;

import java.math.BigInteger;
import java.util.Arrays;

public class Euler110 {

	static int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
	static BigInteger[] primesbi = new BigInteger[primes.length];
	static {
		for (int i = 0; i < primes.length; i++) {
			primesbi[i] = BigInteger.valueOf(primes[i]);
		}
	}

	public static void main(String[] args) {
		print(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
		print(new int[] { 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0});
		print(new int[] { 8, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0});
		print(new int[] {10, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0});
		print(new int[] { 5, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0});
		print(new int[] { 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0});
		print(new int[] { 3, 3, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0});
	}

	private static void print(int[] b) {
		System.out.format("%40s %10d %s%n", toString(b), tau(b), Arrays.toString(b));
	}

	static long tau(int[] factors) {
		long tau = 1;
		for (int f: factors) {
			tau *= f * 2 + 1;
		}
		return tau;
	}

	static BigInteger toBigInteger(int[] factors) {
		BigInteger b = BigInteger.ONE;
		for (int i = 0; i < factors.length && i < primes.length; i++) {
			b = b.multiply(primesbi[i].pow(factors[i]));
		}
		return b;
	}

	static String toString(int[] factors) {
		return toBigInteger(factors).toString();
	}

	static int compare(int[] lhs, int[] rhs) {

		int[] l = new int[lhs.length];
		int[] r = new int[rhs.length];

		for (int i = 0; i < l.length && i < r.length; i++) {
			int li = lhs[i];
			int ri = rhs[i];
			if (li > ri) {
				l[i] = li - ri;
				r[i] = 0;
			} else {
				l[i] = 0;
				r[i] = ri - li;
			}
		}

		BigInteger bl = toBigInteger(l);
		BigInteger br = toBigInteger(r);

		return bl.compareTo(br);
	}


}

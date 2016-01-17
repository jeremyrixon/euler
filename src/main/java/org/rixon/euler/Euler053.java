package org.rixon.euler;

import java.math.BigInteger;

public class Euler053 {

	public static void main(String[] args) {
		
		int count = 0;
		for(int n = 1; n <= 100; n++) {
			for(int r = 1; r <= n; r++) {
				if (combinations(n, r) > 1000000l) {
					System.out.println(n);
					count++;
				}
			}
		}
		System.out.println(count);
	}

	private static long combinations(int n, int r) {
		BigInteger c = factorial(n).divide(factorial(r)).divide(factorial(n-r));
		if (c.bitLength() > 63) {
			return Long.MAX_VALUE;
		} else {
			return c.longValueExact();
		}
	}

	private static BigInteger factorial(int bn) {
		BigInteger factorial = BigInteger.ONE;
		while (bn > 1) {
			factorial = factorial.multiply(BigInteger.valueOf(bn));
			bn--;
		}
		return factorial;
	}
}

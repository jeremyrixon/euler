package org.rixon.primes;

import org.rixon.euler.BigRatio;

public class ArithmeticEncoding {

	public static void main(String[] args) {
		int n = 20;
		Sieve s = new Sieve(n);

		BigRatio lo = new BigRatio(0,  1);
		BigRatio hi = new BigRatio(1,  1);
		
		BigRatio probPrim = new BigRatio(1, 3);
		BigRatio probComp = new BigRatio(2, 3);
		
		for (int i = 2; i < n; i++) {
			BigRatio diff = hi.subtract(lo);
			if (s.isPrime(i)) {
				hi = hi.subtract(diff.multiply(probPrim));
			} else {
				lo = lo.add(diff.multiply(probComp));
			}
			System.out.format("%40s %40s%n", lo, hi);
			if (lo.greaterThan(BigRatio.HALF)) {
				System.out.println('1');
				lo = lo.multiply(BigRatio.HALF);
			} else if (hi.lessThan(BigRatio.HALF)) {
				System.out.println('0');
				hi = hi.multiply(BigRatio.TWO);
			}
			System.out.format("%40s %40s%n", lo, hi);
		}
	}

}

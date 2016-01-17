package org.rixon.euler;

import java.math.BigInteger;

public class Euler065 {
	static final BigInteger TEN = BigInteger.valueOf(10);

	public static void main(String[] args)  {
		
		Ratio r = new Ratio(0, 1);
		for (int i = 100; i > 1; i--) {
			r = r.add(i % 3 == 0 ? i / 3 * 2 : 1).inverse();
		}
		r = r.add(2);
		System.out.println(r);
		System.out.println(sumOfDigits(r.getNumerator()));
	}
	
	private static BigInteger sumOfDigits(BigInteger n) {
		BigInteger sum = BigInteger.ZERO;
		while (n.bitLength() > 0) {
			BigInteger[] t = n.divideAndRemainder(TEN);
			sum = sum.add(t[1]);
			n = t[0];
		}
		return sum;
	}

	static class Ratio {
		private BigInteger numerator;
		private BigInteger denominator;
		
		public Ratio(BigInteger numerator, BigInteger denominator) {
			this.numerator = numerator;
			this.denominator = denominator;
		}
	
		public Ratio(long numerator, long denominator) {
			this.numerator = BigInteger.valueOf(numerator);
			this.denominator = BigInteger.valueOf(denominator);
		}
	
		public BigInteger getNumerator() {
			return numerator;
		}
	
		public BigInteger getDenominator() {
			return denominator;
		}
	
		@Override
		public String toString() {
			return "(" + numerator + "/" + denominator + ")";
		}
	
		public Ratio add(BigInteger n) {
			Ratio result = new Ratio(numerator.add(n.multiply(denominator)), denominator);
			return result;
		}
	
		public Ratio add(long n) {
			return add(BigInteger.valueOf(n));
		}
	
		public Ratio addOne() {
			Ratio result = new Ratio(numerator.add(denominator), denominator);
			return result;
		}
		
		public Ratio inverse() {
			Ratio result = new Ratio(denominator, numerator);
			return result;
		}
	
	}
}

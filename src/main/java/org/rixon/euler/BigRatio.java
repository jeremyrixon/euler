package org.rixon.euler;

import java.math.BigInteger;

public class BigRatio implements Comparable<BigRatio> {
	public static BigRatio ZERO = new BigRatio(0, 1);
	public static BigRatio HALF = new BigRatio(1, 2);
	public static BigRatio ONE = new BigRatio(1, 1);
	public static BigRatio TWO = new BigRatio(2, 1);

	private BigInteger numerator;
	private BigInteger denominator;
	
	public BigRatio(BigInteger numerator, BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		reduce();
	}

	public BigRatio(long numerator, long denominator) {
		this.numerator = BigInteger.valueOf(numerator);
		this.denominator = BigInteger.valueOf(denominator);
		reduce();
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

	public BigRatio add(BigInteger n) {
		BigRatio result = new BigRatio(numerator.add(n.multiply(denominator)), denominator);
		return result;
	}

	public BigRatio add(long n) {
		return add(BigInteger.valueOf(n));
	}

	public BigRatio addOne() {
		BigRatio result = new BigRatio(numerator.add(denominator), denominator);
		return result;
	}
	
	public BigRatio inverse() {
		BigRatio result = new BigRatio(denominator, numerator);
		return result;
	}

	public BigRatio add(BigRatio r) {
		return new BigRatio(numerator.multiply(r.denominator).add(r.numerator.multiply(denominator)), denominator.multiply(r.denominator));
	}
	
	
	public BigRatio subtract(BigRatio r) {
		return new BigRatio(numerator.multiply(r.denominator).subtract(r.numerator.multiply(denominator)), denominator.multiply(r.denominator));
	}
	
	public BigRatio multiply(BigRatio r) {
		return new BigRatio(numerator.multiply(r.numerator), denominator.multiply(r.denominator));
	}
	
	private void reduce() {
		BigInteger gcd = numerator.gcd(denominator);
		if (gcd.compareTo(BigInteger.ONE) > 0) {
			numerator = numerator.divide(gcd);
			denominator = denominator.divide(gcd);
		}
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominator == null) ? 0 : denominator.hashCode());
		result = prime * result + ((numerator == null) ? 0 : numerator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BigRatio other = (BigRatio) obj;
		if (denominator == null) {
			if (other.denominator != null)
				return false;
		} else if (!denominator.equals(other.denominator))
			return false;
		if (numerator == null) {
			if (other.numerator != null)
				return false;
		} else if (!numerator.equals(other.numerator))
			return false;
		return true;
	}

	@Override
	public int compareTo(BigRatio o) {
		return numerator.multiply(o.denominator).compareTo(o.numerator.multiply(denominator));
	}
	
	public boolean greaterThan(BigRatio r) {
		return compareTo(r) > 0;
	}

	public boolean lessThan(BigRatio r) {
		return compareTo(r) < 0;
	}

}

package org.rixon.euler;

import java.math.BigInteger;
import static java.math.BigInteger.ONE;

public class BigRatio {

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
	
	private void reduce() {
		BigInteger gcd = numerator.gcd(denominator);
		if (gcd.compareTo(ONE) > 0) {
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

	

}

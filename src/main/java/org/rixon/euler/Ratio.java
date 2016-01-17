package org.rixon.euler;

import java.math.BigInteger;

public class Ratio {
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

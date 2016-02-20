package org.rixon.euler;

public class LongRatio {

	private long numerator;
	private long denominator;
	
	public LongRatio(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		reduce();
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return "(" + numerator + "/" + denominator + ")";
	}

	public LongRatio add(long n) {
		return new LongRatio(numerator + n * denominator, denominator);
	}

	public LongRatio add(LongRatio n) {
		return new LongRatio(numerator * n.denominator + n.numerator * denominator, denominator * n.denominator);
	}

	public LongRatio subtract(LongRatio n) {
		return new LongRatio(numerator * n.denominator - n.numerator * denominator, denominator * n.denominator);
	}

	public LongRatio multiply(LongRatio n) {
		return new LongRatio(numerator * n.numerator, denominator * n.denominator);
	}

	public LongRatio divide(LongRatio n) {
		return new LongRatio(numerator * n.denominator, denominator * n.numerator);
	}

	public LongRatio addOne() {
		LongRatio result = new LongRatio(numerator + denominator, denominator);
		return result;
	}
	
	public LongRatio inverse() {
		LongRatio result = new LongRatio(denominator, numerator);
		return result;
	}
	
	public boolean isZero() {
		return numerator == 0;
	}

	public boolean isInteger() {
		return denominator == 1;
	}

	public long getAsLong() {
		if (denominator < 0) {
			System.out.println("Yeah");
		}
		return numerator;
	}

	public long floor() {
		return numerator / denominator;
	}
	
	
	private void reduce() {
		if (denominator < 0) {
			denominator *= -1;
			numerator *= -1;
		}

		long gcd = Util.gcd(Math.abs(numerator), denominator);
		if (gcd > 1) {
			numerator = numerator / gcd;
			denominator = denominator / gcd;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Long.hashCode(denominator);
		result = prime * result + Long.hashCode(numerator);
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
		LongRatio difference = this.subtract((LongRatio) obj);
		return difference.numerator == 0;
	}


	

}

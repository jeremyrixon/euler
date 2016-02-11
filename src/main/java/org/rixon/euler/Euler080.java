package org.rixon.euler;

import java.math.BigDecimal;

public class Euler080 {

	public static void main(String[] args) {
		int total = 0;
		for (int n = 0; n <= 100; n++) {
			BigDecimal sqrt = sqrt(n);
			if (sqrt.remainder(BigDecimal.ONE).signum() > 0) {
				int sumDigits = sumDigits(sqrt);
				System.out.format("%3d %105s %5d%n", n, sqrt, sumDigits);
				total += sumDigits;
			}
		}
		System.out.println(total);
	}

	private static BigDecimal sqrt(int n) {
		BigDecimal nb = BigDecimal.valueOf(n);
		BigDecimal guess = BigDecimal.valueOf(0);
		BigDecimal increment = BigDecimal.TEN;
		for(int i = 0; i < 101; i++) {
			BigDecimal newguess = guess;
			int comparison = -1;
			while (comparison <= 0) {
				guess = newguess;
				newguess = newguess.add(increment);
				comparison = newguess.multiply(newguess).compareTo(nb);
			}
			increment = increment.divide(BigDecimal.TEN);
		}
		return guess;
	}

	private static int sumDigits(BigDecimal d) {
		int sum = 0;
		while (d.compareTo(BigDecimal.ONE) >= 0) {
			BigDecimal[] dar = d.divideAndRemainder(BigDecimal.TEN);
			sum += dar[0].intValueExact();
			d = dar[1].divide(BigDecimal.TEN);
		}
		while (d.signum() > 0) {
			d = d.multiply(BigDecimal.TEN);
			BigDecimal[] dar = d.divideAndRemainder(BigDecimal.TEN);
			sum += dar[0].intValueExact();
			d = dar[1];
		}
		return sum;
	}
}

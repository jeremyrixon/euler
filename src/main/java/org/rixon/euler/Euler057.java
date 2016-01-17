package org.rixon.euler;

import java.math.BigInteger;

public class Euler057 {

	public static void main(String[] args)  {
		int count = 0;
		Ratio r = new Ratio(1, 2);
		for (int i = 1; i <= 1000; i++) {
			Ratio n = r.addOne();
			if (countDigits(n.getNumerator()) > countDigits(n.getDenominator())) {
				System.out.println("" + i + " " + n);
				count++;
			}
			r = r.add(2).inverse();
		}
		System.out.println(count);
	}
	
	static int countDigits(BigInteger bigInteger) {
		return bigInteger.toString(10).length();
	}
}

package org.rixon.euler;

import java.math.BigInteger;

public class Euler100 {
	public static void main(String[] args) {
		
		BigInteger one = BigInteger.ONE;
		BigInteger two = BigInteger.valueOf(2);
		BigInteger b8284 = BigInteger.valueOf(8284);
		BigInteger b10000 = BigInteger.valueOf(10000);
		BigInteger five = BigInteger.valueOf(5);
		BigInteger blue = BigInteger.valueOf(655869061);
		BigInteger total = BigInteger.valueOf(927538921);
		
		while (true) {
			BigInteger numerator2 = blue.multiply(blue.subtract(BigInteger.ONE)).multiply(two);
			BigInteger denominator = total.multiply(total.subtract(BigInteger.ONE));
			if (numerator2.equals(denominator)) {
				System.out.format("%s %s%n",blue.toString(), total.toString());
				blue = blue.multiply(five).add(blue.multiply(b8284).divide(b10000));
				total = total.multiply(five).add(total.multiply(b8284).divide(b10000));
			} else {
				if (numerator2.compareTo(denominator) > 0) {
					total = total.add(one);
				} else {
					blue = blue.add(one);
				}
			}
		}
	}
}

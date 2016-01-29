package org.rixon.euler;

import java.math.BigInteger;

public class Euler097 {
	
	public static void main(String[] args) {
		System.out.println(BigInteger.valueOf(2)
			.modPow(BigInteger.valueOf(7830457), BigInteger.valueOf(10000000000l))
			.multiply(BigInteger.valueOf(28433))
			.add(BigInteger.ONE)
			.mod(BigInteger.valueOf(10000000000l)));
	}

}

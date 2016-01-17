package org.rixon.euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Euler048 {
	
	static final BigInteger TenBillion = BigInteger.valueOf(10000000000l);

	public static void main(String[] args) {
		
		BigInteger sum = BigInteger.ZERO;
	

		for (int i = 1; i <= 1000; i++) {
			BigInteger bi = BigInteger.valueOf(i);
			sum = sum.add(bi.modPow(bi, TenBillion)).mod(TenBillion);
		}
		
		System.out.println(sum);
	}
}

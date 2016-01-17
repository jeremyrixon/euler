package org.rixon.euler;

import java.io.IOException;
import java.math.BigInteger;

public class Euler056 {
	static BigInteger TEN = BigInteger.valueOf(10);

	public static void main(String[] args) throws IOException {
		int max = 0;
		for (int n = 99; n > 1; n--) {
			for (int m = 99; m > 1; m--) {
				int sum = 0;
				BigInteger i = BigInteger.valueOf(n).pow(m);
				while (i.bitLength() > 0) {
					BigInteger[] divideAndRemainer = i.divideAndRemainder(TEN);
					sum += divideAndRemainer[1].intValueExact();
					i = divideAndRemainer[0];
				}
				if (sum > max) {
					max = sum;
					System.out.println(max);
				}
				
			}
		}
	}
}

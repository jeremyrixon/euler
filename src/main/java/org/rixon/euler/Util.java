package org.rixon.euler;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

import java.math.BigInteger;

public class Util {
	public static BigInteger sqrt(BigInteger n) {
		BigInteger b = ZERO;
		while (n.compareTo(ZERO) >= 0) {
			n = n.subtract(b);
			b = b.add(ONE);
			n = n.subtract(b);
		}
		return b.subtract(ONE);
	}

}

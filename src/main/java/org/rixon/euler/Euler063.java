package org.rixon.euler;

import static java.math.BigInteger.ONE;

import java.math.BigInteger;

public class Euler063 {

	public static void main(String[] args)  {
		int count = 0;
		for(int n = 1; ; n++) {
			for (BigInteger i = ONE; ; i = i.add(ONE)) {
				BigInteger power = i.pow(n);
				String s = power.toString();
				int len = s.length();
				if (len == n) {
					count++;
					System.out.println("" + count + "\t" + s);
				} else {
					if (len > n) {
						break;
					}
				}
			}
		}
	}
}

package org.rixon.euler;

import java.math.BigInteger;

public class Euler111 {
	public static void main(String[] args) {


		System.out.println(
			     f(0, 8, 10)
			.add(f(1, 9, 10))
			.add(f(2, 8, 10))
			.add(f(3, 9, 10))
			.add(f(4, 9, 10))
			.add(f(5, 9, 10))
			.add(f(6, 9, 10))
			.add(f(7, 9, 10))
			.add(f(8, 8, 10))
			.add(f(9, 9, 10))
		);


//		for (int d = 0; d < 10; d++) {
//			BigInteger l = f(d, 8, 10);
//			System.out.format("f(%d,9,10)=%s%n",d,l.toString());
//		}

/*
		System.out.println(
				f(0, 2, 4) +
				f(1, 3, 4) +
				f(2, 3, 4) +
				f(3, 3, 4) +
				f(4, 3, 4) +
				f(5, 3, 4) +
				f(6, 3, 4) +
				f(7, 3, 4) +
				f(8, 3, 4) +
				f(9, 3, 4)
		);
*/

	}

	private static BigInteger f(int d, int m, int n) {
		return f(d, m, n, 0, 0, 0);
	}

	private static BigInteger f(int d, int m, int n, int current_m, int current_n, long l) {

		if (current_n == n) {
			if (BigInteger.valueOf(l).isProbablePrime(100)) {
				return BigInteger.valueOf(l);
			} else {
				return BigInteger.ZERO;
			}
		}

		if ((m-current_m) == (n-current_n)) {
			return f(d, m, n, current_m + 1, current_n + 1, l * 10 + d);
		}

		BigInteger result = BigInteger.ZERO;
		for (int digit = 0; digit < 10; digit++) {
			if (current_n == 0 && digit == 0) {
				continue;
			}
			if (current_m == m && digit == d) {
				continue;
			}
			result = result.add(f(d, m, n, digit == d ? current_m + 1 : current_m, current_n + 1, l * 10 + digit));
		}
		return result;
	}

	private static long pow(int base, int exp) {
		long result = 1;
		for (int i = 0; i < exp; i++) {
			result *= base;
		}
		return result;
	}




}

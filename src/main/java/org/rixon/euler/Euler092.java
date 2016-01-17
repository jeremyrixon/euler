package org.rixon.euler;

public class Euler092 {

	public static void main(String[] args)  {
		long count = 0;
		for (long n = 2; n < 10000000; n++) {
			if (is89(n)) {
				count++;
			}
		}
		
		System.out.println("Count: " + count);
	}

	
	private static boolean is89(long n) {
		while (true) {
			if (n == 89) {
				return true;
			}
			if (n == 1) {
				return false;
			}
			n = next(n);
		}
	}


	private static long next(long n) {
		long next = 0;
		while (n > 0) {
			long m = n % 10;
			next += m * m;
			n /= 10;
		}
		return next;
	}
}

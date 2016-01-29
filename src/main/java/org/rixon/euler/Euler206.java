package org.rixon.euler;

public class Euler206 {
	
	public static void main(String[] args) {
		for (long n = 1000000000l; n < 10000000000l; n+=10) {
			long m = n * n;
			if (check(m)) {
				System.out.println(n);
				System.out.println(m);
			}
		}
	}

	private static boolean check(long n) {
		n /= 100;
		if (n % 10 != 9) {
			return false;
		}
		n /= 100;
		if (n % 10 != 8) {
			return false;
		}
		n /= 100;
		if (n % 10 != 7) {
			return false;
		}
		n /= 100;
		if (n % 10 != 6) {
			return false;
		}
		n /= 100;
		if (n % 10 != 5) {
			return false;
		}
		n /= 100;
		if (n % 10 != 4) {
			return false;
		}
		n /= 100;
		if (n % 10 != 3) {
			return false;
		}
		n /= 100;
		if (n % 10 != 2) {
			return false;
		}
		n /= 100;
		if (n % 10 != 1) {
			return false;
		}
		return true;
	}

}

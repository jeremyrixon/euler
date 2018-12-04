package org.rixon.euler;

public class Euler112 {
	public static void main(String[] args) {
		int count = 0;
		int n = 101;
		for (;; n++) {
			if (bouncy(n)) {
				count++;
			}
			int p = count * 100 / n;
			if (p == 99) {
				break;
			}
		}
		System.out.format("%d %d%n", count, n);
	}


	static boolean bouncy(int b) {
		boolean inc = false;
		boolean dec = false;

		int previousDigit = b % 10;
		b/=10;
		while (b > 0) {
			int digit = b % 10;
			b /= 10;
			if (digit > previousDigit) {
				if (dec) {
					return true;
				} else {
					inc = true;
				}
			} else if (digit < previousDigit) {
				if (inc) {
					return true;
				} else {
					dec = true;
				}
			}
			previousDigit = digit;
		}
		return false;
	}
}

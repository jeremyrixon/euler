package org.rixon.euler;

import java.io.IOException;

public class Euler055 {

	public static void main(String[] args) throws IOException {
		int count = 0;
		for (long i = 1; i < 10000; i++) {
			if (isLychrel(i)) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static boolean isLychrel(long n) {
		long m = reverse(n);
		for (int i = 0; i < 50; i++) {
			n += m;
			m = reverse(n);
			if (n == m) {
				return false;
			}
		}
		return true;
	}

	private static long reverse(long n) {
		long m = 0;
		while (n > 0) {
			m = m * 10 + n % 10;
			n /= 10;
		}
		return m;
	}


}

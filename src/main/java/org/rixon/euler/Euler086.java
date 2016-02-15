package org.rixon.euler;

public class Euler086 {

	public static void main(String[] args) {

		final int M = 10000;
		int count = 0;
		
		for (int a = 1; a <= M; a++) {
			for (int b = 1; b <= a; b++) {
				for (int c = 1; c <= b; c++) {
					int d = a * a + (b + c) * (b + c);
					//System.out.format("%6d, %6d, %6d, %10d %b%n", a, b, c, d, Util.isPerfectSquare(d));
					if (Util.isPerfectSquare(d)) {
						count++;
					}
				}
			}
			System.out.format("%6d, %6d%n", a, count);
			if (count > 1000000) {
				break;
			}
		}
		//System.out.println(count);
	}
}

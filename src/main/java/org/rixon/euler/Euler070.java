package org.rixon.euler;

public class Euler070 {
	public static void main(String[] args) {
		float min = Float.MAX_VALUE;
		Primes p = new Primes();
		for (long n = 2; n <= 10000000; n++) {
			long t = Util.totient(n, p);
			if (Util.arePermutations(n, t)) {
				float r = (float) n / (float) t;
				if (r < min) {
					min = r;
					System.out.format("%10d %10d %10.00f%n", n, t, min);
				}
			}
		}
	}
}

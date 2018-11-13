package org.rixon.euler;

public class Euler108 {
	public static void main(String[] args) {
		for (long n = 4; ; n++) {
			long count = 0;
			for (long x = n + 1; x <= n * 2; x++) {
				if (isSolution(n, x)) {
					count++;
				}
			}
			if (count > 1000) {
				System.out.format("n=%4d  solutions=%4d%n", n, count);
				break;
			}

		}
	}

	private static boolean isSolution(long n, long x) {
		return (n * x) % (x - n) == 0;
	}

}

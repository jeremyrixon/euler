package org.rixon.euler;

public class Euler111 {
	public static void main(String[] args) {

//		System.out.println(
//			f(0, 8, 10) +
//			f(1, 8, 10) +
//			f(2, 8, 10) +
//			f(3, 8, 10) +
//			f(4, 8, 10) +
//			f(5, 7, 10) +
//			f(6, 8, 10) +
//			f(7, 9, 10) +
//			f(8, 7, 10) +
//			f(9, 8, 10)
//		);

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

	}

	private static long f(int d, int m, int n) {
		long result = 0;
		String t = "";
		for (int i = 0; i < m; i++) {
			t = t + d;
		}
		int j = n - m;
		for(long i = 0; i < pow(10,j); i++) {
			String s = String.format("%0"+j+"d", i);
			for (int k = 0; k <= j; k++) {
				String u = s.substring(0,k) + t + s.substring(k);
				if (!u.startsWith("0")) {
					long ui = Long.valueOf(u);
					if (MillerRabin.is_prime_mr(ui)) {
						System.out.println(u);
						result += ui;
					}
				}
			}
		}
		System.out.println("*****:" + result);
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

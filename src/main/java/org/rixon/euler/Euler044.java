package org.rixon.euler;


public class Euler044 {

	public static void main(String[] args) {
		int min_d = Integer.MAX_VALUE;
		
		/*
		for (int i = 2; i < 1000; i++) {
			if (is_p(i, 0, 100)) {
				System.out.println(i);
			}
		}
		*/
		
		
		for (int k = 2; k < 100000; k++) {
			int pk = k * (3 * k - 1) / 2;  
			for (int j = 1; j < k; j++) {
				int pj = j * (3 * j - 1) / 2;  
				int d = pk - pj;
				int s = pk + pj;
				if (is_p(d, 0, k) && is_p(s, 0, 2 * k) ) {
					System.out.println(pk + ", " + pj + ", " + d+ ", " + (pk + pj));
				}
			}
		}
	}

	private static boolean is_p(int d, int min, int max) {
		int n = (min + max) /2;
		int p = n * (3 * n - 1) /2;
		if (d == p) {
			return true;
		}
		if (min == max) {
			return false;
		}
		if (p > d) {
			return is_p(d, min, n);
		} else {
			return n != min && is_p(d, n, max);
		}
	}
	
	

}

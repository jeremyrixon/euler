package org.rixon.euler;

public class Euler076 {
	
	public static void main(String[] args) {
		int count = 0;
		int N = 100;
		count += countRemaining(N, N-1);
		System.out.println(count);
	}

	private static int countRemaining(int n, int m) {
		if (m > n) {
			m = n;
		}
		if (m <= 1) {
			return 1;
		}
		if (m == 2) {
			return n / 2 + 1;
		}

		int count = 0;
		for (int i = m; i >= 1; i--) {
			count += countRemaining(n - i, i);
		}
		return count;
	}
	
}
